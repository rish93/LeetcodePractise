package com.designpatterns;


//Structural Design pattern used for improving structure of
//code

/*
   Used When there are multiple interface of similar kind of jobs, then
*  we add a facade interface,which provide better interface to these
*  interface & clients.
*  It basically help in routing to related interface
   i.e Drivers, Databases
* */

import java.sql.Driver;

/*
* We'll implement Facade helper class which will route
* to method related to specific class based on i/p
* */
public class FacadeDesignPattern {

  public static void main(String[] args) {
//helper helps in routing related classes
      WebExplorerHelperFacade.generateReports("firefox","html","test");
      WebExplorerHelperFacade.generateReports("chrome","junit","test");

  }
}

class FireFox{
    public static Driver getFireFoxDriver(){
        return null;
    }

    public static void generateHtmlReport(String test, Driver driver){
        System.out.println("Generating html report for firefox driver");
    }

    public static void generateJunitReport(String test, Driver driver){
        System.out.println("Generating JUNIT report for firefox driver");
    }
}


class Chrome{
    public static Driver getChromeDriver(){
        return null;
    }

    public static void generateHtmlReport(String test, Driver driver){
        System.out.println("Generating html report for Chrome driver");
    }

    public static void generateJunitReport(String test, Driver driver){
        System.out.println("Generating JUNIT report for Chrome driver");
    }
}


class WebExplorerHelperFacade {
    public static void generateReports(String browser,String report,String test){
            Driver driver = null;
            switch (browser){
                case "firefox":
                    driver = FireFox.getFireFoxDriver();
                    switch (report){
                        case "html":
                            FireFox.generateHtmlReport(test,driver);
                            break;
                        case "junit":
                            FireFox.generateJunitReport(test, driver);
                            break;
                    }
                    break;
                case "chrome":
                    driver = Chrome.getChromeDriver();
                    switch (report){
                        case "html":
                            Chrome.generateHtmlReport(test, driver);
                            break;
                        case "junit":
                            Chrome.generateHtmlReport(test, driver);
                            break;
                    }
                    break;
            }
    }
}
