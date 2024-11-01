
// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 1
// IDE:        IntelliJ
/********** Algorithm Design Block **********/
/*
Step 1: Read in both input strings from the user.
Step 2: Convert each string to lowercase and store them into temporary string variables.
Step 3: With the temporary strings, each of those characters of both strings can be put into an array of characters, excluding the empty space character.
Step 4: Use BubbleSort on our character array so that our comparisons of both input strings could be made.
Step 5: Check the lengths of both arrays and if they are different sizes, then it can be determined both strings are not anagrams.
Step 6: Otherwise, use a for loop to determine element by element if both strings are anagrams. If the characters at that index are different, immediately make the determination that both strings are not anagrams.

Pseudocode implementation
    Input: Two user input strings as well as the arrays of characters already sorted.
    Output: Checking if both user inputted strings are anagrams and the number of comparisons to make them.
    Let a=length of array 1, b=length of array 2
    Let counter <- 0
    let Matched <-true
    if length of a does not equal length of b Then
    Matched <- false
    end Then
    else
    for i <- 0, i is less than array 1's length, i <- i+1 DO
      count <-count+1
    if array1[i] does not equal array2[i]
        THEN
        Match <- false
        Break
        end Then
        end DO
      end for
     end else
if Match is false THEN
    Print(Strings are not anagrams)
    Print(Comparisons: counter)
    end Then
    else
    Print(String match)
    Print(Comparisons: + counter)



*/

/**************** Implementation Section *************/
import java.util.*;

public class AnagramsCheck
{
    // The method here will convert the string passed into the method to an array of characters.
    // The sorted array of letters can then be passed into our sorting method, so that we can determine if the frequency at which each character occurs is possible.
    public static char[] makeCharArray(String word){
        // Add characters to an arrayList so that the elements of it can be copied over to an actual character array to be returned.
        ArrayList<Character>L1= new ArrayList<>();
        for(int i=0; i< word.length(); i++){
            if(word.charAt(i)!=' ') {
                L1.add(word.charAt(i));
            }
        }
        char[] letters = new char[L1.size()];
        // copying ArrayList elements into an array of characters.
        for(int i=0; i<letters.length; i++){
            letters[i]= L1.get(i);

        }
        return letters;
    }
    // Use BubbleSort to check if each letter present in both arrays match with each other from their indeces.
    public static void sortCharArray(char[] Letters){
        for(int i=0; i< Letters.length-1; i++){
            for(int j=0; j< Letters.length-i-1; j++){
                if(Letters[j] >Letters[j+1]){
                    char temp=Letters[j];
                    Letters[j]=Letters[j+1];
                    Letters[j+1]=temp;
                }
            }
        }

    }
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        String word1="", word2="";
        int MenuChoice;
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
                    // convert the entire string to be lowercase so that it is easy to check if both of the inputs are anagrams of each other.
                    String temp1= word1.toLowerCase();
                    String temp2=word2.toLowerCase();
                    // Convert strings to char array, making sure that any whitespace that were part of the strings are not involved.
                    char[] Letters1=makeCharArray(temp1);
                    char[] Letters2= makeCharArray(temp2);
                    // Call our BubbleSort method to our char array to run the comparison necessary for
                    sortCharArray(Letters1);
                    sortCharArray(Letters2);
                    // Once the array of characters from both strings are sorted, we then can check if they are the same length.
                    // If both lengths are different, then the inputted strings are not anagrams and no such comparisons should be made
                   if(Letters2.length!=Letters1.length){
                       Matched=false;
                   }
                   // using a for loop, since both arrays have the same size, we can compare each of them character by character and find one that does not match
                   else{
                       for(int i=0; i< Letters1.length; i++){
                           counter++;
                           // If the character at this index from both arrays are different, then the string is guaranteed to not be an anagram. As such, the for loop should stop running and then it is possible to print out the number of comparisons done to determine if they are anagrams of each other.
                           if(Letters1[i]!=Letters2[i]){
                               Matched=false;
                               break;
                           }

                       }
                   }
                    if(!Matched){
                        System.out.println("Strings are not anagrams");
                    }
                    else{
                        System.out.println("Strings are anagrams");
                    }
                    System.out.println("Comparisons:\t\t"+counter);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    System.out.println();
                    break;
            }

        }while(MenuChoice!=3);


    }

}

