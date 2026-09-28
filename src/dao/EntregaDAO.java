package dao;

import conexion.ConexionDB;
import model.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntregaDAO {

    public void guardar(Entrega entrega) {

        String sql = "INSERT INTO entrega "
                + "(id_pedido, id_repartidor, fecha, hora) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, entrega.getIdPedido());
            sentencia.setInt(2, entrega.getIdRepartidor());
            sentencia.setDate(3, entrega.getFecha());
            sentencia.setTime(4, entrega.getHora());

            sentencia.executeUpdate();

            System.out.println("Entrega guardada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al guardar la entrega.");
            e.printStackTrace();
        }
    }
}
