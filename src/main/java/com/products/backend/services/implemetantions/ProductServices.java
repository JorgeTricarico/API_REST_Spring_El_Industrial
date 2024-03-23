package com.products.backend.services.implemetantions;

import com.products.backend.domain.Product;
import com.products.backend.repositories.database.IProductJpaRepository;
import com.products.backend.services.interfaces.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ProductServices implements IProductServices {

    @Autowired
    private IProductJpaRepository repo;

    @Autowired
    private ScrapingFerrolux scraping;

    public void save() {
        Map<String, String> atributesProduct = ScrapingFerrolux.extraerAtributosProducto("https://ferrolux.com.ar/ficha/producto/1674");

        Product product = new Product();

        for (Map.Entry<String, String> entry : atributesProduct.entrySet()) {
            String attributeName = entry.getKey();
            String attributeValue = entry.getValue();

            // Compara con los atributos fijos y asigna valores
            switch (attributeName) {
                case "code":
                    product.setCode(attributeValue);
                    break;
                case "description":
                    product.setDescription(attributeValue);
                    break;
                case "price":
                    product.setPrice(Double.parseDouble(attributeValue));
                    break;
                default:
                    // Si no es un atributo fijo, agrégalo al mapa de características
                    product.getCharacteristics().put(attributeName, attributeValue);
                    break;
            }

        }
    }
    public Optional<Product> getProdcut(String code){

        return repo.findByCodeIgnoreCase(code);
    }




}
