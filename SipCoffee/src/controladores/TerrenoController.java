package controladores;

import java.util.Vector;

import modelos.Conexion;
import modelos.Rol;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

public class TerrenoController {

	//Atributos
	private Conexion driver;
	private Connection conexion; 
	
	//Constructor
	public TerrenoController(){
		driver = new Conexion("localhost","","","test");
	}
	
	
	
	//Acciones
	
	/** Consulta todos los Roles y los devuelve en forma de Vector */
	public Vector all(){
		ResultSet result;
		Vector<Vector<String>> retorno;
		try{
			conexion = (Connection)driver.conectar();
			retorno = new Vector<Vector<String>>();
			result = (ResultSet)conexion.createStatement().executeQuery("SELECT * FROM Rol;");
			
			
			while(result.next()){
				retorno.add( new Rol(result.getInt("Id") , result.getString("Nombre")).toVector() );
			}
			
			conexion.close();
			driver.desconectar();
				
			return retorno;
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage() );
			return null;
		}finally{
			
		}
	}
	
}