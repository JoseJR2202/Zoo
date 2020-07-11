package zoo_GUI;
import java.awt.*;
import baseDatos.base;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;
import com.Zoo.packege1.*;
public class Vista_ver {
	private JPanel vista3;
	private JButton B_aceptar, retorno,borra,modifica;
	private JTextField buscador, seleccion,NombreN, CantidadN,HabitadN,moveN;
	private JTable tabla;
	private Border borde;
	private DefaultTableModel modeA,modeAn,modeM,modeR;
	private JMenu menu,menu2;
	private JMenuBar barra,opcion;
	base db= base.getInstances();
	private String cabecera[]= {
			"nombreC","nombre","Cantidad","Categoria","Estructura","Grupo Alimenticio","Reproduccion"
	};
	private String category[]= {
			"Mamiferos",
			"Anfibio",
			"Aves",
			"Reptiles"	
	};
	public Vista_ver(JFrame v1,JPanel v2, base db) {
		vista3=new JPanel(new BorderLayout());
		borde=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		B_aceptar=new JButton("Aceptar");
		retorno=new JButton("Regresar");
		buscador= new JTextField(20);
		borra=new JButton("Eliminar");
		modifica=new JButton("Modificar");
		opcion=new JMenuBar();
		menu2=new JMenu("listas");
		opcion.add(menu2);
		for(int i=0;i<category.length;i++)
			menu2.add(category[i]);
		barra=new JMenuBar();
		menu= new JMenu("opcion");
		barra.add(menu);
		menu.add(borra);
		menu.add(modifica);
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
		insertFilas(modeM,"'"+category[0]+"' or categoria.nombre like 'Monotremas'",db);
		insertFilas(modeAn,"'"+category[1]+"'",db);
		insertFilas(modeA,"'"+category[2]+"' or categoria.nombre like 'Ratidas'",db);
		insertFilas(modeR,"'"+category[3]+"' or categoria.nombre like 'Quelonios' or categoria.nombre like 'Squamata'"
				+ "or categoria.nombre like 'Cocodrilia'",db);
		//funcion del boton aceptar
		B_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto=buscador.getText();
				int eleccion=Vista_agregar.verificador(texto.toUpperCase(),category);
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
		borra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String NameA=seleccion.getText();
				db.IngresoDB("delete from animal where nombreC like ?", NameA);
				vista3.removeAll();
				vista3.repaint();
				vista3.add(partNorte(),BorderLayout.NORTH);
				vista3.add(partSur(),BorderLayout.SOUTH);
				vista3.add(new JLabel("Eliminado, salir y volver a entrar a esta vista para visualizar el cambio"),BorderLayout.CENTER);
				vista3.validate();
			}
		});
		modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String A=seleccion.getText();
				vista3.removeAll();
				vista3.repaint();
				vista3.add(partNorte(),BorderLayout.NORTH);
				vista3.add(partSur(),BorderLayout.SOUTH);
				vista3.add(aux(db,A));
				vista3.validate();
			}
		});
		vista3.add(partNorte(),BorderLayout.NORTH);
		vista3.add(partSur(),BorderLayout.SOUTH);
	}
	private JPanel partNorte() {
		JPanel p=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.setBorder(BorderFactory.createTitledBorder(borde,"Lista")); 
		p.add(new JLabel("Lista:"));
		p.add(buscador);
		p.add(opcion);
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
	private JPanel aux(base baseD, String a){
		NombreN=new JTextField(20);
		CantidadN=new JTextField(20);
		HabitadN=new JTextField(20);
		moveN=new JTextField(20);
		JPanel menuAux=new JPanel(new BorderLayout());
		JPanel extra= new JPanel(new GridLayout(4,1));
		JLabel text=new JLabel("modificar a "+a);
		menuAux.add(text,BorderLayout.NORTH);
		extra.setBorder(BorderFactory.createTitledBorder(borde,"Modificacion"));
		extra.add(new JLabel("Nombre:"));
		extra.add(NombreN);
		extra.add(new JLabel("Cantidad:"));
		extra.add(CantidadN);
		//listas de ayuda...
		String [] ophabitad=new String [20];
		String [] opmedio=new String [20];
		baseD.Imprime("Select * from habitad", ophabitad);
		baseD.Imprime("Select * from medio", opmedio);
		//Menu para las listas...
		JMenuBar barra=new JMenuBar();
		JMenu menu= new JMenu("lista Habitad");
		JMenuBar barra2=new JMenuBar();
		JMenu menu2= new JMenu("lista Medio");
		barra.add(menu);
		barra2.add(menu2);
		for(int i=0;i<ophabitad.length;i++) {
			menu.add(ophabitad[i]);
		}
		for(int i=0;i<opmedio.length;i++) {
			menu2.add(opmedio[i]);
		}
		extra.add(barra);
		extra.add(HabitadN);
		extra.add(barra2);
		extra.add(moveN);
		menuAux.add(extra,BorderLayout.CENTER);
		JButton cambio=new JButton("acepto");
		cambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(NombreN.getText().length()!=0) 
					baseD.IngresoDB("update animal set nombren= ? where nombrec= '"+a+"'", NombreN.getText());
				if(CantidadN.getText().length()!=0)
					baseD.IngresoDB("update animal set cantidad= ? where nombrec= '"+a+"'", Integer.parseInt(CantidadN.getText()));
				if(HabitadN.getText().length()!=0)
					baseD.IngresoDB("update vive set idhabitad= ? where nombrec= '"+a+"'", Integer.parseInt(HabitadN.getText()));
				if(moveN.getText().length()!=0)
					baseD.IngresoDB("update moviliza set idmedio= ? where nombrec= '"+a+"'", Integer.parseInt(moveN.getText()));
				vista3.removeAll();
				vista3.repaint();
				vista3.add(partNorte(),BorderLayout.NORTH);
				vista3.add(partSur(),BorderLayout.SOUTH);
				vista3.add(new JLabel("resultado exitoso, salga y vuelva a entrar para ver los resultados"));
				vista3.validate();
				
		}});
		menuAux.add(cambio,BorderLayout.SOUTH);
		return menuAux;
	}
	private JPanel partSur() {
		JPanel p=new JPanel(new BorderLayout());
		JPanel p1=new JPanel(new FlowLayout());
		p.setBorder(borde);
		seleccion=new JTextField(20);
		p1.add(new JLabel("Animal(nombrec): "));
		p1.add(seleccion);
		p.add(p1);
		p.add(barra,BorderLayout.EAST);
		p.add(retorno,BorderLayout.WEST);
		return p;
	}
	public void insertFilas(DefaultTableModel l,String g, base baseD){
		baseD.Imprime("Select NombreC, NombreN, cantidad,animal.nombre,estructura.descripcion,aliment.descripcion,reproduccion.descripcion\r\n" + 
				"from animal ,categoria , estructura,aliment, reproduccion where categoria.nombre = animal.nombre\r\n" + 
				"and categoria.idestructura=estructura.idestructura and animal.idaliment=aliment.idaliment and \r\n" + 
				"categoria.idreproduccion=reproduccion.idreproduccion and ( categoria.nombre like "+g+")", l);
	}
	public JPanel getVista3() {
		return vista3;
	}
}