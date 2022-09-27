package com.hotel.model;

import java.sql.Date;

public class Huesped {
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer reservaId;
	
	public Huesped(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer reservaId) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reservaId = reservaId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public Date getFechaNacimento() {
		return this.fechaNacimiento;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public int getIdReserva() {
		return reservaId;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format(
				"id: %d, nombre: %s, apellido: %s",
				this.id, this.nombre, this.apellido);
	}
}
