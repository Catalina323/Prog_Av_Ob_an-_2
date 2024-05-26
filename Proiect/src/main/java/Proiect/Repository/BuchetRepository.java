package Proiect.Repository;

import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.Buchet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class BuchetRepository {

    public void insert(Buchet buchet, int idComanda) {
        String insertBuchetSql = "INSERT INTO buchet (id, idComanda, nume, trandafiri, frezii, hortensii"
                + ", lalele, bujori, verdeata) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertBuchetSql);
            preparedStatement.setInt(1, idComanda);
            preparedStatement.setString(2, buchet.getNume());
            preparedStatement.setInt(3, buchet.getTrandafiri());
            preparedStatement.setInt(4, buchet.getFrezii());
            preparedStatement.setInt(5, buchet.getHortensii());
            preparedStatement.setInt(6, buchet.getLalele());
            preparedStatement.setInt(7, buchet.getBujori());
            preparedStatement.setBoolean(8, buchet.isVerdeata());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Buchet> getById(int id) {
        String selectSql = "SELECT * FROM buchet p WHERE p.id = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToBuchet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Optional<Buchet> mapToBuchet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nume = resultSet.getString("nume");
            int trandafiri = resultSet.getInt("trandafiri");
            int frezii = resultSet.getInt("frezii");
            int hortensii = resultSet.getInt("hortensii");
            int lalele = resultSet.getInt("lalele");
            int bujori = resultSet.getInt("bujori");
            boolean verdeata = resultSet.getBoolean("verdeata");
            return Optional.of(new Buchet.Builder(nume).withTrandafiri(trandafiri)
                    .withFrezii(frezii).withHortensii(hortensii).withLalele(lalele)
                    .withBujori(bujori).withVerdeata().build());
        }
        return Optional.empty();
    }

    public void updateNume(String nume, int id) {
        String updateBuchetSql = "UPDATE buchet SET nume = ? WHERE id = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(updateBuchetSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
