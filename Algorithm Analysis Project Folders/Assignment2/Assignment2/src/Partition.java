import java.util.*;
// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 2
/********** Algorithm Design Block **********/

/* Steps:
Step 1: Find the total sum of all the elements that make up the original set
Step 2: If the sum of the original set is odd, then exit the program otherwise go to Step 3:
Step 3: Generate the Powerset that makes up the original set of values.
Step 4: Choose sets whose sum is the number being looked for and exclude all other sets that share some values with the chosen set.
Step 5: Choose another set whose sum is the number being looked for and whose values.
Step 6: Print out both subsets whose sum is the value being looked for.
*/

/* Algorithm pseudocode syntax
// Input: An array A of size N where the elements go from A[0...N-1], int subsetSumToGet
// Output: printing out the subsets that are unique to each other.
 n<- A's length
 let pow=2^n
 for i <- 0 down to pow do
    create ArrayList B
       for j<-0 down to n
          if (i AND (1<<j)) > 0
             add A[j] to B
          end if
       end do
       totalSum=0;
       for k<-0 down to B's size do
       totalSum <-totalSum+B[k]
       end do
       if totalSum = subsetSumToGet
        Iterate though separate Array of unique values to make sure that integers are only used once, and if they are not on the list
        return
         for l<-0 down to B's length do
            print B[i]
         end do
       end if

    end do

 */

/********** Implementation Section **********/


public class Partition
{
    public static ArrayList<Integer> ListToTrack= new ArrayList<>();
    public static void printSubSet(ArrayList<Integer> List, int sumToGet){
        // Checking if the total sum of the subset generated will follow the criteria.
        int totalSum=0;
        for(int i=0; i<List.size(); i++){
            totalSum+=List.get(i);
        }
        // making sure that no two sets that have identical values are printed.
        if(totalSum==sumToGet) {
            for(int i=0; i<List.size(); i++){
                if(!isFound(List.get(i))){
                    return;
                }
            }

            System.out.print("{");
                for (int i = 0; i < List.size(); i++) {

                        if (i == List.size() - 1) {
                            System.out.print(List.get(i));
                        } else {

                            System.out.print(List.get(i) + ",");
                        }
                        ListToTrack.remove(List.get(i));

                }
                System.out.println("}");
                System.out.print("\t\t\t\t\t\t\t\t\t");

        }
    }
    public static boolean isFound(int NumToFind){
        // Remove already used integer values from the list so that the sets that are generated will have unique values.
        for(int i=0;i<ListToTrack.size(); i++){
            if(NumToFind==ListToTrack.get(i)){
                return true;
            }
        }
        return false;
    }
    public static void getSubsets(int []OriginalSet, int sumToGet){
        int n=OriginalSet.length;
        // Determining how many subsets of the following array passed into the method generates. An exhaustive way of finding the valid sets requires making the power sets, and the sum of each valid power set where they are unique can be used to determine what two sets will count for the problem question.
        int maxTimes=(int)Math.pow(2,n);
        for(int i=0; i<maxTimes; i++){
            ArrayList<Integer>CurrentList= new ArrayList<>();
            for(int j=0; j<n; j++){
                // Left shift of bitwise components are useful to generate the power set of the set of elements.
                // If the subsets can be determined, then the subsets that generate the desired value can be included to determine the distinct sets, add each individual element to the current set.
                if((i & (1<<j)) > 0){
                    CurrentList.add(OriginalSet[j]);

                }
            }
            // Checking if the current subset is valid.
           printSubSet(CurrentList, sumToGet);
        }

    }


    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int MenuChoice, SetSize=0;
        int[] NumberSet= new int[0];
        do{
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read set size (number of integers)");
            System.out.println("2. Read integer values");
            System.out.println("3. Run algorithm and display output");
            System.out.println("4. Exit Program");
            System.out.println();
            System.out.print("Enter option number: ");
            MenuChoice= input.nextInt();
            switch (MenuChoice){
                case 1:
                    System.out.println("How many integers do you want to have in a set?");
                    SetSize=input.nextInt();
                    // create the array to have that size.
                    NumberSet = new int[SetSize];
                    break;
                case 2:
                    for(int i=0; i<NumberSet.length; i++){
                        // populate array with user inputted values
                        System.out.println("Enter number "+ (i+1) + " for the set.");
                        NumberSet[i]=input.nextInt();
                    }
                    break;
                case 3:
                    System.out.println("Set size:\t\t\t\t\t"+ NumberSet.length + " integers");
                    System.out.print("Integer values\t\t\t\t");
                    for(int i=0; i<NumberSet.length; i++){
                        System.out.print(NumberSet[i] + " ");

                    }
                    System.out.println();
                    int CanMakeASet=0;
                    for(int i=0; i<NumberSet.length; i++){
                        CanMakeASet+=NumberSet[i];
                    }
                    System.out.print("Disjoint subsets with the same sum: ");
                    // Making sure that it would be valid to create subsets depending on the sum of all the elements in the orginal set.
                    if(CanMakeASet%2==1){
                        System.out.print("No disjoint subsets with the same sum of their elements found");
                        System.out.println();
                    }
                    else {
                        int SetTotal=CanMakeASet/2;
                        // copy the contents of the array onto the arrayList.
                        for(int i=0; i<NumberSet.length; i++){
                            ListToTrack.add(NumberSet[i]);
                        }
                        getSubsets(NumberSet, SetTotal);
                        System.out.println();

                    }
                case 4:
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;

            }



        }while(MenuChoice!=4);

    }

}
