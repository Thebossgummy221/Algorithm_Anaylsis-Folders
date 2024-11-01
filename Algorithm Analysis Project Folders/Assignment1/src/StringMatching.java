// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 1
// IDE:        IntelliJ
/********** Algorithm Design Block **********/
/*
Step 1: Read in both input strings from the user
Step 2: Check the length of both strings.
Step 3: If the length of both strings are different, then make the determination that both strings do not match
Step 3: If a character from both strings is different when iterating through both strings, immediately stop iterating through the string and print out the necessary details and how many comparisons it took to check them.
Step 4: If the character matches at the respective index, then move onto the next index for both strings and repeat Steps 3 and Step 4 until both strings have been checked.
Step 5: Display if the strings match and number of comparisons.
    Pseudocode implementation
    Input: Two string variables
    OutPut: The determination of whether both strings match or not as well as the number of comparisons.

    Let a=length of string 1, b=length of string 2
    Let counter <- 0
    let Matched <-true
    if a does not equal b Then
    Matched <- false
    end Then
    else
    for i <- 0, i is less than string 1's length, i <- i+1 DO
       count <-count+1
    if string1[i] does not equal string2[i]
        THEN
        Match <- false
        Break
        end Then
      end DO
     end else
if Match is false THEN
    Print(Strings do not match)
    Print(Comparisons: + counter)
    end Then
    else
    Print(String match)
    Print(Comparisons: + counter)


*/

/********** Implementation Section ****************/



import java.util.*;
public class StringMatching {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        String word1="", word2="";
        int MenuChoice;
        // Loop here will be used to keep printing the menu until option 3 is selected.
        do{
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read input string1 and string2");
            System.out.println("2. Run algorithm and display output");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            // Making sure to read user input as a string and then convert it to an int so that input prompts or statements will not be skipped over.
            MenuChoice=Integer.parseInt(input.nextLine());
            switch (MenuChoice){
                case 1:
                    // Statements below will read in both input strings from the user.
                    System.out.print("Enter in an input for string 1: ");
                    word1=input.nextLine();
                    System.out.print("Enter in an input for string 2: ");
                    word2=input.nextLine();
                    System.out.println();
                    break;
                case 2:
                    int counter=0;
                    boolean Matched=true;
                    System.out.println("String 1:\t\t\t"+word1);
                    System.out.println("String 2:\t\t\t"+word2);
                    System.out.print("Output:\t\t\t\t");
                    // First we check if the length of both strings are different. If both strings have different lengths, then we can determine that both strings do not match and not make any necessary comparisons to check them both.
                    if(word1.length()!=word2.length()){
                        Matched=false;
                    }
                    // Otherwise, we can treat both strings as an array of characters, using a for loop to iterate through each index, and keep track of the number of comparisons to be made and if both match.
                    else {
                        for(int i=0; i<word1.length(); i++){
                            counter++;
                            // The if statement will check each string character by character, and if the characters do not match from that position, then the for loop immediately breaks and we can make the determination that both strings do not match,
                            if(word1.charAt(i)!=word2.charAt(i)){
                                Matched=false;
                                break;
                            }
                        }
                    }
                    // If statements check our boolean variable for string matching determination.
                    if(!Matched){
                        System.out.println("Strings do not match");
                    }
                    else{
                        System.out.println("Strings match");
                    }
                    System.out.println("Comparisons:\t\t"+counter);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    System.out.println();
                     break;

            }
        }while(MenuChoice!=3);

    }
}

