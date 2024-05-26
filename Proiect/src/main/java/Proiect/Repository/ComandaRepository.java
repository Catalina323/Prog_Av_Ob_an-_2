package Proiect.Repository;

import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.Aranjament;
import Proiect.Domain.Buchet;
import Proiect.Domain.Comanda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ComandaRepository {

    public void insert(int idAngajat, int idClient) {
        String insertComandaSql = "INSERT INTO comanda (id, idAngajat, idClient) VALUES (null, ?, ?)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertComandaSql);
            preparedStatement.setInt(1, idAngajat);
            preparedStatement.setInt(2, idClient);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Comanda> getById(int id) {
        String selectSql = "SELECT * FROM comanda p WHERE p.id = ?";
        String selectBucheteSql = "SELECT * FROM buchete p WHERE p.idComanda = ?";
        String selectAranjamenteSql = "SELECT * FROM aranjamente p WHERE p.idComanda = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            PreparedStatement preparedStatementBuchete = conn.prepareStatement(selectBucheteSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSetBuchete = preparedStatement.executeQuery();
            PreparedStatement preparedStatementAranjamente = conn.prepareStatement(selectAranjamenteSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSetAranjamente = preparedStatement.executeQuery();
            return mapToBuchet(resultSet, resultSetBuchete, resultSetAranjamente);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Optional<Comanda> mapToBuchet(ResultSet resultSet, ResultSet resultSetBuchete,
                                          ResultSet resultSetAranjamente) throws SQLException {
        if (resultSet.next()) {
            int idAngajat = resultSet.getInt("idAngajat");

            if(resultSetBuchete.next()) {
                Buchet[] buchete = resultSetBuchete.getObject("buchet", Buchet[].class);
                Comanda comanda = new Comanda(buchete);
                comanda.setIdAngajat(idAngajat);
                return Optional.of(comanda);
            }

            if(resultSetAranjamente.next()) {
                Aranjament[] aranjamente = resultSetAranjamente.getObject("aranjament", Aranjament[].class);
                Comanda comanda = new Comanda(aranjamente);
                comanda.setIdAngajat(idAngajat);
                return Optional.of(comanda);
            }
        }
        return Optional.empty();
    }

}

