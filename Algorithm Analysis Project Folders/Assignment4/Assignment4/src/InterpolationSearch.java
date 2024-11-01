// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 4


public class InterpolationSearch
{
    private boolean Found= false;
    private int targetIndex =0;
    private int numOfDivision =0;
    InterpolationSearch(int[] SearchArray, int target){
    Interpolation(SearchArray, 0, SearchArray.length-1, target);
    }
    // Interpolation Search can be implemented as a recursive method,

    // The number of times the below method is called will be used to track the number of divisions made. With how Interpolation repeatedly changes the low and high values.
    // We can  use recursion to limit the number of elements being iterated/searched through so that the target key value can be found assuming the search is not exhausted.
    // Ideally, the method will have to be called a number of times signifying the number of divisions attempted. If the recursion cannot find the target value, then the index to be returned is -1.
    public void Interpolation(int [] Arr, int low, int high, int key){
        if(low <=high && key >=Arr[low] && key<=Arr[high]){
            numOfDivision++;
            int mid = low + (((key -Arr[low])* (high-low)) / (Arr[high] - Arr[low]));
            // The middle value of the array contains the key we are looking for
            if(Arr[mid] == key){
                targetIndex=mid;
                Found = true;
                return;
            }
            // Conditional statement below will occur if both the high value and low value are pointing at the same array cell.
            // Searching for the last time for the very first or very last value from the array.
            if(high==low){
                if(Arr[low]==key){
                    targetIndex = low;
                    Found=true;
                }
                else{
                    targetIndex=-1;
                    Found = false;
                }
                return;

            }

            // the key value being looked for is in the right subarray of the original array passed in.
           else if(Arr[mid] < key){
                Interpolation(Arr,mid+1, high, key  );
            }
            // key value being looked for is in the left subArray of the original Array.
           else if(Arr[mid] > key){
                Interpolation(Arr, low, mid-1, key);
            }
        }


        // The search failed, and the key value has not been found. As such, index of negative 1 is passed.
            targetIndex=-1;
            Found=false;
    }

    // Getter methods inside our class that will be used later in the RunIs method.
    public int getNumOfDivision() {
        return numOfDivision;
    }
    public int getTargetIndex(){
        return targetIndex;
    }

    public boolean isFound() {
        return Found;
    }
}
