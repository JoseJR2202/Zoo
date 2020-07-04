package zoo_GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.Zoo.packege1.*;
import javax.swing.border.*;
public class Vista_agregar {
	private JButton retorno,siguiente,aceptar;
	private JTextField categoria, tipo;
	private JTextField nombre,habitad,cantidad,grupoAliment;
	private JPanel vista2;
	private Border borde;
	private String category[]= {
			"MAMIFERO",
			"ANFIBIO",
			"AVES",
			"REPTILES"
	};
	private String subCategory[]= {
			"MONOTREMAS",
			"RATIDAS",
			"COCODRILIA",
			"QUELONIOS",
			"SQUAMATA"
	};
	public Vista_agregar(JFrame v1, JPanel v2,ArrayList<ArrayList<Animales>> p) {
		//inicializando los componentes importantes
		vista2=new JPanel(new BorderLayout());
		categoria=new JTextField(10);
		tipo= new JTextField(10);
		borde=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		retorno= new JButton("Regresar");
		siguiente= new JButton("Siguiente");
		aceptar=new JButton("Aceptar");
		nombre= new JTextField(20);
		habitad=new JTextField(20);
		cantidad=new JTextField(20);
		grupoAliment=new JTextField(20);
		//funcion del boton agregar
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion=verificador(tipo.getText().toUpperCase(),subCategory);
				agregador(p,opcion);
				categoria.setText(null);
				tipo.setText(null);
				vista2.removeAll();
				vista2.repaint();
				vista2.add(partInf(),BorderLayout.SOUTH);
				vista2.add(partNorte(),BorderLayout.NORTH);
				vista2.add(new JLabel("Ingreso exitoso!!!"),BorderLayout.CENTER);
				v1.validate();
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
		//funcion del boton siguiente
		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto=categoria.getText();
				String t=tipo.getText();
				vista2.removeAll();
				vista2.repaint();
				vista2.add(partInf(),BorderLayout.SOUTH);
				vista2.add(partNorte(),BorderLayout.NORTH);
				vista2.add(partCentral(texto,t));
				v1.validate();
			}
		});
		vista2.add(partInf(),BorderLayout.SOUTH);
		vista2.add(partNorte(),BorderLayout.NORTH);
	}
	private JPanel partNorte() {
		JPanel p=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.setBorder(BorderFactory.createTitledBorder(borde,"Datos"));
		p.add(new JLabel("Categoria:"));
		p.add(categoria);
		p.add(new JLabel("Tipo:"));
		p.add(tipo);
		p.add(siguiente);
		return p;
	}
	private JPanel partCentral(String cat,String tip) {
		nombre.setText(null);
		cantidad.setText(null);
		habitad.setText(null);
		grupoAliment.setText(null);
		JPanel p2=new JPanel(new GridLayout(2,2));
		p2.setBorder(BorderFactory.createTitledBorder(borde,"Registro"));
		int opcion=verificador(cat.toUpperCase(),category);
		if(opcion>=0) {
			p2.add(new JLabel("Nombre:"));
			p2.add(nombre);
			p2.add(new JLabel("Cantidad:"));
			p2.add(cantidad);
			p2.add(new JLabel("Habitad:"));
			p2.add(habitad);
			if(opcion!=1) {
				p2.add(new JLabel("Grupo Alimenticio:"));
				p2.add(grupoAliment);
			}
			switch(verificador(tip.toUpperCase(),subCategory)+1) {
			case 1:if(opcion==0) {
				p2.remove(7);
				p2.remove(6);
				p2.remove(5);
				p2.remove(4);
			}
			break;
			case 2:break;
			case 3:if(opcion<2)break;
			case 4:if(opcion<2)break;
			case 5:if(opcion<2)break;
			p2.remove(7);
			p2.remove(6);
			break;
			}
		}
		else
			p2.add(new JLabel("No valido"));
		return p2;
	}
	private JPanel partInf() {
		JPanel p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p3.add(retorno);
		p3.add(aceptar);
		p3.setBorder(borde);
		return p3;
	}
	public JPanel getVista2() {
		return vista2;
	}
	public static int verificador(String c,String [] b) {
		int i;
		for( i=0;i<b.length;i++) {
			if((b[i].equals(c))==true)
				return i;
		}
		return -1;
	}
	private void agregador(ArrayList<ArrayList<Animales>> lista,int elec) {
		switch(verificador(categoria.getText().toUpperCase(),category)){
			case 0: lista.get(0).add((elec==0)?new Monotremas(nombre.getText(),
				Byte.parseByte(cantidad.getText())):new Mamiferos(nombre.getText(),
				grupoAliment.getText(),habitad.getText(),Byte.parseByte(cantidad.getText())));
			break;
			case 1:lista.get(1).add(new Anfibios(nombre.getText(),
					habitad.getText(),Byte.parseByte(cantidad.getText())));
			break;
			case 2:lista.get(2).add((elec==1)? new Ratidas(nombre.getText(),
				grupoAliment.getText(),habitad.getText(),Byte.parseByte(cantidad.getText())):
				new Aves(nombre.getText(),grupoAliment.getText(),
				habitad.getText(),Byte.parseByte(cantidad.getText())));
			break;
			case 3:if(elec<0) {
				lista.get(3).add(new Reptiles(nombre.getText(),
				grupoAliment.getText(),habitad.getText(),Byte.parseByte(cantidad.getText())));
			}
			else {
				lista.get(3).add((elec==2)? 
					new Cocodrilia(nombre.getText(),habitad.getText(),Byte.parseByte(cantidad.getText())):
					(elec==3)? new Quelonios(nombre.getText(),habitad.getText(),Byte.parseByte(cantidad.getText())):
					new Squamata(nombre.getText(),habitad.getText(),Byte.parseByte(cantidad.getText())));
			}
		}
	}
}
