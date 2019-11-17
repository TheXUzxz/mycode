package com.cy.gc;

public class TestStackOverFlow {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }

}
