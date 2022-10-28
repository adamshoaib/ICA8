
// Author : Adam Shoaib K
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class urinals {
    Boolean isValidString() {
        // todo;
        return true;
    }
    public static void main(String args[])  //static method
    {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Input from ? 1 = Keyboard, 2 = file");
        String choice = Scanner.nextLine();
        switch(choice) {
            case "1" :
                System.out.println("Enter Input in 0's and 1's");
                String userInput = Scanner.nextLine();
                System.out.println("You inputted :" + userInput);
                break;
                // call the function here
            case "2" :
                BufferedReader br;
                try {
                    br = new BufferedReader(new FileReader("/Users/adamshoaibk/IdeaProjects/ICA8/src/Helper/urinal.dat"));
                    String line = br.readLine();
                    while (line != null) {
                        System.out.println(line);
                        line = br.readLine();
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default :
                System.out.println("Invalid Input !, Please try again Later");
                System.exit(1);
                break;
        }

    }
}
