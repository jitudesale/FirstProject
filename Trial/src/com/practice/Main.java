package com.practice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface InventoryManager {
    void addProduct(Product product);
    void removeProduct(Product product);
    void updateInventory(Product product, int quantity);
    void displayInventory();
    void displayTotalValue();
    List<Product> searchByName(String name);
    List<Product> searchByCategory(Category category);
}

class Product {
    private int id;
    private String name;
    private Category category;
    private double price;

    public Product(int id, String name, Category category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class InventoryItem {
    private Product product;
    private int quantity;

    public InventoryItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class InventoryManagerImpl implements InventoryManager {
    private List<Product> products;
    private List<Category> categories;
    private Map<Product, Integer> inventory;

    public InventoryManagerImpl() {
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.inventory = new HashMap<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
        inventory.remove(product);
    }

    @Override
    public void updateInventory(Product product, int quantity) {
        inventory.put(product, quantity);
    }

    @Override
    public void displayInventory() {
        for (Product product : products) {
            int quantity = inventory.getOrDefault(product, 0);
            System.out.println(product.getName() + " - Stock: " + quantity);
        }
    }

    @Override
    public void displayTotalValue() {
        double totalValue = 0;
        for (Product product : products) {
            int quantity = inventory.getOrDefault(product, 0);
            double value = product.getPrice() * quantity;
            totalValue += value;
        }
        System.out.println("Total Value: $" + totalValue);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }

    @Override
    public List<Product> searchByCategory(Category category) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        InventoryManager inventoryManager = new InventoryManagerImpl();

        // Creating categories
        Category electronicsCategory = new Category(1, "Electronics");
        Category clothingCategory = new Category(2, "Clothing");

        // Creating products
        Product laptop = new Product(1, "Laptop", electronicsCategory, 1500.0);
        Product tShirt = new Product(2, "T-Shirt", clothingCategory, 20.0);

        // Adding products to inventory
        inventoryManager.addProduct(laptop);
        inventoryManager.addProduct(tShirt);

        // Updating stock levels
        inventoryManager.updateInventory(laptop, 5);
        inventoryManager.updateInventory(tShirt, 10);

        // Displaying inventory
        inventoryManager.displayInventory();

        // Displaying total value
        inventoryManager.displayTotalValue();

        // Searching for products
        List<Product> searchResults = inventoryManager.searchByName("Laptop");
        System.out.println("Search Results:");
        for (Product product : searchResults) {
            System.out.println(product.getName());
        }
    }
}


