package com.Practise;


/*
 Q1. A company 'Vivacious System' is attacked by virus, the system has N running application,
 each having a unique Id 0 to N-1 . John a Software Engineer . is given responsibilty to tackle this situation.
 He has made an antivirus to detect the virus application in the system. JOhn's antivirus
 works on an algorithm. The algorithm find group value of applicationby dividing the sum of Ids of all application
 by two. The id of application which is nearest to the group value is then marked as scanned
 and is removed from the list. The process then continue with the remaining application
 until only one application is left. That remaining application is detected as virus . The antivirus will then remove the
 file with the virus.

 > Write algo for JOhn to find the ID of file with a virus in the system.

 > I/p first line of input consist of an integer num, representing the number of running appplication
 on system (N).
 the next line consist of N, space seperated Integers appId[0], appId[1].....appId[N-1]..
 representing Id  of N application
 O/p => print the integer representing Id of the file with a virus in the system..

 >If more than one appplication ID exists, that are nearest to the group value, then smallest ID will represent the scanned file.
 * consider floor value for the group value e. 10.9 => 10

 eg I/p 4
        1 ,3 ,5, 7
    O/p 5

 Explaination Step1: group value of N application =8, so mark application with ID 7 as scanned
              Step2: Recalculate group Id value of N-1 application.
                Group value =4 (floor value),so exclude 3 as 3<5.
              Step3: recalculate the group value of N-2 application. Group value =3. So exclude 1 as 1<5
              Therefor Ouput 5..

 */
public class OpenText {

    public static void main(String[] args) {

    }
}
