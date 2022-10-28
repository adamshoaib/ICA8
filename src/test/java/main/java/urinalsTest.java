package main.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @Test
    void isValidInput() {
        System.out.println("====== Adam Shoaib K == TEST ONE EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertEquals( true , ur.isValidString("10110"));
    }

    @Test
    void isValidInputDifferentNumbers() {
        System.out.println("====== Adam Shoaib K == TEST 2 EXECUTED =======");
        urinals ur = new urinals();
        Assertions.assertEquals( false , ur.isValidString("101120"));
    }
}