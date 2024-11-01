import java.util.*;
// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 3


/********** Algorithm Design Block **********/

/*
    using an example data set:
    A[12 45 17 98 12 56 42 52 47 81 ]
    For the first Insertion sort method used, the number of occurrences is as follows:
    j <= 0:         14
    A[j] > v:       14
    A[j+1] = A[j]:  14
    j = j-1         14
The while loop conditions are evaluated whether the next for loop's iteration occurs, and will run its code if the specified condition is met.
The assignment operations inside the while loop as well as the conditions being checked for validity is counted inside the inner while loop, as to make sure all of these counts have the same value.
 For the Second Insertion sort method used, the number of occurrences is as follows:
    j <= 0:			14
	A[j] > A[j+1]:	14
	Swap:			42
	j = j-1:        14
Like the previous method, the while loop conditions are being considered and counted inside the while loop for our method, making sure that the loop to run that code is possible.
The swap method/operation will conduct three operations per count of the j = j-1 operation to make sure that the counts for each of these evaluations and assignments are consistent.
For every count of j's decrement, the swap operation occurs is 3 times the count of that decrement.

Both of these methods are almost structured exactly the same, but uses a slightly different condition for running the inner while loop and one utilizes a swap method to change the 1dArray cells values using the swap.
The swap is considered to occur 3 times as much as the other operations.
Overall, the first insertion sort method that does not use a swap method will utilize less operations than the other InsertionSort method that uses a swap operation.

*/
/* Algorithm pseudocode syntax
InsertionSort1 Algorithm: InsertionSort(A[])
  // Input: An array A[0..N-1] of n integers representing a list of values that are not sorted
  // Output: Array A[0..N-1] of n integers sorted in increasing order.
    for i ← 1 to n − 1 do
        v ← A[i]
        j ← i − 1
        while j ≥ 0 and A[j ] > v do
            A[j + 1]← A[j ]
            j ← j − 1
    A[j + 1] ← v
InsertionSort2 Algorithm: InsertionSort(A[]) using a swap operation
    // Input: An array A[0..N-1] of n integers representing a list of values that are not sorted
    // Output: Array A[0..N-1] of n integers sorted in increasing order.
     for i ← 1 to n − 1 do
        j ← i − 1
        while j ≥ 0 and A[j ] > A[j + 1] do
            swap(A[j ], A[j + 1])
            j ← j − 1
*/
/********** Implementation Section **********/



public class InsertionCompare {
    public static int SwapCount=0;
    // passing in the array to the swap method so that the array's values are being sorted, as the method must be treated as a pass by reference interpretation.
    public static void swap(int [] Arr, int temp1, int temp2){
        int temp=Arr[temp1];
        Arr[temp1]=Arr[temp2];
        Arr[temp2]= temp;
        SwapCount+=3;
        //  each time the swap method for that array is called, each of these assignments will occur once, and the total number of operations inside the swap method will be 3.
    }

    public static void InsertionSort(int[] A){
        //
        // If the list is already sorted, then the while loop will never run, since its condition to run it is never met.
        int count1=0, count2=0,count3=0, count4=0;
        int n=A.length;
        for(int i=1; i<n; i++){
            int v=A[i];
            int j=i-1;
            while(j>=0 && A[j] > v){
                count1++; // represents while loop condition: j>=0
                count2++; // represents while loop condition: A[j] > v
                count3++; // represents assignment operation: A[j+1]=A[j];
                count4++; // represents assignment operation: j--
                A[j+1]=A[j];
                j--; // or j = j-1
            }
            A[j+1]=v;
        }
        System.out.println("\nInsertionSort Stats: ");
        System.out.println("\tj <= 0:\t\t\t\t"+ count1);
        System.out.println("\tA[j] > v:\t\t\t"+ count2);
        System.out.println("\tA[j+1] = A[j]:\t\t"+ count3);
        System.out.println("\tj = j-1:\t\t\t"+ count4);
        System.out.println();
    }
    public static void InsertionSort2(int[] A){
        int count1=0, count2=0, count3=0;
        SwapCount=0;
        int n=A.length;
        for(int i=1; i<n; i++){
            int j=i-1;
            while(j>=0 && A[j] > A[j+1]){
                count1++; // represents while loop condition: j>=0
                count2++; // represents while loop condition: A[j] > [Aj+1]
                swap(A, j, j+1);
                count3++; // represents assignment operation j--.
                j--;
            }
        }
        System.out.println("\nInsertionSort2 Stats: ");
        System.out.println("\tj <= 0:\t\t\t\t"+ count1);
        System.out.println("\tA[j] > A[j+1]:\t\t"+ count2);
        System.out.println("\tSwap:\t\t\t\t"+ SwapCount);
        System.out.println("\tj = j-1:\t\t\t"+ count3);
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int MenuChoice=0;
        int[] myArray= new int[0];
        int[] myArray2= new int[0];
        boolean isChosen=false;
        do{
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read array size");
            System.out.println("2. Read array values (integer type)");
            System.out.println("3. Run algorithm comparison and display output");
            System.out.println("4. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            MenuChoice = input.nextInt();

            // Forcing the user to enter the number of values for the array before being able to call the other options.
            while(!isChosen && MenuChoice!=1 && MenuChoice!=4 ){
                System.out.println("You must select option 1 first");
                MenuChoice = input.nextInt();
                if(MenuChoice==1 || MenuChoice==4){
                    isChosen=true;
                }
            }
                switch (MenuChoice) {
                    case 1:
                        isChosen=true;
                        System.out.print("How many integer values do you want to put into the array? ");
                        int Size = input.nextInt();
                        myArray = new int[Size];
                        myArray2 = new int[Size];
                        break;
                    case 2:
                        for (int i = 0; i < myArray.length; i++) {
                            System.out.print("Enter an integer value for index " + i + ": ");
                            myArray[i] = input.nextInt();
                            myArray2[i] = myArray[i];
                        }
                        break;
                    case 3:
                        System.out.println("Array size:\t\t\t\t" + myArray.length);
                        System.out.print("Array values:\t\t\t");
                        for (int j : myArray) {
                            System.out.print(j + " ");
                        }
                        InsertionSort(myArray);
                        InsertionSort2(myArray2);
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