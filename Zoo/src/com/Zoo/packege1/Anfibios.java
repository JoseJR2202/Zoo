package com.Zoo.packege1;

import java.util.ArrayList;

public class Anfibios extends Animales {
	
	public Anfibios(String v, String g, byte m) {
		super("Anfibios", v, "Carnivoros", g, m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String EstructInt() {
		// TODO Auto-generated method stub
		return "Vertebrados";
	}

	@Override
	public String Reproducen() {
		// TODO Auto-generated method stub
		return "Oviporos";
	}
	
	@Override
	public String transporte() {
		return"tierra y agua";
	}
	public static String Caracteristica() {
		return"Son animales que se caracterizan por presentar una metamorfosis en su ciclo reproductivo";
	}
	//Sobrecarga...
	public static String Caracteristica(ArrayList<Anfibios> b) {
		int suma=0;
		for(int i=0;i<b.size();i++) {
			suma+=b.get(i).getCantidad();
		}
		return"Total "+suma;
	}
}