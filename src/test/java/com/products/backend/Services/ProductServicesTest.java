package com.products.backend.Services;

import com.products.backend.domain.Product;
import com.products.backend.repositories.database.IProductMongoRepository;
import com.products.backend.services.implemetantions.ProductServices;
import com.products.backend.services.implemetantions.ScrapingFerrolux;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Map;
import java.util.Optional;

//@SpringBootTest
public class ProductServicesTest {

//    @Autowired
//    private IProductMongoRepository repo;
//
//
//    @Autowired
//    private ProductServices productServices;
//
//    @BeforeEach
//    void setUp() {
//    }

//    @Test
//    void save() {

//        Map<String, String> atributesProduct = ScrapingFerrolux.extraerAtributosProducto("https://ferrolux.com.ar/ficha/producto/1674");
//
//        Product product = new Product();
//
//        for (Map.Entry<String, String> entry : atributesProduct.entrySet()) {
//            String attributeName = entry.getKey();
//            String attributeValue = entry.getValue();
//
//            // Compara con los atributos fijos y asigna valores
//            switch (attributeName) {
//                case "code":
//                    product.setCode(attributeValue);
//                    break;
//                case "description":
//                    product.setDescription(attributeValue);
//                    break;
//                case "price":
//                    product.setPrice(Double.parseDouble(attributeValue));
//                    break;
//                default:
//                    // Si no es un atributo fijo, agrégalo al mapa de características
//                    product.getCharacteristics().put(attributeName, attributeValue);
//                    break;
//            }
//            productServices.save(product);
//            Optional<Product> producto = productServices.getProdcut("AP-1002");
//
//            assert producto.get().getCode().toString().equals("AP-1002");
//        }
//    }

}
