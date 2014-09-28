package com.rva.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rva.springtest.domain.Product;
import com.rva.springtest.repository.ProductDao;

public class SimpleProductManager implements ProductManager {
	
	private static final long serialVersionUID = 1L;
	@Autowired
    private ProductDao productDao;

	
	public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

	public void increasePrice(int percentage) {
		// obtengo la lista de productos del objeto DAO
		List<Product> products = productDao.getProductList();
		 
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue() * 
						(100 + percentage)/100;
				product.setPrice(newPrice);
				// vuelvo a actualizar en la base de datos 
				productDao.saveProduct(product);
			}
		}  
	}

	public List<Product> getProducts() {
		//return products; 
		return productDao.getProductList();
	}
	

}
