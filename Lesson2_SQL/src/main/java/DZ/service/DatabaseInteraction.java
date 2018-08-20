package DZ.service;

import DZ.dao.ProductDAO;

import java.io.Closeable;
import java.sql.Connection;

public interface DatabaseInteraction extends AutoCloseable {

    void initialize();

    ProductDAO getDAO();
}
