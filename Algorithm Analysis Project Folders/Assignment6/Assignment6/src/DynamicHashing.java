// Name: Manjote Singh
// Class: CS 4306/2
// Term: Fall 2022
// Instructor: Dr. Haddad
// Assignment: 6
/********** Algorithm Design Block **********/
/*
Observations:
Test 1:
    Using the first test string as an example, the input of strings contained 26 unique words that started with different letters used to compute the hash function.
    From testing the program, the total number of possible comparisons using this test string was 52 comparisons, where 26 of these comparisons counted the occurrence of each word, and 26 comparisons occurred in total whenever each word was being hashed to their respective list.
    Since each of these LinkedList objects stored within the ArrayList all contained only 1 word each, the number of comparisons made to try and insert the current string wasn't too difficult.
    Compared to the hypothetical theoretical efficiency numbers from the pdf, the hashing method worked effectively as expected, since none of the LinkedList objects contained more than 1 string.
    Compared to the other inputs in the other tests, Test 1 had the best efficiency class in terms of its number of comparisons.

Test 2:
    Using the second test string as an example, the input of strings contained 26 words that was the same word, where all of these words have the same hash function.
    From testing the string with the program, the total number pf possible comparisons made using this test string is 352, where 26 of these comparisons were from the occurrences of this one string, and the rest were from trying to insert this string into the LinkedList's overflow area.
    Since only one of these LinkedList objects stored within the ArrayList had more than 1 string inserted into it, the number of comparisons that were made to insert each successive word got larger.
    Compared to the hypothetical theoretical efficiency Numbers from the pdf, the hashing method worked effectively as expected, even though the number of its comparisons are larger than the first test.
    Compared to the other input Tests made with different strings, Test 2 and Test 3 have the same number of total comparisons made.


Test 3:
    Using the third test string as an example, the input of strings contained 26 words that started with the same beginning letter, where all of these words have the same hash function.
    From testing the string with the program, the total number pf possible comparisons made using this test string is 352, where 26 of these comparisons were from the occurrences of each separate string, and the rest were from trying to insert this string into the LinkedList's overflow area.
    Since only one of these LinkedList objects stored within the ArrayList had more than 1 string inserted into it, the number of comparisons that were made to insert each successive word got larger.
    Compared to the theoretical efficiency numbers from the pdf, the hashing method worked effectively as expected, even though the number of its comparisons are larger than the first test.
    Compared to the other input Tests made with different strings, Test 2 and Test 3 have the same number of total comparisons made.
    Since Test 2 and Test 3 only produce one Hash Function value/index for its strings, it can be assumed that the number of comparisons made for Test 2 and Test 3 are the same.


Test 4:
    Using the fourth test string as an example, the input of strings contained 26 words where some of them started with the same letter, which allowed some repeats of the hash function value.
    From testing the string with the program, the total number of possible comparisons made using this test string is 64, where 26 of them were the total number of occurrences of the words and 38 of the comparisons emerged from trying to insert/hash each string into the table.
    Since most of the used LinkedList objects will contain only one string, some will have more than one string, and some will be empty, the number of comparison is not as terrible as with Test 2 and Test 3, but uses some more string insertion operations compared to Test 1.
    Compared do the hypothetical theoretical efficiency numbers from the pdf, this test input performed drastically faster than from the pdf.
    Most of the Hash function value indexes calculated will occur once, while some will occur 2-3 times, as such Test 4 is the second-best efficiency class compared to the other tests, when the input text contains 26 strings.

Test 5:
    Using the fifth test string as an example, the input of strings contained 352 words not counting the empty strings where a vast majority of them would have to be hashed to the same ArrayList index.
    From testing the string with the program, the total number of possible comparisons made is 5185, where the total calculated number of occurrences for the words that made up the input string is 352, which is the size of the string array.
    The Number of comparisons that occurred whenever a string was being inserted into the table took around 4833 comparisons for insertion.
    For this test, the number of strings in the input consisted of a paragraph of sentences, which would increase the comparisons necessary to insert a string wherever appropriate.
    Compared to the hypothetical theoretical efficiency numbers from the pdf, the number of comparisons conducted by the program was less than the hypothetical value, and were close to each other.
    For this particular input, there would be repeat calculations of Hash table index values, making the LinkedList stored at each individual cell contain at least 1 string in the overflow area if there were strings that contained a particular character.
    Compared to the other test inputs, test 5 had the worst efficiency class dependent upon the number of strings attempting to be hashed to the table and the number of words that began with the same letter.




*/
/********** Implementation Section **********/





import java.util.*;

