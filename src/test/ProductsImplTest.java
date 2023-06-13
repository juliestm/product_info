package test;

import main.Product;
import main.ProductsImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsImplTest {

    private final ProductsImpl impl = new ProductsImpl(getTestMapById(), getTestMapByName());

    void addProductGetTrue() {
        Product product = new Product("5", "name5");

        if (impl.addProduct(product)) {
            System.out.println("Тест прошел: продукт добавлен");
        } else {
            System.out.println("НЕ ПРОШЕЛ ТЕСТ");
        }
    }

    void addProductGetFalse() {
        Product product = new Product("1", "name1");

        if (!impl.addProduct(product)) {
            System.out.println("Тест прошел: продукт НЕ добавлен");
        } else {
            System.out.println("НЕ ПРОШЕЛ ТЕСТ");
        }
    }

    void deleteProductGetTrue() {
        Product product = new Product("2", "name2");

        if (impl.deleteProduct(product)) {
            System.out.println("Тест прошел: продукт удален");
        } else {
            System.out.println("НЕ ПРОШЕЛ ТЕСТ");
        }
    }

    void deleteProductGetFalse() {
        Product product = new Product("7", "name7");

        if (!impl.deleteProduct(product)) {
            System.out.println("Тест прошел: продукт НЕ удален");
        } else {
            System.out.println("НЕ ПРОШЕЛ ТЕСТ");
        }
    }

    void getName() {
        String actualName = "Name3";

        if (impl.getName("3").equals(actualName)) {
            System.out.println("Тест прошел: продукт найден по id");
        } else {
            System.out.println("НЕ ПРОШЕЛ ТЕСТ");
        }
    }

    void findByName() {
        List<String> actualList = new ArrayList<>();
        actualList.add("1");
        actualList.add("4");

        List<String> expectedList = impl.findByName("Name1");

        if (expectedList.size() == 2 && expectedList.get(0).equals(actualList.get(0))
                && expectedList.get(1).equals(actualList.get(1))) {
            System.out.println("Тест прошел: получен список id продуктов");
        } else {
            System.out.println("НЕ ПРОШЕЛ ТЕСТ");
        }
    }

    private Map<String, String> getTestMapById() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("1", "Name1");
        resultMap.put("2", "Name2");
        resultMap.put("3", "Name3");
        resultMap.put("4", "Name1");

        return resultMap;
    }

    private Map<String, List<String>> getTestMapByName() {
        Map<String, List<String>> resultMap = new HashMap<>();
        resultMap.put("Name1", List.of("1", "4"));
        resultMap.put("Name2", List.of("2"));
        resultMap.put("Name3", List.of("3"));

        return resultMap;
    }

    public void runAllTests() {
        addProductGetTrue();
        addProductGetFalse();
        deleteProductGetTrue();
        deleteProductGetFalse();
        getName();
        findByName();
    }

}