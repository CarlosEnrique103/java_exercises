import java.util.Scanner;

public class CalculateArea {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("========== AREA CALCULATOR ==========");

        System.out.println("SQUARE");
        double side = inputCheck(input, "Enter side: ");

        System.out.println("RECTANGLE");
        double rectangleBase = inputCheck(input, "Enter base: ");
        double rectangleHeight =inputCheck(input, "Enter height: ");

        System.out.println("TRIANGLE");
        double triangleBase = inputCheck(input, "Enter base: ");
        double triangleHeight =  inputCheck(input, "Enter height: ");

        System.out.println("CIRCLE");
        double radius = inputCheck(input, "Enter radius: ");

        showResults(side, rectangleBase, rectangleHeight, triangleBase, triangleHeight, radius);


    }
    public static double calculate(double side){
        return side * side;
    }
    public static double calculate(double side, boolean circle){
        return side * side * Math.PI;
    }
    public static double calculate(double base, double height){
        return base * height;
    }
    public static double calculate(double base, double height, boolean triangle){
        return (base * height)  / 2;
    }

    public static double inputCheck( Scanner input, String label) {
        double value;
        while(true) {
            System.out.print(label);
            try {
                value = Double.parseDouble(input.nextLine());
                if (Double.isFinite(value) && value > 0) {
                    break;
                }
                System.out.println("Enter a finite number greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Enter a correct format to number.");
            }

        }
        return value;
    }

    public static void showResults(double side, double rectangleBase, double rectangleHeight, double triangleBase, double triangleHeight, double radius){
        System.out.println("=============RESULTS================");

        System.out.printf("Square area : %.2f%n", calculate(side));
        System.out.printf("Rectangle area: %.2f%n", calculate(rectangleBase, rectangleHeight));
        System.out.printf("Triangle area: %.2f%n", calculate(triangleBase, triangleHeight, true));
        System.out.printf("Circle area: %.2f%n", calculate(radius, true));

        System.out.println("=====================================");

    }
}
