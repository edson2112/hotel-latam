package com.hotel.controller;

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
	
}
