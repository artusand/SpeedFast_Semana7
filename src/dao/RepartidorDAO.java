package dao;

import conexion.ConexionDB;
import model.Repartidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

    public List<Repartidor> listarTodos() {

        List<Repartidor> repartidores = new ArrayList<>();

        String sql = "SELECT id, nombre FROM repartidor";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Repartidor repartidor = new Repartidor();

                repartidor.setId(resultado.getInt("id"));
                repartidor.setNombre(resultado.getString("nombre"));

                repartidores.add(repartidor);
            }

        } catch (Exception e) {
            System.out.println("Error al listar los repartidores.");
            e.printStackTrace();
        }

        return repartidores;
    }
    public void guardar(Repartidor repartidor) {

        String sql = "INSERT INTO repartidor (nombre) VALUES (?)";

        try (
            Connection conexion = ConexionDB.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, repartidor.getNombre());

            sentencia.executeUpdate();

            System.out.println("Repartidor guardado correctamente.");

        } catch (Exception e) {

            System.out.println("Error al guardar el repartidor.");
            e.printStackTrace();
        }
    }
}
