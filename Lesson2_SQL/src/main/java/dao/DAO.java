package dao;

import model.Client;
import model.Phone;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

    List<Client> getAllClients() throws SQLException;

    Client getClientById(int id);

    List<Phone> getPhonesByType(String type) throws SQLException;
}
