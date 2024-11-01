// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 4

import java.util.*;

public class TestIS {
    // Using a static Random Object in their respective methods.
    static Random myRand = new Random();
    // Helper method that guarantees the integer values in the array are distinct from each other. Will be used for the RandomDistinct method.
    public static boolean PreventDuplicates(int[] Arr, int DistinctVal){
        for (int j : Arr) {
            if (j == DistinctVal) {
                return false;
            }
        }
        return true;
    }
    public static void printValues(int[] myValues){
        int count=0;
        for (int myValue : myValues) {
            if (count % 30 == 0) {
                System.out.println();
            }

            System.out.print(myValue + "\t");
            if(myValue<1000){
                System.out.print("\t");
            }
            count++;

        }
        System.out.println();

    }
    public static int[] RandomDistinct(){
        int[] Values = new int[1024];
        for(int i=0; i< Values.length; i++){
            int x = myRand.nextInt(1,10000);
            // Using a while loop so that a randomly generated value does not already occupy the integer array.
            while(!PreventDuplicates(Values, x)){
                x = myRand.nextInt(1,10000);
            }
            Values[i]=x;


        }
        // Use the built-in method to sort the array in Ascending order.
        Arrays.sort(Values);
        return Values;
    }
    public static void RunIS(int TableSize, int[] myArray){
        int computedAverage=0;
        System.out.println("Key\t\tFound\t\tIndex\t\tDivisions");
        System.out.println("-------------------------------------------");
        for(int i=0; i<TableSize; i++){
            int Key = myRand.nextInt(1,10000);
            // Creating the object inside the for loop so that the getter methods can be used later.
           InterpolationSearch I1 = new InterpolationSearch(myArray, Key);
            String A;
            if(I1.isFound()){
                A="True";
            }
            else {
                A="False";
            }
            if(Key <1000){
                System.out.println(Key + "\t\t"+A+"\t\t"+ I1.getTargetIndex()+"\t\t\t\t"+I1.getNumOfDivision());
            }
            else {
                System.out.println(Key + "\t" + A + "\t\t" + I1.getTargetIndex() + "\t\t\t\t" + I1.getNumOfDivision());
            }
            computedAverage+=I1.getNumOfDivision();
        }
        // Compute the sum of all the divisions divided by the total number of iterations conducted on the search for the key values.
        // Do not know if the difference and the computed average should give a negative number.
        double Result =(double) computedAverage/TableSize;
        System.out.println(". . .");
        double Difference = 3.322 - Result;
        System.out.println("Divisions average:\t\t"+ Result);
        System.out.println("Difference:\t\t\t"+Difference);
    }
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int MenuChoice;
    int TableSize=0;
    int[] myArray = new int[0];
    do{
        System.out.println("-----------------MAIN MENU--------------");
        System.out.println("1. Create and display array Values[]");
        System.out.println("2. Read output table size");
        System.out.println("3. Run algorithm comparison and display output");
        System.out.println("4. Exit program");
        System.out.println();
        System.out.print("Enter option number: ");
        MenuChoice=input.nextInt();

        switch (MenuChoice){
            case 1:
                myArray=RandomDistinct();
                printValues(myArray);
                break;
            case 2:
                System.out.print("What size of the table do you want to input: ");
                TableSize= input.nextInt();
                break;
            case 3:
                RunIS(TableSize, myArray);
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
        System.out.println();
    }while (MenuChoice!=4);


    }
}