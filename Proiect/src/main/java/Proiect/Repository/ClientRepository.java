package Proiect.Repository;

import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.Client;
import Proiect.Domain.Comanda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ClientRepository {

    public int insert(Client client) {
        String insertClientSql = "INSERT INRO client (id, nume, prenume, nrComenzi) VALUES (null, ?, ?, 0)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertClientSql);
            preparedStatement.setString(1, client.getNume());
            preparedStatement.setString(2, client.getPrenume());
            boolean affectedRows = preparedStatement.execute();

            // pentru a recupera id ul generat de gaza de date
            if (affectedRows) {
                // Recuperarea cheilor generate
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Obținerea ID-ului generat
                    int generatedId = generatedKeys.getInt(1);
                    return generatedId;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public Optional<Client> getById(int id) {
        String selectSql = "SELECT * FROM client WHERE id = ?";
        String selectIstoricComenziSql = "SELECT * FROM comenzi WHERE idClient = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            PreparedStatement preparedStatementIstoric = conn.prepareStatement(selectIstoricComenziSql);
            preparedStatementIstoric.setInt(1, id);
            ResultSet resultSetIstoricComenzi = preparedStatementIstoric.executeQuery();

            return mapToClient(resultSet, resultSetIstoricComenzi);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    private Optional<Client> mapToClient(ResultSet resultSet, ResultSet resultSetIstoricComenzi) throws SQLException {

        if (resultSet.next()) {
            //int id = resultSet.getInt("id");
            String nume = resultSet.getString("nume");
            String prenume = resultSet.getString("prenume");
            int nrComenzi = resultSet.getInt("nrComenzi");

            if(resultSetIstoricComenzi.next()) {
                Comanda[] comenzi = resultSetIstoricComenzi.getObject("comanda", Comanda[].class);
                return Optional.of(new Client(nume, prenume ,nrComenzi, comenzi));
            }

        }
        return Optional.empty();
    }

    public void AddOneNrComenzi(int id) {
        String updateComandaSql = "UPDATE comanda SET nrComenzi = nrComenzi + 1 WHERE id = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(updateComandaSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
