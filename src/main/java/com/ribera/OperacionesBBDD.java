package com.ribera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ribera.modelos.Regiones;

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
	
	public List<Regiones> getRegiones() {
		List<Regiones> regiones = new ArrayList<Regiones>();
		try {	
			Connection con = getConexion();
			
			String query = "SELECT * FROM regiones";
			Statement sentencia = con.createStatement();
			ResultSet result = sentencia.executeQuery(query);
			
			while(result.next()) {
				regiones.add(new Regiones(result.getInt("COD_REGION"), result.getString("NOMBRE_RE")));
			}
			
			sentencia.close();
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return regiones;
	}	
	
	
	
	
}
