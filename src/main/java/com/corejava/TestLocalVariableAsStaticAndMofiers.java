package com.corejava;

public class TestLocalVariableAsStaticAndMofiers {

    public static void main(String[] args) {
        TestLocalLocalVaribales testLocalLocalVaribales = new TestLocalLocalVaribales();
        testLocalLocalVaribales.iAmTestMethod();
    }
}

class TestLocalLocalVaribales{
    private int i;

    public void iAmTestMethod(){
        /*TODO
         * public private protected modifier cannot be used on variable inside method
         * coz we can only have localvariable inside method*/
         //  private int j=0; //compilation error: Modifier 'private' not allowed here

        /*TODO  declaring variable as final inside method is fine , but static inside
        *  method mean you are trying to declare
        *  local variable as class level memebr which is conflict.
        */
       // static int k=0; //Modifier 'static' not allowed here

    }
}
