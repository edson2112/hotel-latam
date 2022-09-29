package com.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.model.Reserva;

public class ReservaDAO {
	private Connection con;
	
	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	public int guardar(Reserva reserva) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO RESERVA "
                        + "(fecha_entrada, fecha_salida, valor, forma_pago)"
                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setDate(1, reserva.getFechaEntrada());
                statement.setDate(2, reserva.getFechaSalida());
                statement.setFloat(3, reserva.getValor());
                statement.setString(4, reserva.getFormaPago());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        reserva.setId(resultSet.getInt(1));
                        
                        System.out.println(String.format("Fue insertado la reserva: %s", reserva));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reserva.getId();
    }

    public List<Reserva> listar() {
        List<Reserva> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVA");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Reserva(
                                resultSet.getInt("ID"),
                                resultSet.getFloat("VALOR"),
                                resultSet.getString("FORMA_PAGO"),
                                resultSet.getDate("FECHA_ENTRADA"),
                                resultSet.getDate("FECHA_SALIDA")));
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVA WHERE ID = ?");

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

    public int modificar(Integer id, Date fechaEntrada, Date fechaSalida, Float valor, String formaPago) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE RESERVA SET "
                    + " FECHA_ENTRADA = ?, "
                    + " FECHA_SALIDA = ?,"
                    + " VALOR = ?, "
                    + " FORMA_PAGO = ?"
                    + " WHERE ID = ?");

            try (statement) {
            	statement.setDate(1, fechaEntrada);
                statement.setDate(2, fechaSalida);
                statement.setFloat(3, valor);
                statement.setString(4, formaPago);
                statement.setInt(5, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Reserva> listar(Integer id) {
        List<Reserva> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVA WHERE ID = ?");
    
            try (statement) {
            	statement.setInt(1, id);
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Reserva(
                                resultSet.getInt("ID"),
                                resultSet.getFloat("VALOR"),
                                resultSet.getString("FORMA_PAGO"),
                                resultSet.getDate("FECHA_ENTRADA"),
                                resultSet.getDate("FECHA_SALIDA")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
}
