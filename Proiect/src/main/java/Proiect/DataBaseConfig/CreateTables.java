package Proiect.DataBaseConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    public void createTableBuchet() {
        String createTableSql = """ 
            CREATE TABLE IF NOT EXISTS buchet (
                id int PRIMARY KEY AUTO_INCREMENT,
                idComanda int, 
                nume varchar(40),
                trandafiri int,
                frezii int,
                hortensii int,
                lalele int,
                bujori int,
                verdeata boolean,
                FOREIGN KEY (idComanda) REFERENCES comanda (id)
                )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableAranjament() {
        String createTableSql = """ 
            CREATE TABLE IF NOT EXISTS aranjament (
                id int PRIMARY KEY AUTO_INCREMENT,
                idComanda int, 
                nume varchar(40),
                trandafiri int,
                frezii int,
                hortensii int,
                lalele int,
                bujori int,
                cos varchar(10),
                verdeata boolean,
                foreign key (idComanda) references comanda (id)
            )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableAngajat() {
        String createTableSql = """ 
            CREATE TABLE IF NOT EXISTS angajat (
                id int PRIMARY KEY AUTO_INCREMENT,
                nume varchar(40),
                prenume varchar(40),
                varsta int,
                salariu int
            )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // one to many intre comanda si buchet/aranjament
    // am pus id ul comenzii la buchete sau aranjamente
    public void createTableComanda() {
        String createTableSql = """ 
            CREATE TABLE IF NOT EXISTS comanda (
                id int PRIMARY KEY AUTO_INCREMENT,
                idAngajat int, 
                idClient int,
                foreign key (idAngajat) references angajat (id),
                foreign key (idClient) references client (id)
            )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // one to many client comanda
    // am pus id ul clientului la comanda
    public void createTableClient() {
        String createTableSql = """ 
            CREATE TABLE IF NOT EXISTS client (
                id int PRIMARY KEY AUTO_INCREMENT,
                nume varchar(40),
                prenume varchar(40),
                nrComenzi int
            )
            """;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
