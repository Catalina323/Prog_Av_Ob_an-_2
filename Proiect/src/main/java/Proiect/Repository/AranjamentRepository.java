package Proiect.Repository;

import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.Aranjament;
import Proiect.Domain.Dimensiuni;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

public class AranjamentRepository {

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

    public void insert(Aranjament aranjament, int idComanda) {
        String insertAranjamentSql = "INSERT INTO aranjament (id, idComanda,  nume, trandafiri, frezii, hortensii"
                + ", lalele, bujori, verdeata, cos) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertAranjamentSql);
            preparedStatement.setInt(1, idComanda);
            preparedStatement.setString(2, aranjament.getNume());
            preparedStatement.setInt(3, aranjament.getTrandafiri());
            preparedStatement.setInt(4, aranjament.getFrezii());
            preparedStatement.setInt(5, aranjament.getHortensii());
            preparedStatement.setInt(6, aranjament.getLalele());
            preparedStatement.setInt(7, aranjament.getBujori());
            preparedStatement.setBoolean(8, aranjament.isVerdeata());
            preparedStatement.setString(9, aranjament.getDimensiune().toString());
            preparedStatement.execute();

            // afisarea in audit
            String line = "Inserare_aranjament," + Instant.now().toString();
            afisareAudit(line);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Aranjament> getById(int id) {
        String selectSql = "SELECT * FROM aranjament p WHERE p.id = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            // afisarea in audit
            String line = "Select_aranjament," + Instant.now().toString();
            afisareAudit(line);


            return mapToAranjament(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Dimensiuni toDimensiune(String dim){
        if(Objects.equals(dim, "SMALL")){
            return Dimensiuni.SMALL;
        }
        if(Objects.equals(dim, "MEDIUM")){
            return Dimensiuni.MEDIUM;
        }
        if(Objects.equals(dim, "LARGE")){
            return Dimensiuni.LARGE;
        }
        return null;
    }

    private Optional<Aranjament> mapToAranjament(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            int idComanda = resultSet.getInt("idComanda");
            String nume = resultSet.getString("nume");
            System.out.println("nume din baza de date din aranj repo " + nume);
            int trandafiri = resultSet.getInt("trandafiri");
            int frezii = resultSet.getInt("frezii");
            int hortensii = resultSet.getInt("hortensii");
            int lalele = resultSet.getInt("lalele");
            int bujori = resultSet.getInt("bujori");
            boolean verdeata = resultSet.getBoolean("verdeata");
            String dimensiune = resultSet.getString("dimensiune");
            return Optional.of(new Aranjament.Builder(nume, toDimensiune(dimensiune)).withTrandafiri(trandafiri)
                    .withFrezii(frezii).withHortensii(hortensii).withLalele(lalele)
                    .withBujori(bujori).withVerdeata().build());
        }
        return Optional.empty();
    }

    public void updateNume(String nume, int id) {
        String updateAranjamentSql = "UPDATE aranjament SET nume = ? WHERE id = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(updateAranjamentSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            // afisarea in audit
            String line = "Update_nume_aranjament," + Instant.now().toString();
            afisareAudit(line);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
