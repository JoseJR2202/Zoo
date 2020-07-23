package zoo_GUI;
import com.Zoo.packege1.*;
public class Main {

	public static void main(String[] args) {
		VentanaMenu zoo=new VentanaMenu();
		(new conexion()).start();
	}
	static class conexion extends Thread{
		public void run() {
			ServerZOO op=new ServerZOO();
		}
	}
}