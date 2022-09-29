package com.hotel.controller;

import java.sql.Date;
import java.util.List;

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

	public List<Huesped> listar() {
		return huespedDAO.listar();
	}

	public List<Huesped> listar(String apellido) {
		return huespedDAO.listar(apellido);
	}

	public int modificar(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, Integer reservaId) {
		return huespedDAO.modificar(id, nombre, apellido, fechaNacimiento, nacionalidad, telefono, reservaId);
	}

	public int eliminar(Integer id) {
		return huespedDAO.eliminar(id);
	}
}
