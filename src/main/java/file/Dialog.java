package file;

import java.util.Scanner;

/**
 * Duomenu ivedimas isvedimas
 */

public class Dialog {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Pranesimo isvedimas
     * @param message pranesimo tekstas
     */

    public void println(String message){
        System.out.println(message);
    }

    public void print(String message){
        System.out.print(message);
    }

    public String input(){
        return scanner.nextLine();
    }
    public String input(String message){
        print(message);
        return input();


    }
}
