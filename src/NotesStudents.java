import java.util.ArrayList;
import java.util.Scanner;

public class NotesStudents {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int quantityStudents;
        int quantityCourses;
        int minNote;
        int maxNote;
        ArrayList<Double> studentsAvg = new ArrayList<Double>();

        double highestAVG = Double.NEGATIVE_INFINITY;
        double highestNote = Double.NEGATIVE_INFINITY;
        double lowestNote = Double.POSITIVE_INFINITY;
        int studentH = 0;
        int courseH = 0;
        int studentL = 0;
        int courseL = 0;

        double sumAverages = 0;

        while(true) {
            System.out.print("Enter quantity of students: ");
            String value = input.nextLine();
            try {
                quantityStudents = Integer.parseInt(value);

                if(quantityStudents > 0) {
                    break;
                }

                System.out.println("Enter a number greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        while(true) {
            System.out.print("Enter quantity of course: ");
            String value = input.nextLine();
            try {
                quantityCourses = Integer.parseInt(value);

                if(quantityCourses > 0) {
                    break;
                }

                System.out.println("Enter a number greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        while(true) {
            System.out.print("Enter minimum note: ");
            String value = input.nextLine();
            try {
                minNote = Integer.parseInt(value);

                if(minNote >= 0) {
                    break;
                }

                System.out.println("Enter a number greater or equal than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        while(true) {
            System.out.print("Enter maximum note: ");
            String value = input.nextLine();
            try {
                maxNote = Integer.parseInt(value);

                if(maxNote > minNote) {
                    break;
                }

                System.out.println("Enter a number greater than minimum note.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        double[][] notes = new double[quantityStudents][quantityCourses];

        for(int i = 0; i < quantityStudents; i++) {
            System.out.print("Enter notes for student "+ (i+1)  + "\n");
            for(int j = 0; j < quantityCourses; j++) {
                double note;
                while(true) {
                    System.out.print("Course "+ (j + 1)  + ": ");
                    String value = input.nextLine();
                    try{
                        note = Double.parseDouble(value);
                        if(note >= minNote && note <= maxNote){
                            break;
                        }
                        System.out.printf("Invalid note. Enter a value between %d and %d.%n", minNote, maxNote);
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

        String line = "+------------+" + "----------+".repeat(quantityCourses + 1);
        String header = "| %-10s |" + " %8s |".repeat(quantityCourses + 1) + "%n";

        Object[] headerContent = new Object[quantityCourses + 2];

        headerContent[0] = "Student";


        for(int i = 0; i < quantityCourses; i++) {
            headerContent[i + 1] = String.format("Course %d", i + 1);
        }

        headerContent[quantityCourses + 1] = "Average";
        System.out.println(line);
        System.out.printf(header, headerContent);
        System.out.println(line);
        for(int i = 0; i < quantityStudents; i++) {
            System.out.printf("| %-10s |", "Student " + (i + 1));
            double sumNotes = 0;
            for(int j = 0; j < quantityCourses; j++) {
                sumNotes += notes[i][j];
                System.out.printf(" %8.2f |", notes[i][j]);
            }
            double avgNotes = sumNotes /quantityCourses;
            studentsAvg.add(avgNotes);
            sumAverages += avgNotes;
            if(highestAVG < avgNotes) {
                highestAVG = avgNotes;
            }
            System.out.printf(" %8.2f |", avgNotes);
            System.out.println();
        }

        System.out.println(line);

        System.out.println("+------------RESULTS------------+");

        System.out.println("Students with highest average: ");
        for (int i = 0; i < studentsAvg.size(); i++) {
            double avg = studentsAvg.get(i);

            if (Double.compare(avg, highestAVG) == 0) {
                System.out.printf("Student: %d, Average: %.2f%n", (i + 1), avg);
            }
        }
        System.out.println("+-------------------------------+");
        System.out.printf("Average: %.2f%n", (sumAverages / quantityStudents));
        System.out.println("+-------------------------------+");
        System.out.printf("Highest Note: %.2f%n", highestNote);
        System.out.printf("Lowest Note: %.2f%n", lowestNote);
        System.out.println("+-------------------------------+");
        System.out.println("Highest Note: Student " + (studentH + 1) + ", Course, " + (courseH + 1));
        System.out.println("Lowest Note: Student " + (studentL + 1) + ", Course, " + (courseL + 1));

        System.out.println("+---------------END---------------+");
    }
}
