package com.Zoo.packege1;

import java.util.ArrayList;
public class Mamiferos extends Animales {
	public Mamiferos(String v, String c, String g, byte m) {
		super("Mamiferos", v, c, g, m);
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
		return "Viparos";
	}
	public static String Caracteristica() {
		return"Son animales que se caracterizan por poseer pelaje, y glandulas mamarias (las hembras)";
	}
	//Sobrecarga...
	public static String Caracteristica(ArrayList<Mamiferos> b) {
		int suma=0;
		for(int i=0;i<b.size();i++) {
			suma+=b.get(i).getCantidad();
		}
		return"La cantidad total de Mamiferos en el ZOO es "+suma;
	}
}