// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 5
// IDE: IntelliJ IDEA
/********** Algorithm Design Block **********/
/*
Observations:
MergeSort:
    Best Case: The number of basic operations conducted will roughly be O(N Log N).
    Worst Case: The number of basic operations conducted will roughly be O(N Log N).
    Average Case: The number of basic operations conducted will roughly be O(N Log N).
    Overall, the worst, best, and average case time efficiency for MergeSort will be O(N Log N).
    Ideally, the consistent number of comparisons being documented and examined would be for the increasing integer array and the decreasing integer array,
    The number of comparisons for the increasing array and the decreasing array is less than the Random array.
QuickSort:
    Best Case: The number of basic operations conducted will roughly be O(N Log N).
    Average Case: The number of basic operations conducted will roughly be O(N Log N).
    Worst Case: If the pivot was the element chosen at the beginning of the array and the array are already sorted, then the number of basic operations would be O(N^2).
    In terms of measuring the Best Case and the Average Case, the number of comparisons is better to the time complexity of the algorithm if the pivot that was chosen was the middle element.
    From the generated sample outputs however: The number of comparisons that quicksort enacts is not O(N^2) in implementation. In the Hoare's partitioning method, the pivot element was the value at the center of the list, and this is intentional as it avoids a stack overflow situation.
    The order of magnitude of QuickSort cannot be changed to be much better, but it runs slightly "faster" if the pivot element in Hoare's partitioning method were to be the middle value.
    The time complexity of QuickSort is influenced by what is chosen as the pivot value, as if the middle is chosen then the number of comparisons on an increasing/decreasing sorted array is better than an array that is populated randomly.
    From the generated outputs and the implementation of the algorithm, all QuickSort implementations on these arrays are to the magnitude of O(N Log N).
HeapSort:
    Best Case: The number of basic operations conducted will roughly be O(N Log N).
    Worst Case: The number of basic operations conducted will roughly be O(N Log N).
    Average Case: The number of basic operations conducted will roughly be O(N Log N).
    Using the increasing/decreasing array types, heapsort runs faster on these arrays than the arrays that have been randomly populated with values and their number of comparisons will be equal to each other.
    Comparing the number of comparison for each of these array types, HeapSort conducts its basic operations more often and more frequently than MergeSort and QuickSort do.
    No matter what, Heap Sort will always run in O(N Log N) times.
    Compared to MergeSort and QuickSort, HeapSort is the worst sorting algorithm among all these three.
*/
/********** Implementation Section **********/
import java.util.*;

public class testAdvancedSorting {
    // Setting the bound of the randomly generated integer number to be from i - arraySize inclusive.
    public static int[] RandomIntegers(int[] myArray, int ArraySize){
        Random myRand = new Random();
        for(int i=0; i<ArraySize; i++){
            myArray[i]= myRand.nextInt(1, ArraySize+1);
        }
    return myArray;
    }
    public static int[] IncreasingIntegers(int[] myArray, int ArraySize){
        for(int i=0; i<ArraySize; i++){
            myArray[i] = i+1;

        }
        return myArray;

    }
    public static int[] DecreasingIntegers(int[] myArray, int ArraySize){
        for(int i=0; i<ArraySize; i++){
            myArray[i] = myArray.length-i;
        }
        return myArray;
    }
    // using separate helper methods to help print out the comparisons of each object over and over again.
    public static void printArrayCompFromMergeSort(int begin, int end, ArrayList<Mergesort> MergeObjects){
        for(int i=begin; i<end; i++){
            System.out.print(MergeObjects.get(i).getNumOfComparisons()+"\t\t");
        }
        System.out.println();
    }
    public static void printArrayCompFromQuickSort(int begin, int end, ArrayList<Quicksort> QuickObjects){
        for(int i=begin; i<end; i++) {

                System.out.print(QuickObjects.get(i).getNumOfComparisons() + "\t\t");

        }
        System.out.println();


    }
    public static void printArrayCompFromHeapSort(int begin, int end, ArrayList<Heapsort> HeapObjects){
        for(int i=begin; i<end; i++){
            System.out.print(HeapObjects.get(i).getNumOfComparisons()+"\t\t");
        }
        System.out.println();

    }






