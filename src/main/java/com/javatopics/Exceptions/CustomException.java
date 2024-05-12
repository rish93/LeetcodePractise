package com.javatopics.Exceptions;

public class CustomException {

    public static void main(String[] args) {
        //exception either catch it or throws it
        try {
            evaluateWord("Rishabh");
            evaluateWord("");
        }catch (WordContainsException e){
            e.printStackTrace();

        }
    }

    static void evaluateWord(String word) throws WordContainsException {
        if(word.isEmpty())
            throw new WordContainsException();
    }

}



class WordContainsException extends Exception
{
    // Parameterless Constructor
    public WordContainsException() {}

    // Constructor that accepts a message
    public WordContainsException(String message)
    {
        super(message);
    }



    //when to use Exception or runtimeException

    /*
    Extending Exception: Checked Exceptions:
      If the exceptional condition is recoverable or expected to be handled by the caller,
      consider extending Exception.

Scenario example:
    Custom exceptions in business logic that require explicit handling, such as PaymentException, InvalidDataException, etc.
    Exceptions represent expected error conditions that callers can recover from or handle gracefully.



    Extending RuntimeException:

        If the exceptional condition is unexpected or typically indicates a programming error,
        extend RuntimeException.
        Unchecked exceptions do not require explicit handling through try-catch blocks or
        declaring them in method signatures using throws.

Scenario example
NullPointerException, IllegalArgumentException, IllegalStateException, etc., which indicate programming errors or invalid usage of APIs.

Internal exceptions within a framework or library that are not intended to be handled by application code directly.

Exceptions indicating unrecoverable errors or violations of assumptions, where immediate termination of the application might be appropriate.

    */
}