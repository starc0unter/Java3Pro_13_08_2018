import dao.DAO;
import dao.JdbcDaoImpl;
import model.Client;
import model.Phone;

import java.sql.*;
import java.util.List;

public class JdbcMain {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

        DAO dao = new JdbcDaoImpl(connection);

        try {
            List<Client> clients = dao.getAllClients();
            clients.forEach(System.out::println);

            System.out.println("Mobile phones");
            dao.getPhonesByType("Mobile").forEach(System.out::println);

            System.out.println("Work phones");
            dao.getPhonesByType("WORK").forEach(System.out::println);

            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            try {
                statement.executeUpdate("insert into Client (FIRST_NAME, LAST_NAME, BIRTH_DATE) values ('Oleg100', 'Petrov100', '1990-03-05')");
//                if (true)
//                throw new RuntimeException("Test error");
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
            }

//            for (int i = 10; i < 20; i++) {
//                statement.addBatch(String.format("insert into Client (FIRST_NAME, LAST_NAME, BIRTH_DATE) values ('Oleg%1$d', 'Petrov%1$d', '1990-03-%1$d')", i));
//            }
//            statement.executeBatch();

        } finally {
            connection.close();
        }
    }
}
