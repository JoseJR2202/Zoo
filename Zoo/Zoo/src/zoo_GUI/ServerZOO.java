package zoo_GUI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import baseDatos.base;
public class ServerZOO {
	 private Socket socket = null;
	 private ServerSocket server = null;
	 public ServerZOO(){
		 try {
			 server = new ServerSocket(3000);
			 System.out.println("Servidor Inicio");
			 System.out.println("Esperando por un cliente ...");
			 //proceso de espera de cliente
			 while(true) {
				 try {
					 socket=server.accept();
					 System.out.println("Se conecto "+ socket.getRemoteSocketAddress());
					 //hilo de conexion
					 (new conexion(socket)).start();
				 }catch (IOException e) {
					 System.out.println(e);
				 } 
			 }
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
	 }
	 //clase interna... 
	 class conexion extends Thread{
		 private Socket aux=null;
		 private String []titulos= {
				 "Nombre Cientifico: ",
				 "Nombre: ",
				 "Cantidad: ",
				 "Categoria: ",
				 "Estrcutura: ",
				 "Grupo alimenticio: ",
				 "Reproduccion: "
		 };
		 base bd=base.getInstances();
		 conexion(Socket extra){
			 this.aux=extra;
		 }
		 //sobreescribiendo el metodo run...
		 public void run() {
			 try {
				 Boolean op=true;
				 DataInputStream in=new DataInputStream(aux.getInputStream());
				while(op) {
					String mensaje="";
					mensaje=in.readUTF();
					System.out.println("se pidio: "+mensaje);
					if(mensaje.startsWith("/")) {
						String line=mensaje.substring(1);
						String [] data=new String[7];
						 bd.Imprime("Select NombreC, NombreN, cantidad,animal.nombre,estructura.descripcion,aliment.descripcion,"
							 		+ "reproduccion.descripcion from animal ,categoria , estructura,aliment, reproduccion where "
							 		+ "categoria.nombre = animal.nombre and categoria.idestructura=estructura.idestructura and "
							 		+ "animal.idaliment=aliment.idaliment and categoria.idreproduccion=reproduccion.idreproduccion and "
							 		+ "NombreC like '"+line+"'", data);
						 if(data[0]!=null) {
							 StringBuffer extra = new StringBuffer();
								for(int i=0;i<data.length;i++) {
									extra.append(titulos[i]+data[i]+"\n");
								}
								System.out.println(extra.toString());
								DataOutputStream out=new DataOutputStream(aux.getOutputStream());
								out.writeUTF(extra.toString());
						 }
					}
					else if(mensaje.equals("fin")) {
						op=false;
						System.out.println("cerrando");
					}
				}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 }
	 }
}