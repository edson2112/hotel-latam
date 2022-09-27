package com.hotel.model;

import java.sql.Date;

public class Reserva {
	private Integer id;
	private Float valor;
	private String formaPago;
	private Date fechaEntrada;
	private Date fechaSalida;
	
	
	public Reserva(Integer id, Float valor, String formaPago, Date fechaEntrada, Date fechaSalida) {
		this.id = id;
		this.valor = valor;
		this.formaPago = formaPago;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}


	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}


	public Date getFechaSalida() {
		return this.fechaSalida;
	}


	public float getValor() {
		return valor;
	}


	public String getFormaPago() {
		return formaPago;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
