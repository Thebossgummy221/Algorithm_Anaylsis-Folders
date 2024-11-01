// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 5
// IDE: IntelliJ IDEA
public class Heapsort
{
    private int numOfComparisons=0;
    private int[] OriginalArray;
    public int getArrayLength(){
        return OriginalArray.length;
    }
    public Heapsort(int[] myArray){
        this.OriginalArray=myArray;
        HeapSorting(OriginalArray);
        
    }

    // the output array comes off as sorted in descending order, just make sure to fill a temp array to be ascending order and set the original array passed in to the new array.

    // utilize a swap operation that is considered to be pass by reference to swap the values in memory.
    public  void swap(int[] myArray, int i, int j){
        int temp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = temp;

    }
    public void HeapSorting(int[] myArray){
        int n = myArray.length;
        // building the max heap by rearranging the array.
        for(int i= n/2-1; i>=0; i--){
            heapify(myArray, n, i);
        }
        // extract an element from the heap
        for(int i = n-1; i>=0; i--){
            // Move current node to the end.
            int temp = myArray[0];
            myArray[0] = myArray[i];
            myArray[i] = temp;
            // call the max heapify on the reduced heap.
            heapify(myArray, i, 0);

        }


    }
    public void heapify(int[] myArray, int n, int i){
        // the method can be implemented recursively where it would be possible to swap the values of the tree starting from the root.
        // An array can be implemented as a heap. We can find the largest value among the current root, the left child and the right child.
        int largest = i; // Initialize the largest as the root.
        int LeftChild = 2* i+1;
        int RightChild = 2 * i+2;
        numOfComparisons+=3;
        // If the left child is larger than the root
        if(LeftChild < n && myArray[LeftChild] > myArray[largest])
        {
            largest= LeftChild;

        }
        // If the right child is larger than the root.
        if(RightChild < n && myArray[RightChild] > myArray[largest])
        {

            largest= RightChild;
        }
        // If the root is not the largest value, then continue to heapify until it is.

        // The largest value is not the root of the tree.
        if(largest!=i){
            swap(myArray, i, largest);
            // Recursively heapify the affected subtree.
            heapify(myArray, n, largest);
        }


    }
    public int getNumOfComparisons(){
        return numOfComparisons;
    }


}
