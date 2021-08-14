package com.Practise;


import java.util.HashMap;
import java.util.Map;

/*Immutable class means that once an object is
 created, we cannot change its content. In
 Java, all the wrapper classes (like Integer,
 Boolean, Byte, Short)
 and String class is immutable*/
public class TestImmutableClass {

  public static void main(String[] args) {
    //
    Map<String, String> map = new HashMap<>();
    map.put("1", "first");
    map.put("2", "second");
    BankAccount s = new BankAccount("ABC", 101,2323, map);
    System.out.println(s.getAccountName());
    System.out.println(s.getAccountNumber());
    System.out.println(s.getPanCardNumber());
    System.out.println(s.getDocumentSubmitted());

    // Uncommenting below line causes error
    // s.regNo = 102;

    map.put("3", "third");
    System.out.println(s.getDocumentSubmitted()); // Remains unchanged due to deep copy in constructor

    s.getDocumentSubmitted().put("4", "fourth");
    System.out.println(s.getDocumentSubmitted()); // R
  }
}

//final so no one can make sub class
  final class BankAccount{

      //data members as private for no direct access
      private final String accountName;
      private final Integer accountNumber;
      private final Integer panCardNumber;
      private final Map<String, String> documentSubmitted;

      BankAccount(String accountName,
                  Integer accountNumber,
                  Integer panCardNumber,
                  Map<String,String> documentSubmitted) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.panCardNumber = panCardNumber;
//        this.documentSubmitted = documentSubmitted; Immutability is lost if we directly initialize
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                documentSubmitted.entrySet()) {
          tempMap.put(entry.getKey(), entry.getValue());
        }
        this.documentSubmitted = tempMap;
      }


      //no setter
  public String getAccountName() {
    return accountName;
  }

  public Integer getAccountNumber() {
    return accountNumber;
  }

  public Integer getPanCardNumber() {
    return panCardNumber;
  }

    public Map<String, String> getDocumentSubmitted() {

      Map<String, String> tempMap = new HashMap<>();
      for (Map.Entry<String, String> entry :
              this.documentSubmitted.entrySet()) {
        tempMap.put(entry.getKey(), entry.getValue());
      }
      return tempMap;
    }
}

//   class subclass extends ImmutableClass{
//  //Cannot inherit from final 'com.Practise.ImmutableClass'
//   }
