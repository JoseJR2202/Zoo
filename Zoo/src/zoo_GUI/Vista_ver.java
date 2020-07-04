package zoo_GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;
import com.Zoo.packege1.*;
public class Vista_ver {
	private JPanel vista3;
	private JButton B_aceptar, retorno,borra;
	private JTextField buscador, seleccion;
	private JTable tabla;
	private Border borde;
	private DefaultTableModel modeA,modeAn,modeM,modeR;
	private String cabecera[]= {
			"nombre","Categoria","habitad","Reproducen","Grupo Alimenticio",
			"Transporte","Cantidad"
	};
	private String category[]= {
			"MAMIFERO",
			"ANFIBIO",
			"AVES",
			"REPTILES"	
	};
	public Vista_ver(ArrayList<ArrayList<Animales>> p, JFrame v1,JPanel v2) {
		vista3=new JPanel(new BorderLayout());
		borde=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		B_aceptar=new JButton("Aceptar");
		retorno=new JButton("Regresar");
		buscador= new JTextField(20);
		//tabla
		modeA=new DefaultTableModel();
		modeAn=new DefaultTableModel();
		modeM=new DefaultTableModel();
		modeR=new DefaultTableModel();
		for(int i=0;i<cabecera.length;i++) {
			modeA.addColumn(cabecera[i]);
			modeAn.addColumn(cabecera[i]);
			modeM.addColumn(cabecera[i]);
			modeR.addColumn(cabecera[i]);
		}
		insertFilas(p,modeM,category[0]);
		insertFilas(p,modeAn,category[1]);
		insertFilas(p,modeA,category[2]);
		insertFilas(p,modeR,category[3]);
		//funcion del boton aceptar
		B_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto=buscador.getText().toUpperCase();
				int eleccion=Vista_agregar.verificador(texto, category);
				vista3.removeAll();
				vista3.repaint();
				vista3.add(partNorte(),BorderLayout.NORTH);
				vista3.add(partSur(),BorderLayout.SOUTH);
				vista3.add(partCentro(eleccion),BorderLayout.CENTER);
				vista3.validate();
			}
		});
		//funcion del boton retorno
		retorno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v1.setContentPane(v2);
				v1.invalidate();
				v1.validate();
			}
		});
		borra=new JButton("Eliminar");//no funcional actualmente...
		vista3.add(partNorte(),BorderLayout.NORTH);
		vista3.add(partSur(),BorderLayout.SOUTH);
	}
	private JPanel partNorte() {
		JPanel p=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.setBorder(BorderFactory.createTitledBorder(borde,"Lista")); 
		p.add(new JLabel("Lista:"));
		p.add(buscador);
		p.add(B_aceptar);
		return p;
	}
	private JPanel partCentro(int op) {
		JPanel p=new JPanel(new BorderLayout());
		switch(op) {
		case 0:tabla=new JTable(modeM);break;
		case 1:tabla=new JTable(modeAn);break;
		case 2:tabla=new JTable(modeA);break;
		case 3:tabla=new JTable(modeR);break;
		default: JLabel error=new JLabel("No valido");
				p.add(error);return p;
		}
		p.setBorder(borde);
		JScrollPane scroll= new JScrollPane(tabla);
		p.add(scroll,BorderLayout.CENTER);
		p.validate();
		return p;
	}
	private JPanel partSur() {
		JPanel p=new JPanel(new BorderLayout());
		p.setBorder(borde);
		seleccion=new JTextField(20);
		p.add(seleccion);
		p.add(borra,BorderLayout.EAST);
		p.add(retorno,BorderLayout.WEST);
		return p;
	}
	private void insertFilas(ArrayList<ArrayList<Animales>> m,DefaultTableModel l,String g){
		Object data[]=new Object[7];
		int opcion=Vista_agregar.verificador(g,category);
		if(opcion>=0) {
			for(int i=0;i<m.get(opcion).size();i++) {
				data[0]=m.get(opcion).get(i).getNombre();
				data[1]=m.get(opcion).get(i).getCategoria();
				data[2]=m.get(opcion).get(i).getHabitad();
				data[3]=m.get(opcion).get(i).Reproducen();
				data[4]=m.get(opcion).get(i).getGrupoAliment();
				data[5]=m.get(opcion).get(i).transporte();
				data[6]=Byte.toString(m.get(opcion).get(i).getCantidad());
				l.addRow(data);
			}
		}
	}
	public JPanel getVista3() {
		return vista3;
	}
}
