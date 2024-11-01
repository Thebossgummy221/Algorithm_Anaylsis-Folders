import java.util.*;
// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 3


/********* Algorithm Design Block **********/

/*
    Step 1: Take in the number of coins to be read as n.
    Step 2: If n =1 or n=2, then simply use a conditional statement to check where the coin is and go to step 7, otherwise move onto step 3
    Step 3: If n is a multiple of 3, create 3 separate pile that have the same number of coins, weigh any two piles and move onto Step 6.
    Step 4: If n is greater than 3 and n mod 3 = 1, put the extra coin in the first pile, begin weighing the piles with the same number of coins, and move onto Step 6.
    Step 5: If n is greater than 3 and n mod 3 = 1, put the extra coin in the first pile, begin weighing the piles with the same number of coins, and move onto Step 6.
    Step 6: If the coins that were weighed have the same value, then focus on splitting the leftover pile into three separate portions and jump back to step 2 or choose the coin pile that is lighter than the other, and begin recurring through it on step 2.
    Step 7: Once the fake coin is located, return the index of the coin.

    Part A.
    FindFakeCoinIndex(A[], LIndex, RIndex, n)
    // Input: An array A[0..n-1] of integers where one of them has the fake coin
    // Output: The index at which the fake coin is contained at.
    if length of A <=2 or LIndex >=RIndex-1  then the first index or last index has that fake coin, so just return the index
    else
        if n mod 3 = 1, then divide coins into 3 piles of sizes of k+1, k and k
            weigh the piles that have k coins.
            if the weight of both piles are similar, then discard both of them and focus recursively on the third pile, making sure that the current Index pointers are the correct value,
            otherwise pick the lighter pile and use the correct index values to recursively call the method again.
        else if n mod 3 =2, then divide coins into 3 piles of sizes k+1, k+1, and k
            weigh the piles that have k+1 coins.
             if the weight of both piles are similar, then discard both of them and focus recursively on the third pile, making sure that the current Index pointers are the correct value,
             otherwise pick the lighter pile and use the correct index values to recursively call the method again.
        else then
         n is considered to be a multiple of 3 and the coins can be neatly stacked into three separate piles that all have the same number of coins in each pile, and begin weighing the first two piles, if the two piles weigh the same, move onto the third pile and recurse from it,
         otherwise move onto the lighter pile from the weighted coins and recurse from the lighter one.

    Part B.
    The recurrence relation for the number of weighings in the decrease by a factor of 3 algorithm for the fakeCoin problem is:
    W(n) = W(n/3) + 1 for n>1
    W(1) = 0 for n=1
    For n = 3^k, the recurrence becomes W(3^k) = W(3^k-1)+1
    W(3^k) = W(3^k-1)+1
    (W(3^k-2)+1)+1 = W(3^k-2) + 2
    (W(3^k-3)+1)+2 = W(3^k-3) + 3
    .
    .
    .
                    = W(3^k-k) + k
                    = W(1) + k = k
                    then k= log_3 n
    Part C:
    Using the worst case as the basis of comparison,
    the ratio of the number of weightings is approximately:
    log_2n / log_3n
    if we let n=3, then
    log_2 3= 1.58
    log_3 3 = 1
    1.58/1 = 1.58 times as much.
    So, the algorithm that would be able to divide the coin into three piles is roughly 1.58 times faster.
*/

/* Algorithm pseudocode syntax





*/
/********** Implementation Section **********/




public class FakeCoin2
{
    // The method below will be used to determine the total weight of all current piles, so that it can be determined exactly where the fake coin potentially is.
    public static int findSumOfArrayFromBeginToEnd(int[] myArray, int startingIndex, int endingIndex){
        int sum=0;
        for(int i=startingIndex; i<endingIndex; i++){
            sum+=myArray[i];
        }
        return sum;

    }
    public static int NumberOfDivisions=0;

