package main;

import java.util.*;

public class ProductsImpl extends Product {
    public Map<String, String> products;

    public ProductsImpl(Map<String, String> products) {
        super();
        this.products = products;
    }

    public boolean addProduct(Product product) {

        String productId = product.getId();
        if (!products.containsKey(productId)) {
            products.put(productId, product.getName());
            return true;
        }

        return false;
    }

    public boolean deleteProduct(Product product) {

        String productId = product.getId();
        if (products.containsKey(productId)) {
            products.remove(productId);
            return true;
        }

        return false;
    }

    public String getName(String id) {

        if (products.containsKey(id)) {
            return products.get(id);
        }

        return "";
    }

    public List<String> findByName(String name) {
        List<String> resultIdList = new ArrayList<>();

        for (Map.Entry<String, String> entry : products.entrySet()) {
            if(entry.getValue().equals(name)) {
                resultIdList.add(entry.getKey());
            }
        }

        return resultIdList;
    }

}
