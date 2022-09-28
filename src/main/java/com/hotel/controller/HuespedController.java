package com.hotel.controller;

import com.hotel.dao.HuespedDAO;
import com.hotel.model.Huesped;

public class HuespedController {
private HuespedDAO huespedDAO;
	
	public HuespedController() {
        var factory = new com.hotel.factory.ConnectionFactory();
        this.huespedDAO = new HuespedDAO(factory.recuperaConexion());
    }
	
	public void guardar(Huesped huesped) {
		huespedDAO.guardar(huesped);
    }
}
