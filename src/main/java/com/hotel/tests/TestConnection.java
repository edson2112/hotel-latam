package com.hotel.tests;

import java.sql.Connection;
import java.sql.SQLException;

import com.hotel.factory.ConnectionFactory;

public class TestConnection {
	public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperaConexion();

        System.out.println("Cerrando la conexión");

        con.close();
    }
}
