package com.designpatterns;


/*
->TODO Structural design pattern
It improves the strucutre of java code
-> Used when we want to control access.
eg in Database when we want to delete query available only for
certain users like admin
 */

import java.util.Hashtable;

/*
* Proxy Mean filtering.
* Where we require access control we put proxy. eg delete for admins
*
* */
//scenario
/*1)We have executor  method from interface
and a class that executes all comand
2) To control this we add a proxy class which implements the same
interface & write the conditiion for admin user before
proceeding to actual executor.

*/
public class ProxyDesignPattern {

    public static void main(String[] args) throws Exception {
        Hashtable<String, String> hs= new Hashtable<>();
        hs.put("", "");
        System.out.println(hs);
        DatabaseExecutor adminExecute = new DatabaseExecutorProxy("admin","123");
        adminExecute.executeDatabase("DELETE");

        DatabaseExecutor nonAdminExecute = new DatabaseExecutorProxy("aacw","12");
        nonAdminExecute.executeDatabase("DELETE");
    }

}


class DatabaseExecutorImpl implements DatabaseExecutor{

    @Override
    public void executeDatabase(String query) throws Exception {
            System.out.println("Executing query "+query);
    }
}

class DatabaseExecutorProxy implements DatabaseExecutor {
    boolean ifAdmin;
    DatabaseExecutorImpl dbExecutor;

    public DatabaseExecutorProxy(String name, String password){
        if(name.equals("admin") && password.equals("123")){
            ifAdmin = true;
            dbExecutor = new DatabaseExecutorImpl();
        }
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if( ifAdmin)
            dbExecutor.executeDatabase(query);
        else {
            if (query.equals("DELETE")){
                throw new Exception("Delete Not allowed for non admin user");
            }else
                dbExecutor.executeDatabase(query);
        }
    }
}

interface DatabaseExecutor{
     void executeDatabase(String query) throws Exception;
}
