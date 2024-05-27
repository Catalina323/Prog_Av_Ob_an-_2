package Proiect.Repository;

import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.Aranjament;
import Proiect.Domain.Buchet;
import Proiect.Domain.Comanda;
import Proiect.Domain.Dimensiuni;

import java.sql.*;
import java.util.Objects;
import java.util.Optional;

public class ComandaRepository {

    public int insert(int idAngajat, int idClient) {
        String insertComandaSql = "INSERT INTO comanda (id, idAngajat, idClient) VALUES (null, ?, ?)";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertComandaSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idAngajat);
            preparedStatement.setInt(2, idClient);

            int affectedRows = preparedStatement.executeUpdate();
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

    public Optional<Comanda> getById(int id) {
        String selectSql = "SELECT * FROM comanda p WHERE p.id = ?";
        String selectBucheteSql = "SELECT * FROM buchet p WHERE p.idComanda = ?";
        String selectAranjamenteSql = "SELECT * FROM aranjament p WHERE p.idComanda = ?";
        Connection conn = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            PreparedStatement preparedStatementBuchete = conn.prepareStatement(selectBucheteSql);
            preparedStatementBuchete.setInt(1, id);
            ResultSet resultSetBuchete = preparedStatementBuchete.executeQuery();

            PreparedStatement preparedStatementAranjamente = conn.prepareStatement(selectAranjamenteSql);
            preparedStatementAranjamente.setInt(1, id);
            ResultSet resultSetAranjamente = preparedStatementAranjamente.executeQuery();

            return mapToBuchet(resultSet, resultSetBuchete, resultSetAranjamente);
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

    private Optional<Comanda> mapToBuchet(ResultSet resultSet, ResultSet resultSetBuchete,
                                          ResultSet resultSetAranjamente) throws SQLException {
        if (resultSet.next()) {
            int idAngajat = resultSet.getInt("idAngajat");

            //Buchet[] buchete = new Buchet[5];
            int count = 0;
            while(resultSetBuchete.next()) {
                int id = resultSetBuchete.getInt("id");
                String nume = resultSetBuchete.getString("nume");
                int trandafiri = resultSetBuchete.getInt("trandafiri");
                int frezii = resultSetBuchete.getInt("frezii");
                int hortensii = resultSetBuchete.getInt("hortensii");
                int lalele = resultSetBuchete.getInt("lalele");
                int bujori = resultSetBuchete.getInt("bujori");
                boolean verdeata = resultSetBuchete.getBoolean("verdeata");
                Optional<Buchet> buchet = Optional.of(new Buchet.Builder(nume).withTrandafiri(trandafiri)
                        .withFrezii(frezii).withHortensii(hortensii).withLalele(lalele)
                        .withBujori(bujori).withVerdeata().build());

                if(buchet.isPresent()) {
                    //buchete[count] = buchet.get();
                    Buchet buchet1 = buchet.get();
                    count += 1;
                    Comanda comandaB = new Comanda(buchet1);
                    comandaB.setIdAngajat(idAngajat);
                    return Optional.of(comandaB);
                }
            }
//            if(count > 0) {
//                Comanda comandaB = new Comanda(buchete);
//                comandaB.setIdAngajat(idAngajat);
//                return Optional.of(comandaB);
//            }

            count = 0;
            Aranjament[] aranjamente = new Aranjament[5];
            while(resultSetAranjamente.next()) {
                int id = resultSetAranjamente.getInt("id");
                String nume = resultSetAranjamente.getString("nume");
                int trandafiri = resultSetAranjamente.getInt("trandafiri");
                int frezii = resultSetAranjamente.getInt("frezii");
                int hortensii = resultSetAranjamente.getInt("hortensii");
                int lalele = resultSetAranjamente.getInt("lalele");
                int bujori = resultSetAranjamente.getInt("bujori");
                boolean verdeata = resultSetAranjamente.getBoolean("verdeata");
                String dimensiune = resultSetAranjamente.getString("dimensiune");
                Optional<Aranjament> aranjament =  Optional.of(new Aranjament.Builder(nume, toDimensiune(dimensiune)).withTrandafiri(trandafiri)
                        .withFrezii(frezii).withHortensii(hortensii).withLalele(lalele)
                        .withBujori(bujori).withVerdeata().build());
                if(aranjament.isPresent()) {
                    aranjamente[count] = aranjament.get();
                    count += 1;
                }

                if(count > 0) {
                    Comanda comandaA = new Comanda(aranjamente);
                    comandaA.setIdAngajat(idAngajat);
                    return Optional.of(comandaA);
                }

            }


        }
        return Optional.empty();
    }

}

