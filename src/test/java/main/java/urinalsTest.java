package main.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    void countUrinals() {
        System.out.println("====== Adam Shoaib K == TEST SIX EXECUTED =======");
        urinals ur = new urinals();
        String ip = "10101";
        if(ur.isValidString(ip)) {
            Assertions.assertEquals( 0 , ur.countUrinals(ip));
        }

        String ip1 = "10001";
        if(ur.isValidString(ip1)) {
            Assertions.assertEquals( 1 , ur.countUrinals(ip1));
        }

        String ip2 = "011";
        if(ur.isValidString(ip2)) {
            Assertions.assertEquals( -1 , ur.countUrinals(ip2));
        }

        String ip3 = "00";
        if(ur.isValidString(ip3)) {
            Assertions.assertEquals( 1 , ur.countUrinals(ip3));
        }

        String ip4 = "11";
        if(ur.isValidString(ip4)) {
            Assertions.assertEquals( -1 , ur.countUrinals(ip4));
        }

        String ip5 = "00000";
        if(ur.isValidString(ip5)) {
            Assertions.assertEquals( 3 , ur.countUrinals(ip5));
        }

        String ip6 = "0000";
        if(ur.isValidString(ip6)) {
            Assertions.assertEquals( 2 , ur.countUrinals(ip6));
        }

        String ip7 = "01000";
        if(ur.isValidString(ip7)) {
            Assertions.assertEquals( 1 , ur.countUrinals(ip7));
        }
    }
}