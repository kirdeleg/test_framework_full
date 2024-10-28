package tests;

import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test
    public void test() {
        System.out.println("Hello world!");
        System.out.println("Env is: " + System.getProperty("env"));
    }
}
