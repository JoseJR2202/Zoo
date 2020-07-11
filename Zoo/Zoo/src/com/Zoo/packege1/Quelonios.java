package com.Zoo.packege1;

public class Quelonios extends Reptiles {
	public Quelonios(String v, String g, byte m) {
		super( v, "Omnivoros", g, m);
		setCategoria("Reptiles, Quelonios");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String transporte() {
		return "Caminan, caracterizados por no ser muy rapidos";
	}
}