    public static void displayResults(ArrayList<Mergesort> mergeObjects, ArrayList<Quicksort> QuickObjects, ArrayList<Heapsort> HeapObjects){
        System.out.println("Array Type: Random");
        System.out.println("Algorithm\tn=1000\t\tn=10000\t\tn=100000\tn=1000000");
        System.out.println("----------------------------------------------------------");
        System.out.print("MergeSort\t");
        printArrayCompFromMergeSort(0, 4, mergeObjects);
        System.out.print("QuickSort\t");
        printArrayCompFromQuickSort(0,4, QuickObjects);
        System.out.print("Heapsort\t");
        printArrayCompFromHeapSort(0,4, HeapObjects);
        System.out.println();
        System.out.println("Array Type: Increasing");
        System.out.println("Algorithm\tn=1000\t\tn=10000\t\tn=100000\tn=1000000");
        System.out.println("----------------------------------------------------------");
        System.out.print("MergeSort\t");
        printArrayCompFromMergeSort(4, 8, mergeObjects);
        System.out.print("QuickSort\t");
        printArrayCompFromQuickSort(4,8, QuickObjects);
        System.out.print("Heapsort\t");
        printArrayCompFromHeapSort(4,8, HeapObjects);
        System.out.println();
        System.out.println("Array Type: Decreasing");
        System.out.println("Algorithm\tn=1000\t\tn=10000\t\tn=100000\tn=1000000");
        System.out.println("----------------------------------------------------------");
        System.out.print("MergeSort\t");
        printArrayCompFromMergeSort(8, 12, mergeObjects);
        System.out.print("QuickSort\t");
        printArrayCompFromQuickSort(8,12, QuickObjects);
        System.out.print("Heapsort\t");
        printArrayCompFromHeapSort(8,12, HeapObjects);
        System.out.println();

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Mergesort> MergeObjects = new ArrayList<>();
        ArrayList<Quicksort> QuickObjects = new ArrayList<>();
        ArrayList<Heapsort> HeapObjects = new ArrayList<>();
        int MenuChoice;
        ArrayList<int[]> RandomList = new ArrayList<>();
        ArrayList<int[]> IncreasingList = new ArrayList<>();
        ArrayList<int [] >DecreasingList = new ArrayList<>();
        int[] TestArray1 = new int[1000];
        int[] TestArray2 = new int[10000];
        int[] TestArray3 = new int[100000];
        int[] TestArray4 = new int[1000000];
        int[] TestArray5 = new int[1000];
        int[] TestArray6 = new int[10000];
        int[] TestArray7 = new int[100000];
        int[] TestArray8 = new int[1000000];
        int[] TestArray9 = new int[1000];
        int[] TestArray10  = new int[10000];
        int[] TestArray11 = new int[100000];
        int[] TestArray12 = new int[1000000];
        // adding 4 array objects into their separate arrayLists, so that each can relate to the method that populates them along with their size
        // Menu option 2 will create each object using the respective parameters, make the object, and add it to the necessary ArrayList.
        RandomList.add(TestArray1);
        RandomList.add(TestArray2);
        RandomList.add(TestArray3);
        RandomList.add(TestArray4);
        IncreasingList.add(TestArray5);
        IncreasingList.add(TestArray6);
        IncreasingList.add(TestArray7);
        IncreasingList.add(TestArray8);
        DecreasingList.add(TestArray9);
        DecreasingList.add(TestArray10);
        DecreasingList.add(TestArray11);
        DecreasingList.add(TestArray12);
        do{
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Populate Arrays");
            System.out.println("2. Run Algorithms");
            System.out.println("3. Display Outputs");
            System.out.println("4. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            MenuChoice = input.nextInt();
            switch (MenuChoice){
                case 1:
                    // Populate each array that belongs to the ArrayList with the necessary method calls. The first four arrays will be Random Integers.
                    // The next set of arrays will be populated with increasing Integers.
                    // The last set of arrays will be populated with decreasing Integers.
                    // Additionally, the arrayLists of each object must be rest whenever the arrays are repopulated.
                    MergeObjects.clear();
                    QuickObjects.clear();
                    HeapObjects.clear();
                    RandomList.replaceAll(myArray -> RandomIntegers(myArray, myArray.length));
                    for(int i=0; i<IncreasingList.size(); i++){
                        IncreasingList.set(i, IncreasingIntegers(IncreasingList.get(i), IncreasingList.get(i).length));
                    }
                    for(int i=0; i<DecreasingList.size(); i++){
                     DecreasingList.set(i, DecreasingIntegers(DecreasingList.get(i), DecreasingList.get(i).length));
                    }
                    System.out.println("The arrays are now populated");
                    break;
                case 2:
                    // The second case will create the objects and add them to the arrayList so that the method that can display the comparisons each sorting method implemented on the arrays of this type.
                    // Create each object within the loop and add them to the respective arrayList.
                    // Each object is created 4 times and added to their respective arrayLists.

                    for(int i=0; i< RandomList.size(); i++){
                        MergeObjects.add(new Mergesort(RandomList.get(i)));
                       QuickObjects.add(new Quicksort(RandomList.get(i)));
                        HeapObjects.add(new Heapsort(RandomList.get(i)));

                    }
                    for(int i=0; i<IncreasingList.size(); i++){
                        MergeObjects.add(new Mergesort(IncreasingList.get(i)));
                        QuickObjects.add(new Quicksort(IncreasingList.get(i)));
                        HeapObjects.add(new Heapsort(RandomList.get(i)));
                    }
                    for(int i=0; i<DecreasingList.size(); i++){
                        MergeObjects.add(new Mergesort(DecreasingList.get(i)));
                     QuickObjects.add(new Quicksort(DecreasingList.get(i)));
                     HeapObjects.add(new Heapsort(DecreasingList.get(i)));
                    }
                    System.out.println("Arrays are now sorted");
                    break;

                case 3:
                    System.out.println();
                    // Menu Option 4 will read in the ArrayLists of these objects so that the number of comparisons each of them made will be
                    displayResults(MergeObjects, QuickObjects, HeapObjects);
                    break;

                case 4:
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }
            System.out.println();

        }while (MenuChoice!=4);


    }
}