    public static int FindIndex(int[] CoinArray,int LIndex,int RIndex){
        // If there are extra coins from the original pile, then it can be added to the first two piles if necessary and their weights can be compared to.
        int count1=0;
        boolean CompareFirstTwo= false;
        // The base case that stops the recursion from our method.
        // If both the current "Pointer" indeces are close to each other, that is there are at most 2 coins being investigated for the fake coin, then the current index values from the method calls will likely contain the index that has the fake coin.
        if(CoinArray.length<=2 || LIndex >= RIndex-1 ){
            if(CoinArray[LIndex]==2){
                return LIndex;
            }
            else if(CoinArray[RIndex]==2) {
                return RIndex;
            }
            // return a negative index to imply the coin has not been found.
            else return -1;

        }
        else {
            NumberOfDivisions++;
            // Increment the number of times the recursive call occurred to represent the number of divisions, when the array was "partitioned into three piles".
            // if both count 1 and count 2 are = to 1, then we compare the first two piles weights and make the necessary recursive call to pass on the pile that potentially has the fake coin.
            if(RIndex % 3==1 || RIndex %3==2) {
                count1++;

            }
            if(RIndex %3 ==2){
                CompareFirstTwo=true;
            }
            // Working with the original array, we can split off the coins into 3 separate piles and begin weighing them by finding their total sums, if there are 2 more coins than a multiple of 3, then we compare the first two piles.
            int sum1 = findSumOfArrayFromBeginToEnd(CoinArray, LIndex, RIndex/3+count1);
            int sum2= findSumOfArrayFromBeginToEnd(CoinArray,RIndex/3+count1, 2*RIndex/3+count1);
            int sum3 = findSumOfArrayFromBeginToEnd(CoinArray, 2*RIndex/3+count1, RIndex);


            if(CompareFirstTwo){
                // We can guarantee that the first two piles have an extra coin.
                if(sum1==sum2){
                    // Check out the third pile and divide into three piles when the recursion occurs.
                    return FindIndex(CoinArray,2*RIndex/3+count1, RIndex-1);
                }
                // return the first pile
                else if(sum1 < sum2){
                    return FindIndex(CoinArray, LIndex, RIndex/3+count1-1);
                }
                // return the second pile for more weighting for the fake coin.
                else {
                    return FindIndex(CoinArray, RIndex/3+count1, 2*RIndex/3+count1-1);
                }

            }
            else {
                if(sum2==sum3){
                    return FindIndex(CoinArray, LIndex, RIndex/3+count1-1);
                }
                else if(sum2 < sum3){
                    return FindIndex(CoinArray, RIndex/3+count1, 2*RIndex/3+count1-1);
                }
                else return FindIndex(CoinArray,2*RIndex/3+count1, RIndex-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int MenuChoice;
        int[] CoinArray= new int[0];
        boolean isChosen=false;
        int CWeight;
        boolean cannotRepeat;
        do{
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read array size");
            System.out.println("2. Read array values (all values are 5 except one value 2)");
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
            switch (MenuChoice){
                case 1:
                    isChosen=true;
                    System.out.println("How many coins do you want to weigh: ");
                    CoinArray= new int[input.nextInt()];
                    break;
                case 2:
                    cannotRepeat=false;
                    for(int i=0; i<CoinArray.length; i++){
                        System.out.print("Enter in a weight for coin " +(i+1) +": ");
                        CWeight=input.nextInt();
                        while (CWeight!=5 && CWeight!=2){
                            System.out.print("Enter a value of 2 or 5: ");
                            CWeight=input.nextInt();
                            }
                        while(cannotRepeat && (CWeight != 5) ){
                            System.out.print("Enter a valid number other than 2: ");
                            CWeight=input.nextInt();
                        }
                        if(CWeight==2){
                            cannotRepeat=true;
                        }
                        CoinArray[i]=CWeight;
                        }
                    break;
                case 3:
                    NumberOfDivisions=0;
                    System.out.println("Array size:\t\t\t" + CoinArray.length);
                    System.out.print("Array values:\t\t");
                    for (int j : CoinArray) {
                        System.out.print(j + " ");
                    }
                    int x=FindIndex(CoinArray, 0, CoinArray.length);
                    System.out.println("\n# of divisions:\t\t"+ NumberOfDivisions);
                    System.out.println("Fake coin index:\t"+x);
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
