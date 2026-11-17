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
        int option = 0;
        boolean noExit = true;
        while(noExit) {
            option = menu(input);
            switch (option){
                case 1:
                    register(input, products);
                    break;
                case 2:
                    search(input, products);
                    break;
                case 8:
                    noExit = false;
                    break;
                default:
                    noExit = false;
                    break;
            }
        }
//
//        while (true) {
//            System.out.print("Enter quantity of products: ");
//            try {
//                quantityProducts = Integer.parseInt(input.nextLine());
//                if(quantityProducts > 0) {
//                    break;
//                }
//                System.out.println("Enter a number greater than zero.");
//            } catch (NumberFormatException e) {
//                System.out.println("Enter a correct number.");
//            }
//        }
//        System.out.println();
//
//
//        for(int i = 0; i < quantityProducts; i++){
//            Product product = null;
//            try {
//                System.out.printf("Creating Product %d...\n", (i + 1));
//                product = createProduct(input);
//
//            } catch (IllegalArgumentException e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//            if(product != null) {
//                products.add(product);
//                System.out.println("Product created successfully!");
//            }
//        }
//
//        System.out.println("\n========== REGISTERED PRODUCTS =========\n");
//        System.out.printf("%-12s %10s  %s%n", "Product", "Price", "Stock");
//        System.out.println("-----------------------------------------");
//
//        for (Product product: products) {
//            if (expensiveProduct == null || product.getPrice() > expensiveProduct.getPrice()) {
//                expensiveProduct = product;
//            }
//            System.out.printf("%-12s %10.2f  %d%n",
//                    product.getName(),
//                    product.getPrice(),
//                    product.getStock());
//            totalInventoryValue += product.getPrice() * product.getStock();
//        }
//
//        System.out.println("\n=======================================\n");
//        System.out.println("\n======== INVENTORY SUMMARY ============\n");
//        System.out.printf("Total products requested:  %d%n", quantityProducts);
//        System.out.printf("Successfully registered:  %d%n", (products.size()));
//        System.out.printf("Rejected products:  %d%n", (quantityProducts - products.size()));
//        System.out.printf("Total inventory value: %.2f%n", totalInventoryValue);
//        System.out.println();
//        if(expensiveProduct != null){
//            System.out.println("Most expensive product: ");
//            System.out.printf("Name: %s\n", expensiveProduct.getName());
//            System.out.printf("Price:  %4.2f", expensiveProduct.getPrice());
//        } else  {
//            System.out.println("No products available.");
//        }

//        System.out.println("\n============================================\n");
//        System.out.println("\n           END OF INVENTORY REPORT          \n");
//        System.out.println("\n============================================\n");
    }

    public static void register(Scanner input, ArrayList<Product> products){
        Product product = null;

        System.out.println("========== REGISTER PRODUCT ==========");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(input.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(input.nextLine());
        System.out.print("Category: ");
        String category = input.nextLine();
        try {
            product = new Product(
                    name, price, stock, category);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Product registered successfully!");
        products.add(product);
    }
    public static int menu(Scanner input){
        int option = 1;
        System.out.println("\n========================================");
        System.out.println("     PRODUCT MANAGEMENT SYSTEM          ");
        System.out.println("========================================\n");
        System.out.println("1. Register product");
        System.out.println("2. Search product by name");
        System.out.println("3. Filter products by category");
        System.out.println("4. Show total inventory units");
        System.out.println("5. Show product with highest stock");
        System.out.println("6. Update product stock");
        System.out.println("7. Show all products");
        System.out.println("8. Exit");
        System.out.println("\n============================================\n");
        while(true) {
            System.out.print("Select an option: ");
            try {
                option = Integer.parseInt(input.nextLine());
                if(option > 0 && option <= 8){
                    break;
                }
                System.out.println("Enter a correct option.");
            }catch (NumberFormatException e) {
                System.out.println("Enter a correct option.");
            }
        }
        return option;
    }

    public static void search(Scanner input, ArrayList<Product> products){
        System.out.println("\n========== SEARCH PRODUCT ==========\n");
        System.out.print("Enter product name: : ");
        String name = input.nextLine();

        boolean found = false;
        for(Product product: products) {
            if(product.getName().equalsIgnoreCase(name)){
                found =true;

                System.out.println("Product found!");
                System.out.printf("Name: %s%n", product.getName());
                System.out.printf("Price:  %4.2f%n", product.getPrice());
                System.out.printf("Stock: %d%n", product.getStock());
                System.out.printf("Category: %s%n", product.getCategory());
                break;
            }
        }

        if (!found) {
            System.out.println("\nProduct not found!");
        }
    }


}
