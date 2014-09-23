package com.rva.springtest.repository;

import java.util.List;
import com.rva.springtest.domain.Product;

public interface ProductDao {
    public List<Product> getProductList();

    public void saveProduct(Product prod);
}
