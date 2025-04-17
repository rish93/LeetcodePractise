package com.Practise;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TCS {

    public static void main(String[] args) {

    }
        ///student    ====>   /many subjetc  -> studen id
        // delte student with chem subj

        // delete s from Student s, Subject subj
        // where subj.name ='Chemistry' AND s.id not IN (select subject.studentId from subject);


        //excel for oclumn updation, how to fast

    String testMethod(String words){
        //deefrf sd sds sd

        String []wordArr=words.split(" ");
        //remove 1st occuring number

        Arrays.stream(wordArr).map(word-> word.toCharArray()).forEach(
                chars -> {
                    String tempOut=null;
                    int count=0;
                    for(char c:chars){
                        if(Pattern.matches("0-9",Character.toString(c))){
                            continue;

                        }
                        tempOut+=String.valueOf(c);
                    }

                }














                //api gateway
                // functional intrface inbuilt
                ///how to create service discovery
                //get and load from hibernate
                //Student is singleton bean, subj is prototype bean, getting student twice then
                //getting subj will get new subj
                //exception how it handled
                //override method change its acces modifier "Yes, an overridden method can have a different access modifier but it cannot lower the access scope"
                //how many ways you can handle service failure (multiple service interacting)
        );

      //  for(int i=0;i<wordArr)


        return "";
    }
}
