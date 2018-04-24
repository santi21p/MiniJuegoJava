import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
public class jugador{

	public static void Ingreso(String name,String password) throws IOException{
		String ruta = "/home/santi/Desktop/Julian.txt";
	    File archivo = new File(ruta);
	    BufferedWriter bw;
	    if(archivo.exists()) {
	        bw = new BufferedWriter(new FileWriter(archivo,true));
	        bw.write("El fichero de texto ya estaba creado.\n");
	    } else {
	        bw = new BufferedWriter(new FileWriter(archivo,true));
	        bw.write("Acabo de crear el fichero de texto.\n");
	    }
	    bw.close();
	}
	public static boolean ConsultaNombre(String name) throws IOException{
		boolean existe=false;
		String ruta = "/home/santi/Desktop/Julian.txt";
	    File archivo = new File(ruta);
	    FileReader fr = null;
	    BufferedReader br = null;
	    fr = new FileReader (archivo);
	    br = new BufferedReader(fr);
	    String linea;
	    while((linea=br.readLine())!=null){
	    	String nombre="";
	    	int i=0;
	    	String centinela=null;
	    	while(i<linea.length() && centinela!=" "){
	    		nombre=nombre+linea.substring(i,i+1);
	    	}
	    	System.out.println(nombre);
	    }
	    fr.close();
	    return existe;
	}
}
