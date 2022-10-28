package main.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

class urinalsTest {

    @Test
    void isValidInputTrueAssertions() {
        System.out.println("====== Adam Shoaib K == TEST ONE EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertTrue( ur.isValidString("1010"));
        Assertions.assertTrue(  ur.isValidString("0"));
        Assertions.assertTrue(ur.isValidString("1"));
        Assertions.assertTrue(  ur.isValidString("00"));
        Assertions.assertTrue( ur.isValidString("0101"));
        Assertions.assertTrue( ur.isValidString("000000000"));
    }

    @Test
    void isValidInputFalseAssertions() {
        System.out.println("====== Adam Shoaib K == TEST TWO EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertFalse(  ur.isValidString("101120"));
        Assertions.assertFalse( ur.isValidString("1011A0"));
        Assertions.assertFalse(  ur.isValidString("/"));
        Assertions.assertFalse(  ur.isValidString("A"));
        Assertions.assertFalse( ur.isValidString("a"));
        Assertions.assertFalse(  ur.isValidString("9"));
        Assertions.assertFalse(  ur.isValidString(""));
        Assertions.assertFalse(  ur.isValidString(" "));
        Assertions.assertFalse(  ur.isValidString("-1"));
        Assertions.assertFalse(  ur.isValidString("-0"));
        Assertions.assertFalse( ur.isValidString("o")); // should not consider letter "o"
        Assertions.assertFalse(  ur.isValidString("O")); // should not consider letter "O"
        Assertions.assertFalse(  ur.isValidString("I"));
    }

    @Test
    void isValidInputNegativeNumber() {
        System.out.println("====== Adam Shoaib K == TEST THREE EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertEquals( false , ur.isValidString("-1"));
        Assertions.assertEquals( false , ur.isValidString("-0"));
        Assertions.assertEquals( false , ur.isValidString("-01001"));
    }

    @Test
    void isValidInputTwoConsequentOnes() {
        System.out.println("====== Adam Shoaib K == TEST FOUR EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertEquals( false , ur.isValidString("011"));
        Assertions.assertEquals( false , ur.isValidString("111"));
        Assertions.assertEquals( false , ur.isValidString("010110"));
    }

    @Test
    void hasConsequentOnes() {
        System.out.println("====== Adam Shoaib K == TEST FIVE EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertTrue(ur.hasConsequentOnes("011"));
        Assertions.assertTrue( ur.hasConsequentOnes("111"));
        Assertions.assertFalse(ur.hasConsequentOnes("010"));
        Assertions.assertFalse( ur.hasConsequentOnes("000"));
        Assertions.assertFalse(ur.hasConsequentOnes("1"));
        Assertions.assertFalse(ur.hasConsequentOnes("0"));
    }

    @Test
    void countUrinals() {
        System.out.println("====== Adam Shoaib K == TEST SIX EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertEquals( 0 , ur.countUrinals("10101"));
        Assertions.assertEquals( 1 , ur.countUrinals("10001"));
        Assertions.assertEquals( -1 , ur.countUrinals("011"));
        Assertions.assertEquals( 1 , ur.countUrinals("00"));
        Assertions.assertEquals( -1 , ur.countUrinals("11"));
        Assertions.assertEquals( 3 , ur.countUrinals("00000"));
        Assertions.assertEquals( 2 , ur.countUrinals("0000"));
        Assertions.assertEquals( 1 , ur.countUrinals("01000"));
        Assertions.assertEquals( 0 , ur.countUrinals("1"));
    }

    @Test
    void writeToAFile() throws IOException {
        System.out.println("====== Adam Shoaib K == TEST SEVEN EXECUTED =======");
        urinals ur = new urinals();
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        resultList.add(2);
        resultList.add(3);
        resultList.add(0);
        resultList.add(-1);
        ur.writeToAFile(resultList);
        int currentCount = 0;
        String filename = "rule" + ".txt";
        File fileToCreate = new File(filename);
        while (fileToCreate.exists()) {
            currentCount++;
        }
        BufferedReader br;
        String name = currentCount > 0 ? "currentCount" : "";
        br = new BufferedReader(new FileReader("/Users/adamshoaibk/IdeaProjects/ICA8/src/Output/rule" + name +".txt"));
        String line = br.readLine();
        ArrayList<String> input = new ArrayList<>(); // Create an ArrayList object
        while (line != null) {
            input.add(line);
            line = br.readLine();
        }
        ArrayList<Integer> strToInt = getStrToInt(input);
        boolean boolval = resultList.equals(strToInt);
        Assertions.assertTrue(boolval);
    }

    private ArrayList<Integer> getStrToInt(ArrayList<String> strArList) {
        ArrayList<Integer> res = new ArrayList<>();
        for(String str : strArList) {
            try {
                res.add(Integer.parseInt(str));
            } catch(NumberFormatException ignored) {}
        }
        return res;
    }

    @Test
    void readFromFile() {
        System.out.println("====== Adam Shoaib K == TEST EIGHT EXECUTED =======");
        urinals ur = new urinals();
        ArrayList<String> result = new ArrayList<>();
        result.add("10001");
        result.add("1001");
        result.add("00000");
        result.add("0000");
        result.add("01000");
        result.add("011");
        ArrayList<String> input = ur.readFromFile();
        boolean boolval = result.equals(input);
        Assertions.assertTrue(boolval);
    }

    }