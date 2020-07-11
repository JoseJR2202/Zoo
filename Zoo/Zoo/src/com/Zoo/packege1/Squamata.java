package com.Zoo.packege1;

public class Squamata extends Reptiles{
	public Squamata(String v, String c, byte m) {
		super( v, "Carnivoros", c, m);
		setCategoria("Reptiles, Squamata");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String transporte() {
		return "Raptando";
	}
}