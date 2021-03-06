package test.java;

import main.java.PO.Cat;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CatTest {
    Cat cat;

    @BeforeMethod
    public void setUp() {
        cat = new Cat();
    }

    @Test
    public void test1() {
        int actual = cat.min(1, 2);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        int actual = cat.min(-1, -2);
        int expected = -2;
        assertEquals(actual, expected);
    }

    @Test
    public void test3() {
        int actual = cat.min(0, 0);
        int expected = 0;
        assertEquals(actual, expected);
    }
}
