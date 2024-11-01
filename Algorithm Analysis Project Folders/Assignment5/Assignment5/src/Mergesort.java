// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 5
// IDE: IntelliJ IDEA
public class Mergesort
{
    private int numOfComparisons =0;
    private int[] OriginalArray;
    public int getArrayLength(){
        return OriginalArray.length;
    }
    public Mergesort(int[] myArray){
        this.OriginalArray=myArray;
    MergeSorting(OriginalArray, OriginalArray.length);
    }
    public void MergeSorting(int [] myArray, int N){
        // Array contains only 1 element.
        if(N < 2){
            return;
        }
        else{
            // separate the contents of the original array into two separate arrays in this dividing sequence
            int mid = N/2;
            int[] LeftSide = new int[mid];
            int[] RightSide = new int[N-mid];
            // Copy the contents of the left side of the original array into the first new Array
            for(int i=0; i<mid; i++){
                LeftSide[i]= myArray[i];
            }
            // Copy the contents of the right side of the original array into the second new array
            for(int j= mid; j<N; j++){
             RightSide[j-mid] = myArray[j];
            }
            // Focus on repeatedly splitting the array until the merge portion can happen.
            MergeSorting(LeftSide, mid);
            MergeSorting(RightSide, N-mid);
            // Begin to merge small Arrays and build up the Big Array.
            merge(myArray, LeftSide, RightSide, mid, N-mid);
        }
    }
    public void merge(int[] myArray, int[] LeftArray, int[] RightArray, int Left, int Right){
        int i=0, j=0, k=0;
        // Using a while loop to exhaust our i and j pointer, we can compare each element from both subArrays so that it can be added to the original array.
        while(i<Left && j<Right){
            numOfComparisons++;
            if(LeftArray[i] <= RightArray[j]){
                // Add the small values from the left Array to the original Array.
                myArray[k++] = LeftArray[i++];
            }
            else{
                // Add the value from the Right Array to the original Array.
                myArray[k++] = RightArray[j++];
            }

        }
        // Assuming one of the pointers of the small arrays exceeded its size, the remaining elements from the leftover Array whose Array pointer is still in the array proceeds to the rest of the Array.
        while(i <Left){

            myArray[k++] = LeftArray[i++];
        }
        while(j <Right){

            myArray[k++] = RightArray[j++];
        }
    }
    public int getNumOfComparisons(){
        return numOfComparisons;
    }


}
