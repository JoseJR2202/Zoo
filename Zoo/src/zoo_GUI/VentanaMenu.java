package zoo_GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.*;

import com.Zoo.packege1.*;
public class VentanaMenu {
	private JButton B1,B2;
	private JFrame vista;
	private Border borde;
	private JPanel vista1;
	public VentanaMenu(ArrayList<ArrayList<Animales>> p) {
		B1=new JButton("Agregar animales");
		B2=new JButton("Mostrar animales");
		vista=new JFrame("Menu Principal");
		vista1=new JPanel(new BorderLayout());
		borde=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		vista1.add(partCentral());
		vista1.add(partEste(),BorderLayout.EAST);
		vista.add(vista1);
		vista.setSize(500, 300);
		vista.setVisible(true);
		//funcion del boton agregar
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vista_agregar v1=new Vista_agregar(vista,vista1,p);
				vista.setContentPane(v1.getVista2());
				vista.invalidate();
				vista.validate();
			}	
		});
		//funcion del boton mostrar
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vista_ver v1=new Vista_ver(p,vista,vista1);
				vista.setContentPane(v1.getVista3());
				vista.invalidate();
				vista.validate();
			}
		});
	}
	private JPanel partCentral() {
		JPanel p=new JPanel(new GridLayout(2,1));
		p.setBorder(BorderFactory.createTitledBorder(borde,"Opciones"));
		p.add(B1);
		p.add(B2);
		return p;
	}
	private JPanel partEste() {
		JPanel p=new JPanel(new GridLayout(5,1));
		p.add(new JLabel("Categoria y/o tipo:"));
		p.add(new JLabel("Mamifero->Monotremas"));
		p.add(new JLabel("Aves->Ratidas"));
		p.add(new JLabel("Anfibio"));
		p.add(new JLabel("Reptiles->(Cocodrilia,Squamata,Quelonios)"));
		p.setBorder(BorderFactory.createTitledBorder(borde,"Contenido a utilizar"));
		return p;
	}
}
