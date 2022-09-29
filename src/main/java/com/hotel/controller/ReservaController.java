package com.hotel.controller;

import java.sql.Date;
import java.util.List;

import com.hotel.dao.ReservaDAO;
import com.hotel.model.Reserva;

public class ReservaController {
	private ReservaDAO reservaDAO;
	
	public ReservaController() {
        var factory = new com.hotel.factory.ConnectionFactory();
        this.reservaDAO = new ReservaDAO(factory.recuperaConexion());
    }
	
	public int guardar(Reserva reserva) {
		return reservaDAO.guardar(reserva);
    }
	
	public List<Reserva> listar() {
		return reservaDAO.listar();
	}
	
	public List<Reserva> listar(Integer id) {
		return reservaDAO.listar(id);
	}

	public int modificar(Integer id, Date fechaE, Date fechaS, Float valor, String formaPago) {
		return reservaDAO.modificar(id, fechaE, fechaS, valor, formaPago);
	}

	public int eliminar(Integer id) {
		return reservaDAO.eliminar(id);
	}
	
}
