package Proiect.Repository;

import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.Client;
import Proiect.Domain.Comanda;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository {

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

    public int insert(Client client) {
        String insertClientSql = "INSERT INTO client (id, nume, prenume, nrComenzi) VALUES (null, ?, ?, 0)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertClientSql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getNume());
            preparedStatement.setString(2, client.getPrenume());
            int affectedRows = preparedStatement.executeUpdate();

            // afisare in audit
            String line = "Inserare_client," + Instant.now();
            afisareAudit(line);

            // pentru a recupera id ul generat de gaza de date
            if (affectedRows > 0) {
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

            String line = "Select_client," + Instant.now();
            afisareAudit(line);

            return mapToClient(resultSet, resultSetIstoricComenzi);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    // RETURNEAZA CLIENTUL FARA ISTORIC AL COMENZILOR
    private Optional<Client> mapToClient(ResultSet resultSet, ResultSet resultSetIstoricComenzi) throws SQLException {

        if (resultSet.next()) {

            String nume = resultSet.getString("nume");
            String prenume = resultSet.getString("prenume");
            int nrComenzi = resultSet.getInt("nrComenzi");

            return Optional.of(new Client(nume, prenume ,nrComenzi, null));

            // NETERMINAT
            // trebuie extrase comenzile iar pentru fiecare comanda buchetele sau aranjamentele continute in ea

//            List<Comanda> comenziList = new ArrayList<>();
//
//            while(resultSetIstoricComenzi.next()) {
//                //Comanda[] comenzi = resultSetIstoricComenzi.getObject("comanda", Comanda[].class);
//                Comanda comanda = new Comanda();
//
//            }
//
//            return Optional.of(new Client(nume, prenume ,nrComenzi, comenzi));

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

            // audit
            String line = "Increment_nrComenzi_al_clientului," + Instant.now();
            afisareAudit(line);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
