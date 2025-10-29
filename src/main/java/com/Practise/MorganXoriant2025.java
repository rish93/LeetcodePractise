package com.Practise;

import java.util.Arrays;

public class MorganXoriant2025 {

    public static void main(String[] args) {
        String input ="/home////////";
        String input1 ="/home/user/Documents/../Pictures";
        String output1= simplifyPath(input);
       System.out.println("final-> "+output1);

        String output2= simplifyPath(input1);
        System.out.println("final output2-> "+output2);
    }



    private static String simplifyPath(String linuxPath){
        String finalStrrmeoveMultiDots="";
        if(linuxPath!=null) {
            //StringBuilder linuxPathStr=new StringBuilder(linuxPath);

            if(!linuxPath.startsWith("/")) {
                linuxPath="/"+ linuxPath;
                System.out.println("19 "+linuxPath);
            }

            String removeMultiSlashString = linuxPath.replace("///", "/")
                        .replace("//", "/");
            System.out.println("24 "+removeMultiSlashString);

              String removeLastSlash=  removeMultiSlashString
                      .endsWith("/")
                      ? removeMultiSlashString.substring(0,removeMultiSlashString.length()-1)
                      : removeMultiSlashString;//validate slash end

            System.out.println("27 "+removeLastSlash);
            String[] strArr= removeLastSlash.split("/");
            System.out.println("29 "+ Arrays.toString(strArr));

            for(int i=0;i<strArr.length;i++){
                finalStrrmeoveMultiDots +="/"+strArr[i];
                if(strArr[i].contains("..")){
                    finalStrrmeoveMultiDots=  removeLastSlash.substring(0, i-1) +  removeLastSlash.substring(i+1, strArr.length-1);
                }
            }
        }

        return finalStrrmeoveMultiDots;
    }
}
