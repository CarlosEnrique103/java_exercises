import java.util.ArrayList;
import java.util.Scanner;

public class NotesStudents {
    public static void main(String[] args){
        double[][] notes = new double[3][4];
        double highestAVG = 0;
        double highestNote = 0;
        double lowestNote = 20;
        int student = 0;
        int studentH = 0;
        int courseH = 0;
        int studentL = 0;
        int courseL = 0;

        double sumAverages = 0;

        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            System.out.print("Enter notes for student "+ (i+1)  + "\n");
            for(int j = 0; j < 4; j++) {
                double note;
                while(true) {
                    System.out.print("Course "+ (j + 1)  + ": ");
                    String value = input.nextLine();
                    try{
                        note = Double.parseDouble(value);
                        if(note >= 0 && note <= 20){
                            break;
                        }
                        System.out.println("Invalid note. Enter a value between 0 and 20.");
                    }catch (NumberFormatException e){
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }
                if(highestNote < note) {
                    highestNote = note;
                    studentH = i;
                    courseH = j;
                }
                if(note < lowestNote) {
                    lowestNote = note;
                    studentL = i;
                    courseL = j;
                }
                notes[i][j] = note;
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
            sumAverages += avgNotes;
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
        System.out.print("General average: " );
        System.out.printf(" %4.2f |", (sumAverages /3));

        System.out.println("Highest Note: " + highestNote);
        System.out.println("Lowest Note: " + lowestNote);

        System.out.println("Student Highest Note: " + (studentH + 1) + ", Course : " + (courseH + 1));
        System.out.println("Student Lowest Note: " + (studentL + 1) + ", Course : " + (courseL + 1));


        System.out.println("+-------------------------------+");
    }
}
