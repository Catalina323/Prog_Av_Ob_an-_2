package Proiect.Repository;

import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.Angajat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AngajatRepository {

    public void insert(Angajat angajat) {
        String insertAngajatSql = "INSERT INTO angajat (id, nume, prenume, varsta" +
                ", salariu) VALUES (null, ?, ?, ?, ?)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertAngajatSql);
            preparedStatement.setString(1, angajat.getNume());
            preparedStatement.setString(2, angajat.getPrenume());
            preparedStatement.setInt(3, angajat.getVarsta());
            preparedStatement.setInt(4, angajat.getSalariu());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Angajat> getById(int id) {
        String selectSql = "SELECT * FROM angajat p WHERE p.id = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToAngajat(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Optional<Angajat> mapToAngajat(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nume = resultSet.getString("nume");
            String prenume = resultSet.getString("prenume");
            int varsta = resultSet.getInt("varsta");
            int salariu = resultSet.getInt("salariu");
            return Optional.of(new Angajat(nume, prenume, varsta, salariu));
        }
        return Optional.empty();
    }

}
