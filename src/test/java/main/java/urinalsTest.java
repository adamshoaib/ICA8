package main.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @Test
    void isValidInputTrueAssertions() {
        System.out.println("====== Adam Shoaib K == TEST ONE EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertEquals( true , ur.isValidString("1010"));
        Assertions.assertEquals( true , ur.isValidString("0"));
        Assertions.assertEquals( true , ur.isValidString("1"));
        Assertions.assertEquals( true , ur.isValidString("00"));
        Assertions.assertEquals( true , ur.isValidString("0101"));
        Assertions.assertEquals( true , ur.isValidString("000000000"));
    }

    @Test
    void isValidInputFalseAssertions() {
        System.out.println("====== Adam Shoaib K == TEST TWO EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertEquals( false , ur.isValidString("101120"));
        Assertions.assertEquals( false , ur.isValidString("1011A0"));
        Assertions.assertEquals( false , ur.isValidString("/"));
        Assertions.assertEquals( false , ur.isValidString("A"));
        Assertions.assertEquals( false , ur.isValidString("a"));
        Assertions.assertEquals( false , ur.isValidString("9"));
        Assertions.assertEquals( false , ur.isValidString(""));
        Assertions.assertEquals( false , ur.isValidString(" "));
        Assertions.assertEquals( false , ur.isValidString("-1"));
        Assertions.assertEquals( false , ur.isValidString("-0"));
        Assertions.assertEquals( false , ur.isValidString("o")); // should not consider letter "o"
        Assertions.assertEquals( false , ur.isValidString("O")); // should not consider letter "O"
        Assertions.assertEquals( false , ur.isValidString("I"));
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
        Assertions.assertEquals( true , ur.hasConsequentOnes("011"));
        Assertions.assertEquals( true , ur.hasConsequentOnes("111"));
        Assertions.assertEquals( false , ur.hasConsequentOnes("010"));
        Assertions.assertEquals( false , ur.hasConsequentOnes("000"));
        Assertions.assertEquals( false , ur.hasConsequentOnes("1"));
        Assertions.assertEquals( false , ur.hasConsequentOnes("0"));

    }
}