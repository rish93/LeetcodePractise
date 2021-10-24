package com.Practise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CiscoInterview {

    //what is sql injection how to remove it
    //how to handle epagenation in api
    //volatile
    //multpiple inheritence problem and how to solvae in java
    //how to check and prevent memory leak
    //ways to pass value to jpa repository



  //  Ans
    /*How to Prevent an SQL Injection
The only sure way to prevent SQL Injection attacks is input validation and parametrized queries including prepared statements. The application code should never use the input directly. The developer must sanitize all input, not only web form inputs such as login forms. They must remove potential malicious code elements such as single quotes. It is also a good idea to turn off the visibility of database errors on your production sites. Database errors can be used with SQL Injection to gain information about your database.

If you discover an SQL Injection vulnerability, for example using an Acunetix scan, you may be unable to fix it immediately. For example, the vulnerability may be in open source code. In such cases, you can use a web application firewall to sanitize your input temporarily.*/

    public static void main(String[] args) {
        /*How you will configure Swagger*/
        /*How you will configure S3 bucket*/

        for(int i=1;i<=50;i++){
            if(i%15==0)
                System.out.println("Rishabh Mankatala");
            else if(i%5==0)
                System.out.println(" Mankatala");
            else if(i%3 ==0 )
                System.out.println("Rishabh");
            else
                System.out.println(i);
        }

        String name="Rishabh";
//            String []arr = name.split("");
//

        String reverse="";
        for(int i=name.length()-1;i>=0;i--){
//                reverse+=arr[i];
            reverse+= name.substring(i,i);
        }
        System.out.println(reverse);

        String [] languages = new String[]{"Java","Nodejs","Python"};
        Arrays.stream(languages).forEach(System.out::println);
//        String [] languages = new String[]{""};

        Set<String> setTest= new HashSet<String>();
        setTest.add("Rishabh");
        setTest.add("Mankatala");
        setTest.add("Rishabh");

        Optional<String> opttets= Optional.of("Rishabh");
        if(opttets.isPresent())
            opttets.get();

/*emp
name, year,exp,Doj
*/
//select count(*), emp.year from EmployeeW emp groupby year
//        select emp.name emp.year from EmployeeW emp  where DOJ <  STR_TO_DATE("August 10 2017", "%M %d %Y");

//HOw you will optimize sql query
        ///how to trace logs

    }
}
