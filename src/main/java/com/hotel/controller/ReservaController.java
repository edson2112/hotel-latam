package com.hotel.controller;

import com.hotel.dao.ReservaDAO;

public class ReservaController {
	private ReservaDAO reservaDAO;
	
	public ReservaController() {
        var factory = new com.hotel.factory.ConnectionFactory();
        this.reservaDAO = new ReservaDAO(factory.recuperaConexion());
    }
	
}
