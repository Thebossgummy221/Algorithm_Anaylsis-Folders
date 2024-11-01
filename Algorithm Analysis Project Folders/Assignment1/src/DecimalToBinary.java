// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 1
// IDE:        IntelliJ
/********** Algorithm Design Block **********/
/*
Step 1: Take in user input
Step 2: Divide the given number n by 2, and the remainder will be the next digit of the binary representation expected of our string.
Step 3: Add the remainder to an array or an ArrayList to print out later.
Step 4: Replace n by the quotient of the last division and repeat the operation until n=0;

Pseudocode implementation
Algorithm implements the standard for finding the binary expansion of a positive decimal integer.
Input: A positive decimal integer DecimalValue
Output: The array or list of binary digits from BinaryDigit_k, BinaryDigit_k-1, ... BinaryDigit_0 of DecimalValue's binary digits.
Create temp <-DecimalValue
Create k<- 0
while temp does not equal 0
    BinaryDigit_k <-temp mod 2
    temp <- temp/2
    k <- k+1


*/


/********** Implementation Section **********/

    import java.util.*;
public class DecimalToBinary
{

    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        int MenuChoice;
        int DecimalValue=0;
        do{
            ArrayList<Integer>BDigits=new ArrayList<>();
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read input decimal value");
            System.out.println("2. Run algorithm and display output");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            MenuChoice=input.nextInt();
            switch (MenuChoice) {
                case 1:
                    System.out.print("Enter in a decimal value: ");
                    DecimalValue=input.nextInt();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Decimal Value:\t\t\t"+ DecimalValue);
                    int temp=DecimalValue;
                    int counter=0;
                    int index=0;
                    // Using arrayList to store the 0's and 1's of our representation since any positive integer number can be entered.
                    // With an arrayList, we don't have to worry about checking for empty array cells since that would cause a NullPointer Exception.
                    while(temp!=0){
                        counter++;
                        BDigits.add(temp%2);
                        temp=temp/2;
                    }
                    // Print the binary digits starting at the end of the ArrayList, and then making our way to the beginning.
                    // With how the binary digits were stored, it would be ideal to begin printing from the right and making our way to the left.
                    System.out.print("Output Binary value:\t");
                    for(int i=BDigits.size()-1; i>=0; i--){
                        System.out.print(BDigits.get(i));
                    }
                    System.out.println();
                    System.out.println("Divisions:\t\t\t\t" +counter);
                    System.out.println();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    System.out.println();
                    break;

            }

        }while(MenuChoice!=3);


    }
}
