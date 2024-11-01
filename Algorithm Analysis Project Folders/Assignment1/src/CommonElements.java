// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 1
// IDE:        IntelliJ
/********** Algorithm Design Block **********/

/*
Step 1: Create two arrays of type integer and let the user enter how large each array should be.
Step 2: After the size is determined, the user should be able to enter each number individually.
Step 3: Once both lists are complete, both of the arrays should be sorted to run our comparisons.
Step 4: Create two integer variables to represent the indexes being compared to from both of our arrays.
Step 5: Use a while loop to check how many comparisons are done and what needs to be added to an ArrayList
    while (i is less than length of first array and j is less than length of the second array)
     - if index i of the first array equals index j of the second, the element there is added to the ArrayList, and then both i and j increase by one
     - else if index i of the first array is greater than index j of the second, then j increases by one
     - otherwise i increases by one.

Input: two integer arrays that are already sorted
OutPut: The Common values that occupy both arrays after they are already checked as well as the comparisons necessary to create the list of common elements.
Pseudocode Implementation
  let i <- 0, j <- 0
  let n1 <- List 1's length, n2 <- List 2's length
  while i < n1 and j< n2
  If List1[i] == List2[j] Then
  CommonValue[i]=List1[i]
    i<- i+1
    j<- j+1
    end Then
    else if List1[i] > List2[j} THEN
    j<-j+1
    End Then
    else
    i<-i+1


 */

/************** Implementation Section *******/


import java.util.*;
public class CommonElements
{
    // The BubbleSort code will be here so that our comparisons can be made onto the arrays passed here.
    // The necessary common elements that are contained in both arrays must be sorted first in order to determine if anything were to be added to an arrayList.
    public static void BubbleSort(int[] NumList){
        for(int i=0; i<NumList.length-1; i++){
            for(int j=0; j<NumList.length-i-1; j++){
                if(NumList[j] >NumList[j+1]){
                    int temp=NumList[j];
                    NumList[j]=NumList[j+1];
                    NumList[j+1]=temp;
                }
            }
        }
    }
    // Method used to save some code space and print out the contents of the arrays.
    public static void printList(int[] NumList){
        for(int i=0; i<NumList.length; i++){
            System.out.print(NumList[i] + " ");
        }

    }

    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int MenuChoice;
        int [] IntList1 = new int[0];
        int [] IntList2 = new int[0];

        // The do-While loop below will be the sentinel loop menu that ends the program once the MenuChoice of 3 is selected.
        do{
        // Sentinel loop with menu necessary to keep the program running.
            ArrayList<Integer>CommonValues= new ArrayList<>();
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read input lists (integer values)");
            System.out.println("2. Run algorithm and display output");
            System.out.println("3. Exit program");
            System.out.println();

            System.out.print("Enter option number: ");
            MenuChoice=input.nextInt();
            switch (MenuChoice){
                // Case 1 will be asking for the size of each integer array and then ask the user to enter in numbers to run the commonElements necessary for comparison.
                case 1:
                    System.out.print("What size do you want the first list to be? ");
                    int size1=input.nextInt();
                    IntList1= new int[size1];
                    // For loop to enter in user generated values into IntList1
                    for(int i=0; i<size1; i++) {
                        System.out.print("Enter the value at index " + i + " ");
                        IntList1[i] = input.nextInt();
                    }
                    System.out.print("What size do you want the second list to be? ");
                    int size2=input.nextInt();
                    IntList2= new int[size2];
                    // For loop to enter in user generated values into IntList2
                    for(int i=0; i<size2; i++){
                        System.out.print("Enter the value at index "+ i + " ");
                        IntList2[i]=input.nextInt();
                    }
                    System.out.println();
                    break;
                    // Case 2 will sort the lists passed onto the method followed by using the algorithm specified to keep track of how many common elements are discovered.
                case 2:
                    int NumOfComparisons=0;
                    // Methods utilized to sort an array to figure out the common elements both from sets
                    BubbleSort(IntList1);
                    BubbleSort(IntList2);
                    System.out.print("List 1: ");
                    System.out.print("\t\t");
                    printList(IntList1);
                    System.out.println();
                    System.out.print("List 2: ");
                    System.out.print("\t\t");
                    printList(IntList2);
                    System.out.println();

                    // Using a series of comparisons on each element and if a match is found, then add the current element to the ArrayList and move onto the next element of both arrays.
                    // Making sure that only pairs of integers work, we advance through the arrays making the necessary comparisons to find our common elements.
                    int i=0,j=0;
                    // The while loop will stop when trying to access an index out of the array's bounds occur.
                    // Once the end of the list is compared to and checked, then we can stop looping.
                    while(i<IntList1.length && j< IntList2.length){
                        // keeping track of our number of comparisons.
                        NumOfComparisons++;
                        // If statement here will find if values at these indexes are similar, and if so, we move onto the next index of our arrays.
                        // Any common elements that are found from both arrays will be added to an arrayList, since there is a chance that both arrays do not have any elements in common.
                        if(IntList1[i]==IntList2[j]){
                            CommonValues.add(IntList1[i]);
                            i++;
                            j++;
                        }
                        // If an element from the first array is larger than the second, then advancing the index in the other array should help to get closer to find the common elements.
                        else if(IntList1[i] >IntList2[j]){
                            j++;
                        }
                        // first array value at that index is smaller than
                        else {
                            i++;
                        }
                    }

                    System.out.print("Common values: ");
                    if(CommonValues.isEmpty()){
                        System.out.println("\tNo common values");
                        System.out.println("Comparison:\t " + NumOfComparisons);

                    }else{
                        System.out.print("\t");
                        for(int k=0; k<CommonValues.size(); k++){
                            System.out.print(CommonValues.get(k) + " ");
                        }
                        System.out.println("\nComparisons:\t" + NumOfComparisons);
                    }
                    System.out.println();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Menu Choice, please try again.");
                    System.out.println();
            }
        }while (MenuChoice!=3);

    }

}
