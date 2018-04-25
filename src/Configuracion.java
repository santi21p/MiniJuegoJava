import java.io.File;


public class Configuracion {
	// tabSize (de 3 a 5)
	// timeSleep (de 1 a 5)
	// lvlDific (> 0 && <= (Match.pow(tabSize,2) / 2) Mayor de 0 y menor o igual al 50%)
	
	public static void setConfig(int size, int sleep, int lvl){
		File archivo = new File("configuracion"+Jugador.username()+".txt");
	}
}
