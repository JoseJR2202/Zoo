package com.Zoo.packege1;

import java.util.ArrayList;

public class Reptiles extends Animales {
	public Reptiles(String v, String c, String g, byte m) {
		super("Reptiles", v, c, g, m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transporte() {
		// TODO Auto-generated method stub
		return "Terrestre";
	}

	@Override
	public String EstructInt() {
		// TODO Auto-generated method stub
		return "Vertebrados";
	}

	@Override
	public String Reproducen() {
		// TODO Auto-generated method stub
		return "Ovipora";
	}
	public static String Caracteristica() {
		return"Son animales que se caracterizan poseer escamas y placas que recubren sus cuerpos";
	}
	public static String Caracteristica(ArrayList<Reptiles> b) {
		int suma=0;
		for(int i=0;i<b.size();i++) {
			suma+=b.get(i).getCantidad();
		}
		return"La cantidad "+suma;
	}
}