package com.Zoo.packege1;

public class Ratidas extends Aves {

	public Ratidas(String v, String c, String g, byte m) {
		super(v, c, g, m);
		setCategoria("Aves Ratidas");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String transporte() {
		// TODO Auto-generated method stub
		return"Terrestre, caracterizadas por correr";
	}
	
}