
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args){
        String text = "En una pequeña ciudad vivía un estudiante llamado Carlos, quien estaba aprendiendo programación con Java. Cada mañana encendía su computadora, abría su editor de código y practicaba diferentes ejercicios.";
        System.out.print("Enter word to find: ");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        System.out.print("You entered: " + word + " \n");
        String[] words = text.split(" ");
        int count = 0;

        for (int i = 0; i < words.length; i++){
            if(word.toLowerCase(Locale.ROOT).equals(words[i].toLowerCase(Locale.ROOT))) {
                count++;
            }

        }
        System.out.print("Count word: " + word + " is: "+count);
    }
}
