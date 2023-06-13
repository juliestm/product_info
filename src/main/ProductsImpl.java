package main;

import java.util.*;

public class ProductsImpl extends Product {
    private final Map<String, String> productsById;

    private final Map<String, List<String>> productsByName;

    public ProductsImpl(Map<String, String> productsById, Map<String, List<String>> productsByName) {
        super();
        this.productsById = productsById;
        this.productsByName = productsByName;
    }

    public boolean addProduct(Product product) {
        List<String> ids = new ArrayList<>();
        String productId = product.getId();
        String productName = product.getName();
        if (!productsById.containsKey(productId)) {
            productsById.put(productId, productName);

            if (!productsByName.containsKey(productName)) {
                ids.add(productId);
                productsByName.put(product.getName(), ids);
            } else {
                productsByName.get(productName).add(productId);
            }

            return true;
        }

        return false;
    }

    public boolean deleteProduct(Product product) {

        String productId = product.getId();
        if (productsById.containsKey(productId)) {
            productsById.remove(productId);
            productsByName.get(product.getName()).remove(productId);
            return true;
        }

        return false;
    }

    public String getName(String id) {

        if (productsById.containsKey(id)) {
            return productsById.get(id);
        }

        return "";
    }

    public List<String> findByName(String name) {
        if (productsByName.containsKey(name)) {
            return productsByName.get(name);
        }

        return Collections.emptyList();
    }

}
