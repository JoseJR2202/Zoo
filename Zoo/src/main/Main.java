package main;

import java.util.ArrayList;
import com.Zoo.packege1.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		//Creando variables a usar...
		Scanner lector=new Scanner(System.in);
		int opcion;
		String name;
		String lugar;
		String come;
		String caracteristico[]= {Aves.Caracteristica(),
								  Mamiferos.Caracteristica(),
								  Anfibios.Caracteristica(),
								  Reptiles.Caracteristica()};
		byte numero;
		//Creando listas...
		ArrayList<Mamiferos> ListaMamifero=new ArrayList<Mamiferos>();
		ArrayList<Aves> ListaAves=new ArrayList<Aves>();
		ArrayList<Anfibios> ListaAnfibios=new ArrayList<Anfibios>();
		ArrayList<Reptiles> ListaReptiles=new ArrayList<Reptiles>();
		//agregando algunos animales...
		//Mamiferos
		ListaMamifero.add(new Monotremas("Oritorinco",(byte)12));
		ListaMamifero.add(new Monotremas("Equidna",(byte)17));
		ListaMamifero.add(new Mamiferos("Tigre","Carnivoro","Selva humeas, praderas",(byte)20));
		ListaMamifero.add(new Mamiferos("Leon","Carnivoro","Sabanas",(byte)10));
		ListaMamifero.add(new Mamiferos("Elefante","Hervivoro","Sabanas",(byte)6));
		//Aves...
		ListaAves.add(new Ratidas("Avestruz","Carnivoro","Paisajes aridos",(byte)5));
		ListaAves.add(new Ratidas("Kiwi","Herviboro","Nueva zelanda",(byte)9));
		ListaAves.add(new Aves("Cardenal","Hervivoro","Praderas",(byte)5));
		ListaAves.add(new Aves("Guacamayas","Carnivoro","Selvas tropicales",(byte)6));
		ListaAves.add(new Aves("Aguila calva","Carnivoro","Montañas o praderas humedas",(byte)3));
		//Anfibios...
		ListaAnfibios.add(new Anfibios("Rana verde","America del norte",(byte)7));
		ListaAnfibios.add(new Anfibios("Sapo","Por todo el mundo, menos en el desierto y la antartida",(byte)7));
		ListaAnfibios.add(new Anfibios("Salamandras","Europa",(byte)7));
		ListaAnfibios.add(new Anfibios("Cecilido","Pantano",(byte)7));
		ListaAnfibios.add(new Anfibios("Rana toro","Norte America",(byte)7));
		//Menu de opciones
		do {
		System.out.println("\t\t\tMenu opciones:");
		System.out.println("1.-Ingresar animales\n2.-Mostrar animales");
		System.out.print("Su opcion: ");
		if(lector.nextInt()==1) {
			System.out.println("\t\t\tQue animal va agregar?");
			//menu de opciones para agregar...
			Animales.Menu();
			opcion=lector.nextInt();
			System.out.println(caracteristico[opcion-1]);
			System.out.print("Ingrese nombre del animal: ");
			lector.nextLine();
			name=lector.nextLine();
			System.out.print("\nCantidad en el ZOO: ");
			numero=lector.nextByte();
			lector.nextLine();
			switch(opcion) {
			case 1:System.out.print("\nIngrese Habitad: ");
				lugar=lector.nextLine();
				System.out.print("\nGrupo alimenticio del animal: ");
				come=lector.next();
				System.out.println("\nEl ave ingresado es ratida? 1=si, 2=no");
				ListaAves.add((lector.nextInt()==2)? new Aves(name,come,lugar,numero):new Ratidas(name,come,lugar,numero));
				break;
			case 2:System.out.print("\nEl mamifero ingresado es Monotremas(pone huevos)?"
									+ " 1=si, 2=no");
				if(lector.nextInt()==1)
					ListaMamifero.add(new Monotremas(name,numero));
				else {
					System.out.print("\nIngrese Habitad: ");
					lector.nextLine();
					lugar=lector.nextLine();
					System.out.print("\nGrupo alimenticio del animal: ");
					come=lector.next();
					ListaMamifero.add(new Mamiferos(name,come,lugar,numero));
				}
				break;
			case 3:System.out.print("\nIngrese Habitad: ");
			lugar=lector.nextLine();
			ListaAnfibios.add(new Anfibios(name,lugar,numero));
			break;
			case 4:System.out.print("\nIngrese Habitad: ");
				lugar=lector.nextLine();
				System.out.println("\nEl animal ingresado que tipo de reptil es:");
				System.out.println("1.-Cocodrilia\n2.-Quelenios\n3.-Squamata");
				opcion=lector.nextInt();
				ListaReptiles.add((opcion==1)? new Cocodrilia(name,lugar,numero) :(opcion<3)? new Quelonios(name,lugar,numero):new Squamata(name,lugar,numero));
				break;
			}
		}
		else {
			System.out.println("Que lista mostrar?");
			Animales.Menu();
			switch(lector.nextInt()) {
			case 1:System.out.println(ListaAves);
			System.out.println(Aves.Caracteristica(ListaAves));break;
			case 2:System.out.println(ListaMamifero);
			System.out.println(Mamiferos.Caracteristica(ListaMamifero));break;
			case 3:System.out.println(ListaAnfibios);
			System.out.println(Anfibios.Caracteristica(ListaAnfibios));break;
			case 4:System.out.println(ListaReptiles);
			System.out.println(Reptiles.Caracteristica(ListaReptiles));break;
			}
		}
		System.out.println("\nRegresar al menu principal? 1=si, 2=no");
		}while(lector.nextInt()==1);
	lector.close();
	}
}