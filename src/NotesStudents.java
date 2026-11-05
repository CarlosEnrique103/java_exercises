import java.util.ArrayList;
import java.util.Scanner;

public class NotesStudents {
    public static void main(String[] args){
        double[][] notes = new double[3][4];
        ArrayList<Double> averages = new ArrayList<>();
        double highestAVG = 0;
        int student = 0;

        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.print("Enter notes for student "+ (i+1)  + "\n");
            for(int j = 0; j < 4; j++) {
                System.out.print("Course "+ (j + 1)  + ": ");
                notes[i][j] = Double.parseDouble(input.nextLine());
            }
        }
        System.out.println("+------------+----------+----------+----------+----------+----------+");
        System.out.printf("| %-10s | %8s | %8s | %8s | %8s | %8s |%n",
                "Student", "Course 1", "Course 2", "Course 3", "Course 4", "Average");
        System.out.println("+------------+----------+----------+----------+----------+----------+");
        for(int i = 0; i < 3; i++) {
            System.out.printf("| %-10s |", "Student " + (i + 1));
            double sumNotes = 0;
            for(int j = 0; j < 4; j++) {
                sumNotes += notes[i][j];
                System.out.printf(" %8.2f |", notes[i][j]);
            }
            double avgNotes = sumNotes /4;
            averages.add(avgNotes);
            if(highestAVG < avgNotes) {
                highestAVG = avgNotes;
                student = i;
            }
            System.out.printf(" %8.2f |", avgNotes);
            System.out.println();
        }
        System.out.println("+------------+----------+----------+----------+----------+----------+");

        System.out.println("+------------RESULTS------------+");
        System.out.println("Highest average:");

        System.out.println("Student "+(student + 1) + " - " +highestAVG);

        System.out.println("General average:");
        double sumNotes = 0;
        for (double average : averages) {
            sumNotes += average;
        }

        System.out.println((sumNotes /3));

        System.out.println("+-------------------------------+");
    }
}
