package com.Practise;

public class TestCustomException {

  public static void main(String[] args) throws LeavePolicyException {
      LeaveManager manager = new LeaveManager();
      System.out.println(manager.apply(1));
      System.out.println(manager.apply(2));
      System.out.println(manager.apply(5));
  }
}


class LeavePolicyException extends Exception{
    public LeavePolicyException(String msg){
        super(msg);
    }
}

 class LeaveManager {
    public boolean apply(Integer days) throws LeavePolicyException {
        if (days<2) {
            return true;
        } else {
            throw new LeavePolicyException(
                    "cannot apply for more than two days");

        }
    }
}

