package com.hotel.model;

import java.sql.Date;

public class Reserva {
	private Integer id;
	private Double valor;
	private String formaPago;
	private Date fechaEntrada;
	private Date fechaSalida;
	
	
	public Reserva(Integer id, Double valor, String formaPago, Date fechaEntrada, Date fechaSalida) {
		this.id = id;
		this.valor = valor;
		this.formaPago = formaPago;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}
	
}
