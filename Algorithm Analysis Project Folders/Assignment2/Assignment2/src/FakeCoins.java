import java.util.*;
// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 2

// work table format for this one.
/********** Algorithm Design Block **********/

/* Steps:
Step 1: Let i start at the first index of the CoinStacks being checked
Step 2: If the weight of the stack at the current index is 11, go to Step 3, otherwise go to Step 4
Step 3: Increment i by 1 so that the next weight can be checked and return to step 2.
Step 4: Return the index i of the fake coin stack and exit.



*/
/* Algorithm pseudocode syntax
Input: An array FC[0,... n-1 ] of n integers representing each coin weight stored in an array
Output The index of the coin stack that has the fake coins.

Let Index <- -1
    for i <-0 down to n do
        if FC[i]=11
            Index <- i
            break
        end if
    end do
    return Index;
 */

/* a. To check what stack of coins in the algorithm are fake, the algorithm above will perform a "linear search" of sorts, trying to find the first instance of 11 as the weight.
 Since there can only be one stack that is fake, it would be possible to iterate through the array of weights, until we can find a weight of 11.
 The best case scenario for the above algorithm is that the first stack to be checked is full of the fake coins, meaning the best performance is 0(1). The statement that will contribute most to time complexity is the conditional statement inside the for loop.
 The worst case scenario for the above algorithm is that the last stack of coins to be weighed has the fake coins, meaning that the "linear search" performed on the coins would have the complexity of O(n), since the if statement is guaranteed to occur inside the for loop and will run for n times if the fake coin is in the last stack or the fake coin cannot be found.
 From the average of the best case and the worst case, the overall run time complexity of the algorithm is O(n).
 Table Format:
 i loop runs for the	If  Max	 Min	 return
     1st	             1	1	 0	   1
     2nd	             1	1	 0
     3rd	             1	1	 0
      .	                 1	1	 0
      .	                 1	1	 0
      .	                 1	1	 0
      .	                 1	1	 0
      .	                 1	1	 0
     nth	             1	1	 0
Best Case: 1, where the first stack to be checked has the fake coins. O(1)
Worst Case: The stack of fake coins is the last stack to be checked or no fake coin stack existed.
Time complexity: n+2 = O(n).




*/

/* b.
The minimum number of weightings that can identify the stack with the fake coins will be O(logn).
If the stack of coins is initially an even number, then we can separate the total number of stacks into separate piles and weigh both of these piles.
If one of the piles weighs more than the other, then the heavier pile must contain a stack of fake coins and we can then divide this pile into two separate pieces and weigh both piles again until we it is possible to weigh two stacks of coins where one of them is guaranteed to be the fake coin.
If the number of coins being weighed is an odd number, then we can split off each stack so that two piles are compared to each other and one stack is set aside.
If the piles are equal to each other, then the stack that is set aside had the fake coins, otherwise we would need to divide the heavier pile into two separate piles and compare their weights.
 */
/********** Implementation Section **********/

public class FakeCoins{
    int numOfComparison=0;
    int indexToCheck;
    // A way of checking what stack has the fake coins is to use a for loop to weigh each stack until one of the stacks weighs 11, and then the index where the fake coin is contained is used.
    // Use a linear search approach to find the fake coin of our array, instead of weighing each pair.

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int MenuChoice, numOfCoins;
        int[] CoinStack = new int[0];
        do{
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read number of stacks/coins per stack");
            System.out.println("2. Read coin weight in each stack (10 or 11 grams)");
            System.out.println("3. Run algorithm and display output");
            System.out.println("4. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            MenuChoice=input.nextInt();
            switch (MenuChoice){
                case 1:
                    System.out.println("How many stacks of coins do you want to weigh? ");
                    numOfCoins=input.nextInt();
                    CoinStack= new int[numOfCoins];
                    break;
                case 2:
                    int useOnce=0;
                    // To simulate the separate stack of coins with their respective weights, we can use an array of weights to return what
                    for(int i=0; i<CoinStack.length; i++){
                       int WeightOfStack=0;

                       // do while loop input validation to make sure that each stack could only have a weight of 10 or 11.
                        do {
                            System.out.println("Enter the weight of stack " + (i + 1));
                            WeightOfStack=input.nextInt();
                            // set Of Conditions below will keep track of now many times a weight of 11 is used, if 11 is entered again for another stack, the counter will keep track of that, making the input validation loop re-ask for another weight.
                            if(WeightOfStack==11){
                                useOnce++;
                            }
                            else {
                                useOnce=0;
                            }


                        }while((WeightOfStack!=10 && WeightOfStack!=11) || useOnce>1);
                        CoinStack[i]=WeightOfStack;

                    }
                    break;
                case 3:
                    System.out.println("Total number of stacks is: \t"+ CoinStack.length);
                    int numOfComparison=0;
                    int indexToCheck=0;
                    // A way of checking what stack has the fake coins is to use a for loop to weigh each stack until one of the stacks weighs 11, and then the index where the fake coin is contained is used.
                    // Use a "linear search" approach to find the fake coin of our array, instead of weighing each coin pair and checking if their weights are similar to each other.
                    for(int i=0; i<CoinStack.length; i++){
                        numOfComparison++;
                        if(CoinStack[i]==11){
                            indexToCheck=i;
                            break;
                        }
                    }

                    System.out.println("Fake coin stack is stack #: "+(indexToCheck+1));
                    System.out.println("# of weighings required: \t" + numOfComparison);
                    break;
                case 4:
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                break;
            }

        }while (MenuChoice!=4);



    }
}