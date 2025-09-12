package com.Practise.MongoDB;

public class Mongo28072025 {
    public static void main(String[] args) {


        ///compamyname . city, id can you put indexes on all
        // cardinality -no but base don requirmenent-

        ///compamyname . city, id can you put indexes on all
        //can you put indexing on all column NOO


        //challenign thing in Spring Boot


        //---------------------

        ///company table
        //Company_name    City  *** get all duplicate rows, companyNam&city
        /*
        * select company_name, city where company_name IN (select company name HAVING COUNT(company_name)>1)
        * AND
        * city IN (select city name HAVING COUNT(city)>1);
        *
        * //count company in city
        *
        * select count(company_name) as companyName from company where city ='London' and company_name='MongoDB';
        *
        * select count(company_name) as companyName, city as City from company where company_name='MongoDB' GroupBy city ;
        *
        *
        * select company_name as companyName, city as City, count(company_name) companyCount
        * from company GROUPBY company_name, city ;
        *
        *
        * select company_name as companyName, city as City, count(company_name) companyCount
        * from company HAVING count(company_name)>1 GROUPBY company_name, city ;
        **/



        /*Company Table
        * Company,<id, name> People <id, name>
        * Company <many to many> person
        *
        *
        * company | 1 | Mongo  |1 fk(people)
    *             | 2 | Mongo  |2 fk(people)*   =>  company | 1 | Mongo
                                                     *       |3  | Boeing
        *
        * people |1| Rishabh |1 fk  (company)
    *            |2| Prateek |2 fk  *
    *
    *
    *    company_name
    *    company_id | people
    *
    **/

       // Explain comparing of boolean values.
//        new Boolean(false).equals(Boolean.FALSE) -> true
//        new Boolean(false) == Boolean.FALSE -> false
//        new Boolean(false) == false -> true

          Boolean abc= new Boolean(false);
          System.out.println(abc ==false);

       // new CustomBoolean(false) == false -> false //wont compile


        /*oncept of key and group in kafka, make sure message is received in same partition everytime. what if that particular partition goes down*/
    }
}
