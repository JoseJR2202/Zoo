package zoo_GUI;
import java.awt.*;
import baseDatos.base;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.Zoo.packege1.*;
import javax.swing.border.*;
public class Vista_agregar {
	private JButton retorno,siguiente,aceptar;
	private JTextField categoria, tipo,move;
	private JTextField Cientifico,nombre,habitad,cantidad,grupoAliment;
	private JPanel vista2;
	private Border borde;
	private JMenuBar opcion;
	private JMenu menu;
	private String category[]= {
			"Mamiferos",
			"Anfibio",
			"Aves",
			"Reptiles",
			"Monotremas",
			"Ratidas",
			"Cocodrilia",
			"Quelonios",
			"Squamata"
	};
	String [] ophabitad=new String [20];
	String [] opmedio=new String [20];
	String [] opaliment=new String [20];
	public Vista_agregar(JFrame v1, JPanel v2, base db) {
		//inicializando los componentes importantes
		vista2=new JPanel(new BorderLayout());
		categoria=new JTextField(10);
		tipo= new JTextField(10);
		borde=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		retorno= new JButton("Regresar");
		siguiente= new JButton("Siguiente");
		aceptar=new JButton("Aceptar");
		nombre= new JTextField(20);
		move=new JTextField(20);
		habitad=new JTextField(20);
		cantidad=new JTextField(20);
		Cientifico=new JTextField(20);
		grupoAliment=new JTextField(20);
		opcion=new JMenuBar();
		menu= new JMenu("categorias");
		opcion.add(menu);
		for(int i=0;i<category.length;i++)
			menu.add(category[i]);
		//funcion del boton agregar
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregador(db);
				categoria.setText(null);
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
				vista2.removeAll();
				vista2.repaint();
				vista2.add(partInf(),BorderLayout.SOUTH);
				vista2.add(partNorte(),BorderLayout.NORTH);
				if(verificador(texto.toUpperCase(),category)>=0) 
					vista2.add(partCentral(texto,db));
				else
					vista2.add(new JLabel("No valido"));
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
		p.add(opcion);
		p.add(siguiente);
		return p;
	}
	private JPanel partCentral(String cat,base bd) {
		nombre.setText(null);
		cantidad.setText(null);
		Cientifico.setText(null);
		grupoAliment.setText(null);
		move.setText(null);
		habitad.setText(null);
		JMenuBar barra=new JMenuBar();
		JMenu menu= new JMenu("lista Habitad");
		JMenuBar barra2=new JMenuBar();
		JMenu menu2= new JMenu("lista Medio");
		barra.add(menu);
		barra2.add(menu2);
		JMenuBar barra3=new JMenuBar();
		JMenu menu3= new JMenu("lista Alimento");
		barra.add(menu3);
		bd.Imprime("Select * from habitad", ophabitad);
		bd.Imprime("Select * from medio", opmedio);
		bd.Imprime("Select * from aliment", opaliment);
		for(int i=0;i<ophabitad.length;i++) {
			menu.add(ophabitad[i]);
		}
		for(int i=0;i<opmedio.length;i++) {
			menu2.add(opmedio[i]);
		}
		for(int i=0;i<opaliment.length;i++) {
			menu3.add(opaliment[i]);
		}
		JPanel p=new JPanel(new FlowLayout());
		JPanel p2=new JPanel(new GridLayout(2,2));
		JPanel p3=new JPanel(new BorderLayout());
		p2.setBorder(BorderFactory.createTitledBorder(borde,"Registro"));
		int opcion=verificador(cat.toUpperCase(),category);
		if(opcion>=0) {
			p2.add(new JLabel("Nombre Cientifico:"));
			p2.add(Cientifico);
			p2.add(new JLabel("Nombre:"));
			p2.add(nombre);
			p2.add(new JLabel("Cantidad:"));
			p2.add(cantidad);
			p2.add(new JLabel("Grupo Alimenticio:"));
			p2.add(grupoAliment);
			p.add(barra);
			p.add(barra2);
			p.add(barra3);
			p2.add(new JLabel("habitad:"));
			p2.add(habitad);
			p2.add(new JLabel("Medio"));
			p2.add(move);
			p3.add(p2,BorderLayout.CENTER);
			p3.add(p,BorderLayout.SOUTH);
		}
		else
			p2.add(new JLabel("No valido"));
		return p3;
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
			if((b[i].toUpperCase().equals(c))==true)
				return i;
		}
		return -1;
	}
	public void agregador( base baseD) {
		Object [] datos= {
				Cientifico.getText(),
				nombre.getText(),
				Integer.parseInt((cantidad.getText())),
				category[verificador(categoria.getText().toUpperCase(),category)],
				Integer.parseInt(grupoAliment.getText())
		};
		Object[] vive= {
				Cientifico.getText(),
				Integer.parseInt((habitad.getText()))
		};
		Object[] mueve= {
				Cientifico.getText(),
			Integer.parseInt(move.getText())
		};
		baseD.IngresoDB("insert into animal(NombreC,NombreN,cantidad,nombre,idaliment) values(?,?,?,?,?)", datos, 1);
		baseD.IngresoDB("insert into vive(NombreC,idhabitad) values(?,?)",vive,2 );
		baseD.IngresoDB("insert into moviliza(NombreC,idmedio) values(?,?)",mueve,2 );
	}
}
