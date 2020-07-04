package main;

import java.util.ArrayList;
import com.Zoo.packege1.*;
import zoo_GUI.VentanaMenu;
public class Main {

	public static void main(String[] args) {
		//Creando listas...
		ArrayList<Animales> ListaMamifero=new ArrayList<Animales>();
		ArrayList<Animales> ListaAves=new ArrayList<Animales>();
		ArrayList<Animales> ListaAnfibios=new ArrayList<Animales>();
		ArrayList<Animales> ListaReptiles=new ArrayList<Animales>();
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
		//ArrayList de ArrayList...
		ArrayList<ArrayList<Animales>> animal= new ArrayList<ArrayList<Animales>>();
		animal.add(ListaMamifero);
		animal.add(ListaAnfibios);
		animal.add(ListaAves);
		animal.add(ListaReptiles);
		VentanaMenu zoo=new VentanaMenu(animal);
	}
}