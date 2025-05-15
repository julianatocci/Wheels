package Wheels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteHandler {
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS rentals (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "postcode TEXT NOT NULL," +
                "bikeNumber INTEGER NOT NULL," +
                "numberOfDays INTEGER NOT NULL," +
                "startDate TEXT NOT NULL" +
                ");";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'rentals' criada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }

    public static void saveHireToDatabase(Hire hire) {
        String sql = "INSERT INTO rentals(name, postcode, bikeNumber, numberOfDays, startDate) " +
                "VALUES(?,?,?,?,?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hire.getCustomer().getName());
            pstmt.setString(2, hire.getCustomer().getPostcode());
            pstmt.setInt(3, hire.getBike().getBikeNumber());
            pstmt.setInt(4, hire.getNumberOfDays());
            pstmt.setString(5, hire.getStartDate().toString());

            pstmt.executeUpdate();
            System.out.println("Aluguel salvo.");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar aluguel: " + e.getMessage());
        }
    }

    public static void listRentals() {
        String sql = "SELECT * FROM rentals";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nRegistros de Aluguéis");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Nome: " + rs.getString("name") +
                        " | Postcode: " + rs.getString("postcode") +
                        " | Bike: " + rs.getInt("bikeNumber") +
                        " | Dias: " + rs.getInt("numberOfDays") +
                        " | Início: " + rs.getString("startDate"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar aluguéis: " + e.getMessage());
        }
    }
}
