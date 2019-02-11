package com.ribera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ribera.modelos.Oficinas;
import com.ribera.modelos.OficinasData;
import com.ribera.modelos.Regiones;
import com.ribera.modelos.RegionesData;
import com.ribera.modelos.RepVentas;

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
			
			String query = "SELECT regiones.COD_REGION, regiones.NOMBRE_RE, COUNT(oficinas.oficina) AS OFICINAS, SUM(oficinas.TOTAL_VENTAS) AS VENTAS " + 
					"FROM regiones " + 
					"LEFT JOIN oficinas ON regiones.cod_region = oficinas.cod_region " + 
					"GROUP BY regiones.cod_region, regiones.nombre_re";
			
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
			
			String query = "SELECT oficinas.OFICINA, oficinas.CIUDAD, regiones.nombre_re AS REGION, COUNT(repventas.numero_rep) AS NUMREP, director.nombre AS DIRECTOR " + 
					"FROM oficinas " + 
					"INNER JOIN regiones ON oficinas.cod_region = regiones.cod_region " + 
					"LEFT JOIN repventas ON oficinas.oficina = repventas.oficina_rep " + 
					"LEFT JOIN repventas director ON oficinas.director = director.numero_rep " + 
					"GROUP BY oficinas.oficina, oficinas.ciudad, regiones.nombre_re, director.nombre";
			
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
	
	public List<RepVentas> getRepVentas() {
		List<RepVentas> representantes = new ArrayList<RepVentas>();
		
		try {	
			Connection con = getConexion();
			
			String query = "SELECT * FROM repventas";

			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				RepVentas repVentas = new RepVentas();
				repVentas.setNumRep(result.getInt("NUMERO_REP"));
				repVentas.setNombre(result.getString("NOMBRE"));
				repVentas.setEdad(result.getInt("EDAD"));
				repVentas.setNumVentas(result.getInt("NUM_VENTAS"));
				repVentas.setImpVentas(result.getFloat("IMP_VENTAS"));
				
				// Obtenemos su oficina
				String queryOficina = "SELECT * FROM oficinas WHERE oficina = ?";
				PreparedStatement statementOficina = con.prepareStatement(queryOficina);
				statementOficina.setInt(1, result.getInt("OFICINA_REP"));
				ResultSet resultOficina = statementOficina.executeQuery();
				if(resultOficina.next()) {
					Oficinas oficina = new Oficinas();
					// Solo sacamos los datos que nos interesan, los que mostraremos o usaremos para modificar
					oficina.setOficina(result.getInt("OFICINA_REP"));
					oficina.setCiudad(resultOficina.getString("CIUDAD"));
					
					repVentas.setOficina(oficina);
				}
				
				// Obtenemos su director
				String queryDirector = "SELECT * FROM repventas WHERE numero_rep = ?";
				PreparedStatement statementDirector = con.prepareStatement(queryDirector);
				statementDirector.setInt(1, result.getInt("DIRECTOR"));
				ResultSet resultDirector = statementDirector.executeQuery();
				if(resultDirector.next()) {
					RepVentas director = new RepVentas();
					director.setNumRep(result.getInt("DIRECTOR"));
					director.setNombre(resultDirector.getString("NOMBRE"));
					
					repVentas.setDirector(director);
				}
				
				representantes.add(repVentas);
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return representantes;
	}
	
	
}
