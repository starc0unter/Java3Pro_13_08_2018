package dao;

import model.Client;
import model.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDaoImpl implements DAO {

    private Connection connection;

    public JdbcDaoImpl(Connection connection) {
        this.connection = connection;
    }

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
        }
    }

    @Override
    public List<Client> getAllClients() throws SQLException {
        String query = "SELECT * FROM Client";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Client> clients = new ArrayList<>();
        while (resultSet.next()) {
            clients.add(convertToClient(resultSet));
        }
        return clients;
    }

    private Client convertToClient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getInt(1));
        client.setFirstName(resultSet.getString(2));
        client.setLastName(resultSet.getString(3));
        return client;
    }

    @Override
    public Client getClientById(int id) {
        return null;
    }

    @Override
    public List<Phone> getPhonesByType(String type) throws SQLException {
        String sql = "SELECT * FROM PHONE WHERE TYPE = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, type);
        ResultSet resultSet = statement.executeQuery();

        List<Phone> phones = new ArrayList<>();
        while (resultSet.next()) {
            Phone phone = new Phone();
            phone.setId(resultSet.getInt(1));
            phone.setType(resultSet.getString(3));
            phone.setNumber(resultSet.getString(4));
            phones.add(phone);
        }

        return phones;
    }
}
