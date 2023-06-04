package main;

public class Product {
    private String id;

    private String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
