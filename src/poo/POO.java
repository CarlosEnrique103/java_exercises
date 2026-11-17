package poo;

public class POO {
    public static void main(String[] args){
        Product product1 = null;
        Product product2 = null;
        Product product3 = null;

        try {
            System.out.println("Creating Product 1...");
            product1 = new Product(
                    "Laptop", -50, 10, "Electronics"
            );

        } catch (IllegalArgumentException e) {
            System.out.println("Error creating product: " + e.getMessage());
        }
        if(product1 != null) {
            System.out.println("Product created successfully!");
        }

        try {
            System.out.println("Creating Product 2...");
            product2 = new Product("Keyboard", 120.0);
        } catch (IllegalArgumentException e) {

            System.out.println("Error creating product: " + e.getMessage());

        }
        if(product2 != null) {
            System.out.println("Product created successfully!");
        }

        try {
            System.out.println("Creating Product 3...");
            product3 = new Product();
        } catch (IllegalArgumentException e) {

            System.out.println("Error creating product: " + e.getMessage());

        }
        if(product3 != null) {
            System.out.println("Product created successfully!");
        }


        System.out.println("========== PRODUCT INVENTORY ==========");
        if(product1 != null) {
            System.out.println("Product 1");
            product1.showInformation();
        }


        if(product2 != null) {
            System.out.println("Product 2");
            product2.showInformation();
        }


        if(product3 != null) {
            System.out.println("Product 3");
            product3.showInformation();
        }

        System.out.println("=======================================");


    }
}
