import java.util.*;
// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 2
/********** Algorithm Design Block **********/

/* Steps:
Step 1: Start at the first character of the input string where i represents the current index.
Step 2 Increment I value by one
Step 3: If character at current index is the beginning character of substring, go to Step 4, if not go to step 3.
Step 5: Create a j variable and let it start after the index of the i value.
Step 6: Iterate through the string, counting the number of occurrences of the last character of the substring, making sure that loop runs till the end of the substring.
Step 7 After j loop is over, go back to Step 2 and repeat until the second to last character is checked.
Step 8: return the num of occurrences.


*/
/* Algorithm pseudocode syntax
// Input: A string of words where we would need to find substrings that begin with a and end with B.
// Output: The number of total substrings the original string has made up of these character pairs.
    numOfSubstrings(String example)
let Comparison <-0
let N=length of string passed into the method
    for int i <- 0 to N-1 do
        c<-string[i]
        if(c='a' || c='A')
            for j <-i+1 to N do
                c2 <- string[j]
                if(c2='b || c2='B')
                    Comparison <-Comparison+1
                 end If
            end do
         end if
    end do
return Comparison
 */
/*
For the following algorithm's pseudocode above, the best case scenario for the brute force method is for the outer loop to run for O(n) times.
Additionally, the best case scenario does not let the inner for loop inside the conditional statement execute, implying that the beginnning instance of a character in the string does not exist in the string.
The worst case scenario for the following method: would have to be O(n^2), since it would guarantee the inner for loop inside the first conditional statement would have to run a number of times, depending on what the current value of i is.
The average case scenario for the entire brute force algorithm is O(n^2):

Table Format:
i loop	If	Max comp	Min comp	J loop	If	    Max 	min
1   	1	  1	            0	    n-1	    n-1     n-1 	0
2	    1	  1	            0	    n-2	    n-2	    n-2 	0
3   	1	  1	            0	    n-3	    n-3	    n-3 	0
.	    1	  1   	        0	    .	    .	     .  	0
.	    1	  1	            0	    .	    .	     .	    0
.	    1	  1           	0	    .	    .	     .  	0
.	    1 	  1	            0	    .	    .	     .	    0
.	    1 	  1	            0	    .   	.	     .	    0
n-1	    1	  1	            0	    1	    1	     1	    0

Best Case scenario: n-1 = O(n)
Worst Case scenario 2(n-1) + (n^2 -n)/2 = (n^2 -3n -4)/2 = O(n^2)
Average Case scenario is: (n-1 + (n^2 -3n -4)/2)/2 = O(n^2)


 */
/********** Implementation Section **********/


public class Substrings
{
    public static int numOfSubstrings(String example){
        int numOfSubstrings=0;
        // convert entire string to lower case so that number of substrings found is easier to conduct.
        String testString=example.toLowerCase();
        // We want to make sure that the character being checked for is not on the last index of the array, and once we find it, the nested loop inside the if statement should iterate.
        for(int i=0; i<testString.length()-1; i++){
            // If an instance of the first character is discovered, then we can through the string starting the index after the current index and count how many occurrences of the b character exist.
            if(testString.charAt(i)=='a'){
                // The j loop would have to iterate through the remainder of the array, and includes the last character.
                for(int j=i+1; j<testString.length(); j++){
                    if(testString.charAt(j)=='b'){
                        numOfSubstrings++;
                    }
                }
            }

        }

        return numOfSubstrings;
    }
    public static int numOfComparisons(String example){
        int numOfComparisons=0;
        int numOfSubstrings=0;
        String testString=example.toLowerCase();
        // We want to make sure that the character being checked for is not on the last index of the array, and once we find it, the nested loop inside the if statement should iterate.
        for(int i=0; i<testString.length()-1; i++){
            numOfComparisons++;
            // If an instance of the first character is discovered, then we can through the string starting the index after the current index and count how many occurrences of the b character exist.
            if(testString.charAt(i)=='a'){
                // The j loop would have to iterate through the remainder of the array, and includes the last character.
                for(int j=i+1; j<testString.length(); j++){
                    numOfComparisons++;
                    if(testString.charAt(j)=='b'){
                        numOfSubstrings++;
                    }
                }
            }

        }

        return numOfComparisons;
    }




    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int MenuChoice=0;
    String testString="";
    do{
        System.out.println("-----------------MAIN MENU--------------");
        System.out.println("1. Read input string");
        System.out.println("2. Run algorithm and display output(substrings and number of comparisons)");
        System.out.println("3. Exit program");
        System.out.println();
        System.out.print("Enter option number: ");
        MenuChoice=Integer.parseInt(input.nextLine());
        switch (MenuChoice){
            case 1:
                System.out.println("Enter the input string you want to find substrings for ");
                testString= input.nextLine();
                break;
            case 2:
                System.out.println("Input string:\t\t"+testString);
                System.out.println("# of substrings:\t" + numOfSubstrings(testString));
                System.out.println("# of comparisons:\t" + numOfComparisons(testString));
                break;
            case 3:
                System.out.println();
            default:
                System.out.println("Invalid input, please try again");
                break;
        }



    }while (MenuChoice!=3);

    }
}
