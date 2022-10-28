package main.java;
// Author : Adam Shoaib K
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class urinals {
    Boolean isValidString(String input) { // checks if the user input is valid
            // check if the given input consists of 1's and 0's
            if (input.matches("^[01]+$")) {
                return !hasConsequentOnes(input);
            } else {
                return false;
            }
    }

    boolean hasConsequentOnes(String input) {
        for (int i=0;i<input.length()-1;i++)
            if (input.charAt(i) == '1' && input.charAt(i+1) == '1')
                return true;
        return false;
    }

    int countUrinals(String input) { // if the user input is valid this fn returns the no of avail urinals
        if(isValidString(input)) {
            int count = 0;
            int i = 0;
            int len = input.length();
            char[] arr = input.toCharArray();
            if (len == 1) {
                return arr[i] == '0' ? 1 : 0;
            }
            while (i < len) {
                if (arr[i] == '0') {
                    if (i == 0 && arr[i + 1] == '0') {
                        arr[i] = '1';
                        count++;
                    } else if (i == len - 1 && arr[i - 1] == '0') {
                        arr[i] = '1';
                        count++;
                    } else if ((i - 1) >= 0 && (i + 1) < len && arr[i - 1] == '0' && arr[i + 1] == '0') {
                        arr[i] = '1';
                        count++;
                    }
                }
                i += 1;
            }
            return count;
        } else {
            return -1;
        }
    }

    void writeToAFile(ArrayList<Integer> outputList) {
        try {
            String file = "rule";
            String dirPath = "/Users/adamshoaibk/IdeaProjects/ICA8/src/Output/";
            int currentCount = 0;
            String filename = dirPath + file + ".txt";
            File fileToCreate = new File(filename);
            while (fileToCreate.exists()) {
                currentCount++;
                filename = dirPath + file + currentCount + ".txt";
                fileToCreate = new File(filename);
            }
            fileToCreate.createNewFile();
            FileWriter fw = new FileWriter(fileToCreate);

            for (Integer integer : outputList) {
                fw.write(integer + "\n");
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println("OOPS! Exception occurred while writing to a file.");
        }
    }

    ArrayList<String> readFromFile() {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("/Users/adamshoaibk/IdeaProjects/ICA8/src/Helper/urinal.dat"));
            String line = br.readLine();
            ArrayList<String> input = new ArrayList<String>(); // Create an ArrayList object
            while (line != null) {
                if (line.equals("-1")) {
                    break;
                }
                input.add(line);
                line = br.readLine();
            }
            br.close();
            return input;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String args[])  //static method
    {
        Scanner Scanner = new Scanner(System.in);
        urinals ur = new urinals();
        System.out.println("Input from ? 1 = Keyboard, 2 = file");
        String choice = Scanner.nextLine();
        switch(choice) {
            case "1" :
                System.out.println("Enter Input in 0's and 1's");
                String userInput = Scanner.nextLine();
                System.out.println("You inputted :" + userInput);
                if(ur.isValidString(userInput)) {
                    int result = ur.countUrinals(userInput);
                    System.out.println("Number of free urinals :" + result);
                } else {
                    System.out.println("-1");
                }
                break;
            case "2" :
                BufferedReader br;
                ArrayList<String> input = ur.readFromFile();
                ArrayList<Integer> resultList = new ArrayList<Integer>();
                for (int i = 0; i < input.size(); i++) {
                    // checking if the string is valid
                    if(ur.isValidString(input.get(i))) {
                        int result = ur.countUrinals(input.get(i));
                        // add result only if string is valid
                        resultList.add(result);
                    } else {
                        // else add -1 to the list and break out of the loop
                        resultList.add(-1);
                    }
                }
                ur.writeToAFile(resultList);
                break;
            default :
                System.out.println("Invalid Input ! Please try again Later");
                System.exit(1);
                break;
        }
    }
}
