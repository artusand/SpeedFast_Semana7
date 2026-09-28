package dao;

import conexion.ConexionDB;
import model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public void guardar(Pedido pedido) {

        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, pedido.getDireccion());
            sentencia.setString(2, pedido.getTipo());
            sentencia.setString(3, pedido.getEstado());

            sentencia.executeUpdate();

            System.out.println("Pedido guardado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al guardar el pedido.");
            e.printStackTrace();
        }
    }
}
