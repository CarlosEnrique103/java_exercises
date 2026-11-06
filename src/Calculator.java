import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String answer = "yes";
        System.out.println("========== CALCULATOR ==========\n");
        while(answer.equalsIgnoreCase("yes")) {
            int option = showMenu(input);
            double num1;
            double num2;

            while(true) {
                System.out.print("Enter first number: ");
                try {
                    num1 = Double.parseDouble(input.nextLine());
                    if(Double.isFinite(num1)) {
                        break;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a correct number");
                }
            }

            while(true) {
                System.out.print("Enter second number: ");
                try {
                    num2 = Double.parseDouble(input.nextLine());
                    if(Double.isFinite(num1)) {
                        break;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a correct number.");
                }
            }

            if(num2 == 0 && option == 4){
                System.out.println("Cannot divide by zero.\n");
            } else {
                double result = calculate(num1, num2, option);
                showResults(num1, num2, result, option);

            }
            answer = askToContinue(input);
        }
        System.out.println("Thank you for using the calculator! :)");
        input.close();
    }
    public static int showMenu(Scanner input) {
        int option;
        List<Integer> options = Arrays.asList(1, 2, 3, 4);

        while(true) {
            System.out.println("1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n");

            try {
                System.out.print("Select operation: ");
                option = Integer.parseInt(input.nextLine());
                if(options.contains(option)) {
                    break;
                }
                System.out.println("Enter a correct option, (1, 2, 3, 4)\n");
            } catch (NumberFormatException e) {
                System.out.println("Enter a correct number");
            }
        }
        System.out.println();
        return option;
    }
    public static void showResults(double num1, double num2, double result, int option) {
        String operator = switch (option) {
            case 1 -> "+";
            case 2 -> "-";
            case 3 -> "x";
            case 4 -> "/";
            default -> "";
        };
        System.out.println("=========== RESULT =============");
        System.out.printf("%.2f %s %.2f = %.2f%n", num1, operator, num2, result);
    }
    public static String askToContinue(Scanner input) {
        String answer;
        while(true) {
            System.out.print("Do you want to continue? (yes/no): ");
            answer = input.nextLine();
            if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                break;
            }else {
                System.out.println("Invalid answer. Please enter yes or no.");
            }
        }
        System.out.println();

        return answer;
    }
    public static double calculate(double num1, double num2, int option) {
        return switch (option) {
            case 1 -> sum(num1, num2);
            case 2 -> subtraction(num1, num2);
            case 3 -> multiplication(num1, num2);
            case 4 -> division(num1, num2);
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }
    public static double sum(double num1, double num2){
        return num1 + num2;
    }

    public static double subtraction(double num1, double num2){
        return num1 - num2;
    }

    public static double multiplication(double num1, double num2){
        return num1 * num2;
    }

    public static double division(double num1, double num2){
        return num1 / num2;
    }
}
