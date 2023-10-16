package com.designpatterns;


// entity that adapt to another system without modification

//it allows existing classes to be used with
// others without modifying their source code

//i.e WebDriver Adapter

/*
* Suppose we have ChromeDriver Interface with 2 mthod defn
* getLElement();
* selectElement(); for all driver chromedriver edge driver etc.
*
*
* now InternetExploer driver interface supports
* 1)findElement()
* 2) clickElement()
* */

/*
* So to support IE driver we can put WebdriverAdapter interface
* with  getElement()
*       selectElement()
*internaly it will call methof of Idriver
* i.e. findElement() & clickElement();
* */

/*
* Client --->           WebDriver (interface)         ChomeDriver
*                              getElement()
*                              selectElement()
*                     /
*                  /
*               /
* WebDriverAdapter    ------> IE driver (Adaptee)
*   -getElement()               ->findElement()
*   -selectElement()            -> clickElement
*
*
* */


public class AdapterDesignPattern {

    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectEement();

        IEDriver ieDriver = new IEDriver();
//        ieDriver.clickEement();
//        ieDriver.findElement();

        WebDriver webDriver = new WebDriverAdapter(ieDriver);
        webDriver.getElement();
        webDriver.selectEement();
    }

}

interface WebDriver {
    public void getElement();
    public void selectEement();
}

class ChromeDriver implements WebDriver{
    @Override
    public void getElement() {
        System.out.println("Get element from chromedriver");
    }

    @Override
    public void selectEement() {
        System.out.println("Select element from chromedriver");
    }
}
class IEDriver{
    public void findElement() {
        System.out.println("Find element from IE driver");
    }

    public void clickEement() {
        System.out.println("Click element from IE driver");
    }
}

class WebDriverAdapter implements WebDriver{

    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver){
        this.ieDriver = ieDriver;
    }
//internally call changed interface methods (function of adaptee)
    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectEement() {
        ieDriver.clickEement();
    }
}


