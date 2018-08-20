package DZ.dao;

import DZ.model.Id;
import DZ.model.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    Product getById(Long id) throws UnknownProductException;

    List<Product> getAll();

    Product getByProductId(Id<Long> productId) throws  UnknownProductException;

    BigDecimal getProductCostByTitle(String title) throws UnknownProductException;

    void changeProductCost(String  productTitle, BigDecimal newCost) throws UnknownProductException;

    List<Product> getProducts(String productAlias, String whereClause);

    void executeQuery(String query);
}
