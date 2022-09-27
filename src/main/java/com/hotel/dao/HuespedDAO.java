package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotel.model.Huesped;

public class HuespedDAO {
	private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void save(Huesped huesped) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO HUESPED "
					+ "(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva)"
					+ " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
					);
			try (statement) {
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getFechaNacimento());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6,  huesped.getIdReserva());
				statement.execute();
			    
                final ResultSet resultSet = statement.getGeneratedKeys();
                try (resultSet) {
                    while (resultSet.next()) {
                    	huesped.setId(resultSet.getInt(1));
                        
                        System.out.println(String.format("Fue insertado el Huesped: %s", producto));
                    }
                }
			}
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}
