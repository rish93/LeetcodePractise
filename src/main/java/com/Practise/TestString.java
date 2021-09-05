package com.Practise;

import java.util.List;

public class TestString {

    public static void main(String[] args) {

        String string1=new String("Abhi");
        String string2=new String("Abhi");


        StringBuffer s1=new StringBuffer("Abhi");
        StringBuffer s2=new StringBuffer("Abhi");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
     //object class equals check reference
        //string buffer calls object class equals whih check reference hence ans is false
    /*   public boolean equals(Object obj) {
         return (this == obj);
    }*/

        System.out.println(string1.equals(string2));
        //string equals call it's equals method
        /*
        *    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String aString = (String)anObject;
            if (!COMPACT_STRINGS || this.coder == aString.coder) {
                return StringLatin1.equals(value, aString.value);
            }
        }
        return false;
    }
        * */

    }
}
