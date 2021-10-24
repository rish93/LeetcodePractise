package com.Practise;

public class Sinarmas {

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 1, 0, 0};

        //Arrays.sort(arr);
        int countZero = 0; //0(2)
        int countOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZero += 1;
            }
            if (arr[i] == 1) {
                countOne += 1;
            }
        }
        for(int j =0;j<countZero;j++)
        {
            arr[j]=0;
        }
        for(int j =0;j<countOne;j++)
        {
            arr[countZero]=1;
            countZero++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    //input : this_is_logical_question
    //output: thisIsLogicalQuestion
    /*Employee e1= new Employee(1,"Priyanka",20000);
    Employee e2= new Employee(2,"Abhi",30000);
    Map<Employee,String> employeeMap = new HashMap<>();
employeeMap.put(e1,"Priyanka ");
employeeMap.put(e2,"Abhi ");
e1.setName("Rose");
System.out.println(employeeMap.get(e1));
*/

    //employeeList.stream().filter(e-> e.getSalary()>20,000 && e.getSalary()<10,000 ).sort(Compartor.comparing(Employee::name)).reversed().map(e->grouppingBy(Employee::Dept,))




}

