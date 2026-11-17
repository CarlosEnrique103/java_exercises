package poo;

public class Product {

    private String name;
    private double price;
    private int stock;
    private String category;

    public Product(String name, double price, int stock, String category) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name its required.");
        }
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if(stock < 0) {
            throw new IllegalArgumentException("Stock must be greater or equal than 0.");
        }
        if(category == null || category.isBlank()){
            throw new IllegalArgumentException("Category must not be empty.");
        }
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public Product(String name, double price) {
        this(name, price, 0, "Uncategorized");
    }

    public Product() {
        this("Unknown", 0, 0, "Uncategorized");
    }


    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name must not be empty.");
        } else  {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        } else {
            this.price = price;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock < 0) {
            throw new IllegalArgumentException("Stock must be greater or equal than 0");
        } else {
            this.stock = stock;
        }
    }

    public void setCategory(String category) {
        if(category == null || category.isBlank()){
            throw new IllegalArgumentException("Category it's required.");
        } else  {
            this.category = category;
        }
    }

    public void showInformation(){
        System.out.println("Name: " + name);
        System.out.printf("Price: %.2f%n", price);
        System.out.println("Stock: " + stock);
        System.out.println("Category: " + category);
        System.out.println("-------------------------");
    }
}
