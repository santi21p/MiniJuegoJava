import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Jugador {
	
	// Variable de fichero para usuarios
	private static File archivo = new File("usuarios.txt");

	// Variable del juego para comprobar si el usuario esta autenticado
	private static boolean login = false;
	// Variable del juego con nombre de usuario (id)
	private static String username = null;
	
	/*Jugador() throws IOException{
		// Creamos el fichero de usuarios si no existe
		if(!archivo.exists()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true));
			bw.close();
		}
	}*/
	
	// Metodo para registrar un usuario
	public static void regUser(String usrname, String passwd, String secPasswd) throws IOException {
		if(existeUsuario(usrname)) { // Comprobamos que el usuario no exista
			throw new IOException("El usuario ya existe.");
		}else if(!passwd.equals(secPasswd)) { // Comprobamos que ambas claves son iguales
			throw new IOException("La clave no es equivalente.");
		}else if(usrname.length() < 5 || usrname.length() > 10) { // Comprobamos la longitud del nombre dentro de los valores contemplados
			throw new IOException("El nombre de usuario debe tener entre 5 y 10 caracteres.");
		}else if(passwd.length() < 5 || passwd.length() > 10) { // Comprobamos la longitud de la clave dentro de los valores contemplados
			throw new IOException("La clave de usuario debe tener entre 5 y 10 caracteres.");
		}else { // En caso de que todo sea correcto realizamos el registro en el fichero
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true));
			bw.write(usrname+":"+passwd);
			bw.newLine();
			bw.close();
			autenticar(usrname,passwd); // Dado que no hay validacion de cuenta autenticamos en registro
		}
	}
	
	// Metodo para comprobar si un nombre de usuario esta en uso
	public static boolean existeUsuario(String usrname) throws IOException {
		boolean stat = false;
	    FileReader fr = new FileReader (archivo);
	    BufferedReader br = new BufferedReader(fr);
	    String linea;
	    String nombre;
	    while((linea = br.readLine()) != null && !stat){
	    	nombre = linea.split(":")[0];
	    	if(usrname.equals(nombre)) {
	    		stat = true;
	    	}
	    }
	    return stat;
	}
	
	// Metodo para validar credenciales de un usuario
	public static void autenticar(String usrname, String passwd) throws IOException {
	    FileReader fr = new FileReader (archivo);
	    BufferedReader br = new BufferedReader(fr);
	    String linea;
	    String nombre;
	    String clave;
	    if(!existeUsuario(usrname)) { // Comprobamos que el usuario no exista
			throw new IOException("El usuario no existe.");
		}else{ // Si el usuario existe validamos la clave frente al mismo
		    while((linea = br.readLine()) != null && !login){
		    	nombre = linea.split(":")[0];
		    	clave = linea.split(":")[1];
		    	if(usrname.equals(nombre) && passwd.equals(clave)) {
		    			login = true;
		    			username = nombre;
		    	}
		    }
		    if(!login) { // Si el usuario indicado no tiene la clave dada lanzamos un error
	    		throw new IOException("La clave introducida no es valida.");
	    	}
		}
	}
	
	// Metodos de utilidad para obtener o modificar estado de sesion
	public boolean statLog() {
		return login;
	}
	public String username() {
		return username;
	}
	public void logOut() {
		login = false;
		username = null;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(Jugador.existeUsuario("PEPE"));
		//usuarios.regUser("PACOS","AQWEE","AQWEE");
		Jugador.autenticar("PACOS","AQWEE");
		Jugador.regUser("MANOLOS","AQWER","AQWER");
		System.out.println(Jugador.existeUsuario("PEPE"));
	}
}