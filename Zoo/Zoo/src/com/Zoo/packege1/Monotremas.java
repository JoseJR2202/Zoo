package com.Zoo.packege1;

public class Monotremas extends Mamiferos {
	public Monotremas(String v, byte m) {
		super(v, "Carnivoros", "Oceania", m);
		setCategoria("Mamiferos, Monotremas");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String Reproducen() {
		// TODO Auto-generated method stub
		return "Oviparos";
	}
}