public class DynamicHashing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // The Dynamic Hash table being used could be an ArrayList that holds LinkedList objects, each LinkedList object will contain strings that begin with the first character of that string.
        // The hash function will be referring to the LinkedList object that exists at the ArrayList's index.
        ArrayList<LinkedList<String>> myList = new ArrayList<>();
        String[] TextArray = new String[0];
        ArrayList<Integer> NumOfOccurrences = new ArrayList<>();
        int menuChoice;
        int numOfComparisons = 0;
        String word;
        String word2 = "";
        do{
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read input text");
            System.out.println("2. Hash Input Text to Hash Table");
            System.out.println("3. Display Words and Occurrences");
            System.out.println("4. Display Efficiency Outputs");
            System.out.println("5. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            menuChoice=Integer.parseInt(input.nextLine());
            switch(menuChoice){
                case 1:
                    // The test inputs being tested out would have to be more than one word inputs, so that it allows for each test case to be investigated separately. The input string can then be divided into an array of Strings where the regex is: " ", allowing each word to be hashed by the beginning character.
                    // Since duplicate words are allowed and the order of hashed elements does not matter, each List of strings do not need to be sorted.
                    System.out.println("Enter input text to be hashed.");
                   word2= word = input.nextLine();
                    word= word.toLowerCase();
                    // If the input string entered by the user contained a set of words for testing, then it can be assumed that the words that made up the string expression were being hashed into the table without just hashing one word at a time.
                    // With that in mind, the original string can be split by using the " " as a regex, so that all strings of more than one length are considered.
                    TextArray = word.split(" ");
                    System.out.println("Input text has now been read.");
                    break;
                case 2:
                    myList = new ArrayList<>();
                    for(int i=0; i<26; i++){
                        myList.add(new LinkedList<>());
                    }
                    // For each string in the array, it can be possible to hash each word into the "table " letting the hash function be the ASCII value of the first character but all lowercase.
                    // The total number of "words" attempting to be hashed could be the size of the split array.
                    numOfComparisons=0;
                    for (String s : TextArray) {
                        int Times = 0;
                        String tempWord = s;
                        // The conditional statement below is used to avoid a case where an empty string is trying to be hashed, as the length of an empty string is zero, when testing the last set of inputs, an issue like this occured.
                        if (tempWord.isEmpty()) {
                            continue;
                        }
                        // Calculate the Hash Function for a word by using the first character and modding it by 26 to get an index.
                        int temp1 = tempWord.charAt(0);
                        int HKeyIndex = temp1 % 26;
                        // The small do-while loop below will be able to count the number of comparisons the current input string being hashed to the specific index is causing. It can also be used to check the current size of the List until it is possible to add a string to that list.
                        // Every hashed string is added to the end of the current LinkedList object, as such the number of comparisons will increment until an empty slot is found, so that the word can then be hashed into the overflow area.
                        do {
                            numOfComparisons++;
                            Times++;
                        } while (Times < myList.get(HKeyIndex).size());
                        myList.get(HKeyIndex).add(tempWord);
                    }
                    System.out.println("Input text has been hashed.");
                    break;
                case 3:
                    // Using two separate ArrayList objects to store the current word and its number of occurrences within the hash table of LinkedLists
                    ArrayList<String> UsedWords = new ArrayList<>();
                    NumOfOccurrences = new ArrayList<>();
                    // Outer for loop iterates through the ArrayLists.
                    for(int i=0; i<myList.size(); i++){
                        // Inner loop will iterate through each LinkedList contained in the arrayList index, at which point the strings of that LinkedList will be chekced.
                        if(!myList.get(i).isEmpty()){
                            for(int j=0; j<myList.get(i).size(); j++)
                            {
                                int tracker=0;
                                int numOfOccurrences=0;
                                String temp = myList.get(i).get(j);
                                // If the current word is not in the ArrayList, then it is not necessary to increment its occurrences again.
                                if(!UsedWords.contains(temp)){
                                    // the tracker variable will attempt to iterate over the LinkedList stored at that ArrayList index and be used to check if the current string is duplicated already.
                                    // The num of occurrences will look over that LinkedList and increment the
                                    // occurrence of that particular string.
                                    while(tracker < myList.get(i).size()){
                                        if(temp.equals(myList.get(i).get(tracker))){
                                            numOfOccurrences++;
                                        }
                                        tracker++;
                                    }
                                    // After keeping track of the current number of occurrences for a given word, the size of both of these arrayLists should be the same.
                                    UsedWords.add(temp);
                                    NumOfOccurrences.add(numOfOccurrences);
                                }
                            }
                        }
                    }
                    System.out.println("Key Word\t\tWord Count");
                    System.out.println("-----------------------");
                    for(int i=0; i< UsedWords.size() && i <NumOfOccurrences.size(); i++){
                        // formatting the sample outputs with the conditional statements below to make everything cleaner, though it is not necessary.
                        System.out.print(UsedWords.get(i));
                        if(UsedWords.get(i).length()<=3){
                            System.out.print("\t");
                        }
                        if(UsedWords.get(i).length() <=7){
                            System.out.print("\t");
                        }
                        if(UsedWords.get(i).length()>=12){
                            System.out.println("\t\t"+NumOfOccurrences.get(i));
                            continue;
                        }

                        System.out.println("\t\t\t"+NumOfOccurrences.get(i));
                    }
                    break;
                case 4:
                    // Input text that wasn't converted to lowercase will be printed here.
                    System.out.print("Input Values: ");
                    System.out.println(word2);
                    System.out.println("Inputs size: " + TextArray.length);
                    int totalSum=0;
                    // The total Number of occurrences of each word as well as the total number of comparisons necessary to insert the word are added up here.
                    // For the fourth menu option, both of these values will be useful to determine the total number of comparisons the algorithm has made when inserting words into the table.
                    for(int i : NumOfOccurrences){
                        totalSum+=i;
                    }

                    // The total number of comparisons that was attempted can be the total number of occurrences plus the comparisons made whenever hashing a word to the table.
                    System.out.println("Number of comparisons "+ (totalSum+ numOfComparisons));
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid menu option, please try again.");
            }
            System.out.println();
        }while (menuChoice!=5);


    }
}