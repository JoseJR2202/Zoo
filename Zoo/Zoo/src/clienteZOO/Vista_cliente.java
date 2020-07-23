package clienteZOO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class Vista_cliente {
	private JFrame ver;
	private JPanel vista;
	private JButton enviar;
	private Border bordes;
	private JTextArea historial;
	private Socket socket=null;
	private String usuario;
	Vista_cliente(){
		try {
			socket=new Socket("localhost",3000);
			ver= new JFrame("CHAT");
			vista= new JPanel(new BorderLayout());
			bordes=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			enviar=new JButton("Enviar");
			historial=new JTextArea();
			//acciones
			vista.add(partNorte(), BorderLayout.NORTH);
			ver.setSize(500, 400);
			ver.setContentPane(vista);
			ver.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private JPanel partNorte() {
		JPanel aux=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nick=new JLabel("Nombre:");
		aux.add(nick);
		JTextField text=new JTextField(20);
		aux.add(text);
		JButton ingresar=new JButton("ingresar");
		ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line=text.getText();
				usuario=(line!=null)? line: "Usuario";
				historial.append("Bienvenido "+usuario+"\n\n");
				vista.removeAll();
				vista.repaint();
				vista.add(partCenter());
				vista.add(partInf(),BorderLayout.SOUTH);
				vista.validate();
			}
		});
		aux.add(ingresar);
		JButton salir=new JButton("Salir");
		aux.add(salir);
		aux.setBorder(bordes);
		return aux;
	}
	private JPanel partCenter() {
		JPanel aux=new JPanel(new BorderLayout());
		aux.setBorder(BorderFactory.createTitledBorder(bordes,"Historial"));
		ScrollPane scroll=new ScrollPane();
		scroll.add(historial);
		aux.add(scroll);
		aux.add(new JLabel("Ingrese: /nombre del animal"),BorderLayout.EAST);
		return aux;
	}
	private JPanel partInf() {
		JPanel aux=new JPanel(new BorderLayout());
		JTextField text=new JTextField();
		aux.add(text);
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line=text.getText();
				historial.append(usuario+"-->"+line+"\n\n");
				transmitir algo=new transmitir(socket,line,historial);
				algo.start();
				text.setText(null);
				vista.removeAll();
				vista.repaint();
				vista.add(partCenter());
				vista.add(partInf(),BorderLayout.SOUTH);
				vista.validate();
			}
		});
		aux.add(enviar,BorderLayout.EAST);
		return aux;
	}
	class transmitir extends Thread{
		private Socket socket=null;
		private DataOutputStream out=null;
		private DataInputStream in_servidor = null;
		JTextArea list;
		String txt;
		transmitir( Socket aux,String txt, JTextArea list) {
			socket=aux;
			this.txt=txt;
			this.list=list;
		}
		public void run() {
			try {
				in_servidor=new DataInputStream(socket.getInputStream());
				//enviar...
				out=new DataOutputStream(socket.getOutputStream());
				out.writeUTF(txt);
				//recibir...
				if(!txt.equals("fin")) {
					String linia=null;
					linia=in_servidor.readUTF();
					System.out.println(linia);
					list.append(linia);
				}
				else {
					in_servidor.close();
					out.close();
					vista.removeAll();
					vista.repaint();
					vista.add(new JLabel("Salir"));
					vista.validate();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
