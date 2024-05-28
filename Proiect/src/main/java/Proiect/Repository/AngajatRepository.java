package Proiect.Repository;

import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.Angajat;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Optional;

public class AngajatRepository {

    public void afisareAudit(String line){
        try(RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/java/Proiect/Audit/audit.csv", "rw")) {
            File file = new File("src/main/java/Proiect/Audit/audit.csv");
            randomAccessFile.seek(file.length());
            randomAccessFile.write("\n".getBytes());
            randomAccessFile.write(line.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

            // afisarea in audit
            String line = "Inserare_angajat," + Instant.now().toString();
            afisareAudit(line);


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

            // afisarea in audit
            String line = "Select_angajat," + Instant.now().toString();
            afisareAudit(line);

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
