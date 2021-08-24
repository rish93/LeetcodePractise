package com.Practise;

public class ExceptionFlowTest {
    public static void main(String[] args) throws Exception {
        testException();
    }

    private static void testException() throws Exception {
        try {
            if (null == null)
                System.out.println(6);
        } catch (Exception e) {
            try {

            } finally {
                throw new Exception("Bolo");
            }
        }
    }
}

