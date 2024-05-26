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

    public void insert(Client client) {
        String insertClientSql = "INSERT INRO client (id, nume, prenume, nrComenzi) VALUES (null, ?, ?, 0)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertClientSql);
            preparedStatement.setString(1, client.getNume());
            preparedStatement.setString(2, client.getPrenume());
            preparedStatement.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
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

}
