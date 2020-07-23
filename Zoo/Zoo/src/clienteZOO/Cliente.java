package clienteZOO;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class Cliente {
	private Socket socket=null;
	private DataInputStream in_servidor = null;
	private DataOutputStream out=null;
	private BufferedReader in_cliente=null;
	private String line="";
	Cliente(){
		try {
			socket=new Socket("localhost",3000);
			//objeto para leer la respuesta del servidor
			in_servidor=new DataInputStream(new BufferedInputStream (socket.getInputStream()));
			//objeto para leer el mensaje a enviar por el cliente
			//se va a quitar cuando ponga la interfaz
			in_cliente=new BufferedReader(new InputStreamReader(System.in));
			//objeto para enviar
			out= new DataOutputStream(socket.getOutputStream());
			//esto sera cambiado...
			boolean op=true;
			while(op) {
				line=in_cliente.readLine();
				out.writeUTF(line);
				if(!line.equals("fin")) {
					line=in_servidor.readUTF();
					System.out.println(line);
				}
				else
					op=false;
			}
			System.out.println("Cerrando Conexion");
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
