package poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args){
        int quantityProducts;
        double totalInventoryValue = 0;
        Product expensiveProduct = null;


        Scanner input = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        System.out.println("========== PRODUCT INVENTORY ==========\n");
        while (true) {
            System.out.print("Enter quantity of products: ");
            try {
                quantityProducts = Integer.parseInt(input.nextLine());
                if(quantityProducts > 0) {
                    break;
                }
                System.out.println("Enter a number greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Enter a correct number.");
            }
        }
        System.out.println();


        for(int i = 0; i < quantityProducts; i++){
            Product product = null;
            try {
                System.out.printf("Creating Product %d...\n", (i + 1));
                product = createProduct(input);

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            if(product != null) {
                products.add(product);
                System.out.println("Product created successfully!");
            }
        }

        System.out.println("\n========== REGISTERED PRODUCTS =========\n");
        System.out.printf("%-12s %10s  %s%n", "Product", "Price", "Stock");
        System.out.println("-----------------------------------------");

        for (Product product: products) {
            if (expensiveProduct == null || product.getPrice() > expensiveProduct.getPrice()) {
                expensiveProduct = product;
            }
            System.out.printf("%-12s %10.2f  %d%n",
                    product.getName(),
                    product.getPrice(),
                    product.getStock());
            totalInventoryValue += product.getPrice() * product.getStock();
        }

        System.out.println("\n=======================================\n");
        System.out.println("\n======== INVENTORY SUMMARY ============\n");
        System.out.printf("Total products requested:  %d%n", quantityProducts);
        System.out.printf("Successfully registered:  %d%n", (products.size()));
        System.out.printf("Rejected products:  %d%n", (quantityProducts - products.size()));
        System.out.printf("Total inventory value: %.2f%n", totalInventoryValue);
        System.out.println();
        if(expensiveProduct != null){
            System.out.println("Most expensive product: ");
            System.out.printf("Name: %s\n", expensiveProduct.getName());
            System.out.printf("Price:  %4.2f", expensiveProduct.getPrice());
        } else  {
            System.out.println("No products available.");
        }

        System.out.println("\n============================================\n");
        System.out.println("\n           END OF INVENTORY REPORT          \n");
        System.out.println("\n============================================\n");




    }

    public static Product createProduct(Scanner input){
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(input.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(input.nextLine());
        System.out.print("Category: ");
        String category = input.nextLine();
        return new Product(
                name, price, stock, category
        );
    }
}
