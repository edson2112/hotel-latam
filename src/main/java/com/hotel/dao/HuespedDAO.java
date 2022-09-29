package com.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.model.Huesped;

public class HuespedDAO {
	private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huesped huesped) {
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
                        
                        System.out.println(String.format("Fue insertado el Huesped: %s", huesped));
                    }
                }
			}
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public List<Huesped> listar() {
		List<Huesped> resultado = new ArrayList<>();
		try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM HUESPED");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Huesped(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("APELLIDO"),
                                resultSet.getDate("FECHA_NACIMIENTO"),
                                resultSet.getString("NACIONALIDAD"),
                                resultSet.getString("TELEFONO"),
                                resultSet.getInt("ID_RESERVA")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
	}
	
	public int eliminar(Integer id) {
		try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM HUESPED WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public int modificar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer idReserva, Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE HUESPED SET "
                    + " NOMBRE = ?, "
                    + " APELLIDO = ?, "
                    + " FECHA_NACIMIENTO = ?, "
                    + " NACIONALIDAD = ?, "
                    + " TELEFONO = ?, "
                    + " ID_RESERVA = ?"
                    + " WHERE ID = ?");

            try (statement) {
            	statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setDate(3, fechaNacimiento);
				statement.setString(4, nacionalidad);
				statement.setString(5, telefono);
				statement.setInt(6,  idReserva);
				statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public List<Huesped> listar(String apellido) {
		List<Huesped> resultado = new ArrayList<>();
		try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM HUESPED WHERE APELLIDO = ?");
    
            try (statement) {
            	statement.setString(1, apellido);
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Huesped(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("APELLIDO"),
                                resultSet.getDate("FECHA_NACIMIENTO"),
                                resultSet.getString("NACIONALIDAD"),
                                resultSet.getString("TELEFONO"),
                                resultSet.getInt("ID_RESERVA")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
	}
}
