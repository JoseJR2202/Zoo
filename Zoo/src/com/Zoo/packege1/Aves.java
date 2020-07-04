package com.Zoo.packege1;

import java.util.ArrayList;

public class Aves extends Animales {
	
	public Aves(String v, String c, String g, byte m) {
		super("Aves", v, c, g, m);
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
		return "Oviparas";
	}
	
	@Override
	public String transporte() {
		return"Volando";
	}
	public static String Caracteristica() {
		return"Son animales que se caracterizan por poseer plumaje, y picos";
	}
	//Sobrecarga...
	public static String Caracteristica(ArrayList<Aves> b) {
		int suma=0;
		for(int i=0;i<b.size();i++) {
			suma+=b.get(i).getCantidad();
		}
		return"Total "+suma;
	}
}