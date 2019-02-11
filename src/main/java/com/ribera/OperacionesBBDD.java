package com.ribera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ribera.modelos.OficinasData;
import com.ribera.modelos.RegionesData;
import com.ribera.modelos.RepVentasData;

/**
 * Clase controladora de BBDD
 * @author Luis Miguel Barquillo
 */
public class OperacionesBBDD {
	private final String CONN = "jdbc:mysql://localhost:3306/ejercicio2eva"; 
	
	private Connection getConexion() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(CONN, "root", "");
		} catch (ClassNotFoundException cn) {
			
			System.out.println("ERROR DRIVER. " + cn.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR CONEXIÓN. " + e.getMessage());
		}
		return conexion;
	}
	
	public List<RegionesData> getRegionesData() {
		List<RegionesData> regiones = new ArrayList<RegionesData>();
		try {	
			Connection con = getConexion();
			
			String query = "SELECT regiones.COD_REGION, regiones.NOMBRE_RE, COUNT(oficinas.oficina) AS OFICINAS, SUM(oficinas.TOTAL_VENTAS) AS VENTAS "
					+ "FROM regiones "
					+ "LEFT JOIN oficinas ON regiones.cod_region = oficinas.cod_region "
					+ "GROUP BY regiones.cod_region, regiones.nombre_re";
			
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				RegionesData region = new RegionesData();
				region.setCodRegion(result.getInt("COD_REGION"));
				region.setNombre(result.getString("NOMBRE_RE"));
				region.setNumOficinas(result.getInt("OFICINAS"));
				region.setTotalVentas(result.getFloat("VENTAS"));
				
				regiones.add(region);
			}
			
			statement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return regiones;
	}
	
	public List<OficinasData> getOficinasData() {
		List<OficinasData> oficinas = new ArrayList<OficinasData>();
		
		try {	
			Connection con = getConexion();
			
			String query = "SELECT oficinas.OFICINA, oficinas.CIUDAD, regiones.nombre_re AS REGION, COUNT(repventas.numero_rep) AS NUMREP, director.nombre AS DIRECTOR "
					+ "FROM oficinas "
					+ "INNER JOIN regiones ON oficinas.cod_region = regiones.cod_region "
					+ "LEFT JOIN repventas ON oficinas.oficina = repventas.oficina_rep "
					+ "LEFT JOIN repventas director ON oficinas.director = director.numero_rep "
					+ "GROUP BY oficinas.oficina, oficinas.ciudad, regiones.nombre_re, director.nombre";
			
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				OficinasData oficina = new OficinasData();
				oficina.setOficina(result.getInt("OFICINA"));
				oficina.setCiudad(result.getString("CIUDAD"));
				oficina.setRegion(result.getString("REGION"));
				oficina.setNumRepresentantes(result.getInt("NUMREP"));
				oficina.setDirector(result.getString("DIRECTOR"));
				
				oficinas.add(oficina);
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return oficinas;
	}	
	
	public List<RepVentasData> getRepVentasData() {
		List<RepVentasData> representantes = new ArrayList<RepVentasData>();
		
		try {	
			Connection con = getConexion();
			
			String query = "SELECT repventas.NUMERO_REP, repventas.NOMBRE, repventas.EDAD, repventas.NUM_VENTAS, repventas.IMP_VENTAS, director.NOMBRE AS DIRECTOR, oficinas.CIUDAD AS OFICINA "
					+ "FROM repventas "
					+ "LEFT JOIN oficinas ON repventas.oficina_rep = oficinas.oficina "
					+ "LEFT JOIN repventas director ON repventas.director = director.numero_rep ";

			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				RepVentasData repVentas = new RepVentasData();
				repVentas.setNumRep(result.getInt("NUMERO_REP"));
				repVentas.setNombre(result.getString("NOMBRE"));
				repVentas.setEdad(result.getInt("EDAD"));
				repVentas.setNumVentas(result.getInt("NUM_VENTAS"));
				repVentas.setImpVentas(result.getFloat("IMP_VENTAS"));
				repVentas.setOficina(result.getString("OFICINA"));
				repVentas.setDirector(result.getString("DIRECTOR"));
			
				representantes.add(repVentas);
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return representantes;
	}	
	
	/**
	 * Devuelve un Map de oficinas para usar en los Select
	 * @return
	 */
	public Map<Integer, String> getOficinasMap() {
		Map<Integer, String> oficinas = new HashMap<Integer, String>();
		
		try {	
			Connection con = getConexion();
			
			String query = "SELECT oficinas.OFICINA, oficinas.CIUDAD FROM oficinas";

			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				oficinas.put(result.getInt("OFICINA"), result.getString("CIUDAD"));
			}
		
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return oficinas;
	}
	
	/**
	 * Devuelve un Map de representantes para usar en los Select
	 * @return
	 */
	public Map<Integer, String> getRepVentasMap() {
		Map<Integer, String> repVentas = new HashMap<Integer, String>();
		
		try {	
			Connection con = getConexion();
			
			String query = "SELECT repventas.NUMERO_REP, repventas.NOMBRE FROM repventas";

			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				repVentas.put(result.getInt("NUMERO_REP"), result.getString("NOMBRE"));
			}
		
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return repVentas;
	}
}
