// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 5
// IDE: IntelliJ IDEA
public class Quicksort
{
    private int numOfComparisons=0;
    private int[] OriginalArray;
    public int getArrayLength(){
        return OriginalArray.length;
    }
    // swap method is considered to be pass by reference, so that the actual values stored in those indexes are swapped in memory.
public void swap(int[] myArray, int i, int j){
    int temp = myArray[i];
    myArray[i] = myArray[j];
    myArray[j] = temp;

}


public Quicksort(int[] myArray){
        this.OriginalArray=myArray;
    QuickSorting(OriginalArray, 0, OriginalArray.length-1);
}

public void QuickSorting(int[] myArray, int low, int high){
// Figure out the necessary partitions and pivot values are used so that the necessary amount of swaps done is not too excessive.

    //numOfComparisons++;
    if(low >=high){
        return;
    }
    int piv = HoarePartition(myArray, low, high);
    QuickSorting(myArray, low, piv);
    QuickSorting(myArray, piv+1, high);

}




public int HoarePartition(int[] myArray, int Low, int High){
    // It is better to start partitioning at the middle index, so that Stack overflow doesn't occur if the beginning pivot is the value in the first cell.
        int pivot = myArray[(Low+High)/2];
        int i= Low-1;
        int j= High+1;
         while (true){
       do{
           // Increment this to find the leftmost element that is greater than or equal to the pivot
           i++;
          numOfComparisons++;
       }while (myArray[i] < pivot);
       do{
           // Decrement j value to find the rightmost element that is smaller than or equal to the pivot
           j--;
           numOfComparisons++;
       }while (myArray[j] > pivot);
        // If the i and j pointers meet each other or cross with each other, then return the pivot position at j.
             numOfComparisons++;
             if(i>=j){
                 return j;
             }
             // swap the values at index i and j if the statement above failed to get hit.
        swap(myArray, i, j);
        }
}




    public int getNumOfComparisons() {
        return numOfComparisons;
    }
}
