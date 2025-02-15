package com.Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JPMorgan {

    public static void main(String[] args) {


        List<List> testList= new ArrayList<>();
        testList.stream().flatMap(str->str.stream()).collect(Collectors.toList());


        String s="Rishabh";

        String s1= new String("Rishabh");
        System.out.println(s==s1);


        user
                -> name
                -> id
                -> addres
                -> cibilscore
        card
                -> id
                -> type
                -> (fk) user_id
                -> expiry date


            //milio of record which datastructure will use linked list or array list
                //suupse in custom stack you need min everytime popping or pushing  //maintainer min variable o0r min list

        //how you weill handle when microservice intewract shopping-> cart-> payment and payment fails
        //-> retry and revert.... use hsyterix  or use transaction id and savereuse when avaiable


        ///three microservice, running in different isntance you dont want that particular part of database to be created
        //--> use SAGA patterns orchestration where centralized it is maintained that instance if created dont crewate



        //immuatable class
        //million of records coming drom query how to optimize  --use clause more often ... -


        //how to optimize query whioch is slow  ///remove unwanted column.... use indexing.........table can eb more normalized

        //ddynamic lenghtg of list


//concurrent hashmaop with parallel stream  ///will it work
    }
}
