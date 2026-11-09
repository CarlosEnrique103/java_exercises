import java.util.Scanner;

public class CalculateArea {
    public static void main(String[] args){
        System.out.println("========== AREA CALCULATOR ==========");

        System.out.println("SQUARE");
        double side = inputCheck("Enter side: ");

        System.out.println("RECTANGLE");
        double rectangleBase = inputCheck("Enter base: ");;
        double rectangleHeight =inputCheck("Enter height: ");;

        System.out.println("TRIANGLE");
        double triangleBase = inputCheck("Enter base: ");;
        double triangleHeight =  inputCheck("Enter height: ");

        System.out.println("CIRCLE");
        double radio = inputCheck("Enter radio: ");

        System.out.println("=============RESULTS================");

        System.out.printf("Square area : %.2f%n", calculate(side));
        System.out.printf("Rectangle area: %.2f%n", calculate(rectangleBase, rectangleHeight));
        System.out.printf("Triangle area: %.2f%n", calculate(rectangleBase, rectangleHeight, true));
        System.out.printf("Circle area: %.2f%n", calculate(radio));

        System.out.println("=====================================");

    }
    public static int calculate(int side){
        return side * side;
    }
    public static double calculate(double side){
        return side * side * Math.PI;
    }
    public static double calculate(double base, double height){
        return base * height;
    }
    public static double calculate(double base, double height, boolean triangle){
        return (base * height)  / 2;
    }

    public static double inputCheck(String label) {
        double value;
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.printf(label);
            try {
                value = Double.parseDouble(input.nextLine());
                if(value > 0) break;
            } catch (NumberFormatException e) {
                System.out.println("Enter a correct format to number.");
            }

        }
        return value;
    }
}
