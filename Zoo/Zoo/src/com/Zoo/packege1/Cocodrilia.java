package com.Zoo.packege1;

public class Cocodrilia extends Reptiles {
	public Cocodrilia(String v, String g, byte m) {
		super( v, "Carnivoros", g, m);
		setCategoria("Reptiles, Cocodrilia");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String transporte() {
		return"Terrestre, pero excelentes nadadores";
	}
}