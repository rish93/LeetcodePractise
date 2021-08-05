package com.Practise;


import java.lang.instrument.UnmodifiableClassException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class AccentureQuestionPractice {
    Logger logger = Logger.getLogger(AccentureQuestionPractice.class.getName());
  public static void main(String[] args) {

      makeListAsReadOnly();
  }

  private static void makeListAsReadOnly(){
      List<Integer> testList= new ArrayList(){{ add(1);add(3); add(34);} };;
      Collections.unmodifiableList(testList);

      try{
          testList.add(2);
      }catch (UnsupportedOperationException e){
            e.printStackTrace();
      }

  }

}
