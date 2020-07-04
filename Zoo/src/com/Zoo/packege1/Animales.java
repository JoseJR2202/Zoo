package com.Zoo.packege1;

import Interfaces.Movilizar;

public abstract class Animales implements Movilizar {
	private String categoria;
	private String nombre;
	private byte cantidad;
	private String grupoAliment;
	private String habitad;
	//constructor
	public Animales (String e,String v,String c,String g,byte m) {
		setCategoria(e);
		setNombre(v);
		setGrupoAliment(c);
		setHabitad(g);
		setCantidad(m);
	}
	//metodos abstractos:
	public abstract String EstructInt();
	//los animales pueden poser estructura internas diferentes
	public abstract String Reproducen();
	/*todos los animales se reproducen(enfocado en la
	 * manera en que nacen) pero no de la misma forma.
	 */
	@Override
	public String transporte() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte getCantidad() {
		return cantidad;
	}
	public void setCantidad(byte cantidad) {
		this.cantidad = cantidad;
	}
	public String getGrupoAliment() {
		return grupoAliment;
	}
	public void setGrupoAliment(String grupoAliment) {
		this.grupoAliment = grupoAliment;
	}
	public String getHabitad() {
		return habitad;
	}
	public void setHabitad(String habitad) {
		this.habitad = habitad;
	}
	@Override
	public String toString() {
		return "Nombre: "+getNombre()+"{\nEspecie: "+getCategoria()+"\nCantidad en el ZOO: "+getCantidad()+
				"\nGrupo alimenticio: "+getGrupoAliment()+"\nHabitad: "+getHabitad()+
				"\nEstructura interna: " + EstructInt() +"\nReproducen: " + Reproducen()
				+"\nTransporte: " + transporte()+"\n}\n\n";
	}
	public static void Menu() {
		System.out.println("1.-Aves\n2.-Mamiferos\n3.-Anfibios\n"
							+ "4.-Reptiles");
	}
	
}