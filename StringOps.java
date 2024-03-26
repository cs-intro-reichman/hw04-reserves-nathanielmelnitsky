public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String myString = "Hello World my name is nathaniel melnitsky";
        camelCase(myString);
        capVowelsLowRest(myString);

    }

    public static String capVowelsLowRest (String string) {
        String newString = "";

       //runs through string element by element
       for(int i = 0; i < string.length(); i++){
        char stringChar = (char) string.charAt(i);
        int val = (int) stringChar;

        //if space
        if(stringChar == ' '){
            newString = newString + " ";
            //System.out.println(newString);
            }
        //if char val is an upper case nonVowel
        else if(val <= 90 && val >= 66 && val != 69 && val != 73 && val != 79 && val != 85){
            //lowers it and adds to string
            val += 32;
            char newC = (char) val;
            newString += newC;
            //System.out.println(newString);
        }

        //if char is a lower case vowel
        else if(val == 97 || val == 101 || val == 105 || val == 111 || val == 117){
            //uppers it and adds to string
            val -= 32;
            char c = (char) val;
            newString += c;
            //System.out.println(newString);
        }
        else{
            newString += stringChar;
            //System.out.println(newString);
        }
       }
       //System.out.println(newString);
        return newString;
        
    }
    public static String camelCase(String stringg) {
        //adds an arbitrary word to the end of given string
        //because my program doesnt know how to deal with the last word
        //its easier than making a seperate case for the last word
        String string = stringg + " njkn";
        //we will add to this string
        String newString = "";
        //finds out num of words we need to deal with
        int words = numOfWords(string);

        //saves all the index of ' ', so we know where new words start
        int[] spaceIndex  = allIndexOf(string, ' ');

        //deal wiith first word seperately
        String firstWord = string.substring(0, spaceIndex[0]);
        String correctedFirtWord = lowerCaseWord(firstWord);
        //System.out.println(correctedFirtWord);
        newString += correctedFirtWord;

        //deal with rest of words except for last
        for(int i = 0; i < (words - 2); i++){
            //starts the word from the index of space +1 so it doesnt fall on the " " itself
            //on the upper bound we -1 so we dont end up landing on the space
            String newWord = string.substring((spaceIndex[i] + 1), (spaceIndex[i+1]));
            //System.out.println(newWord);
            String correctenNewWord = capsFirstLetter(newWord);
            newString += correctenNewWord;
        }
        //System.out.println(newString);
        return newString;
    }
    

    //intput is string and char
    //output: array with all indecies of the char
    public static int[] allIndexOf (String string, char chr) {
        //finds the number of occuerences and creates an array of that size
        int occurences = 0;
        
        for(int i = 0; i < string.length(); i++){
            char currentChar = (char) string.charAt(i);
            if(currentChar == chr){
                occurences += 1;
            }
        }
        //once we know the size of the array now we can find the index
        int[] indicies = new int[occurences];
        //var used to track which index of the array we want to upend to
        int instance = 0;

        for(int i = 0; i < string.length(); i++){
            char currentChar = (char) string.charAt(i);
            //if char is what we are looking for we uppend it in our new array
            if(currentChar == chr){
                indicies[instance] = i;
                instance++;
            }
        }
        //prints for testing purps
        /*  for(int i = 0; i < occurences; i++){
            System.out.print(indicies[i] + " ");
        } */
        return indicies;
    }

    //takes input in the form of a word without spaces or special chars
    // returns a word with first letter caps rest lower case
    public static String capsFirstLetter (String string){
        //new string we will fill
        String newString = "";

        //declares first letter
        char firstChar = string.charAt(0);
        int valFirstChar = (int) firstChar;

        //capitolizes first letter
        if(valFirstChar >= 97 && valFirstChar <= 122){
            char newFirstChar = (char) (valFirstChar - 32);
            newString += newFirstChar;
        }
        else{
            newString += firstChar;
        }

        //lower cases the rest of the chars
        //loops through letter by letter from index(1)
        for(int i = 1; i < string.length(); i++){
            char currentChar = string.charAt(i);
            int val = (int) currentChar;

            if(val >= 65 && val <= 90){
                char newChar = (char) (val + 32);
                newString += newChar;
            }
            //if the char is already lower case
            else{
                newString += currentChar;
            }
        }
       // System.out.println(newString);
        return newString;
    }

    //takes string of letters returns all lower case
    public static String lowerCaseWord (String string){
        //new string we will fill
        String newString = "";

        //lowercases all letters looping through
        for(int i = 0; i < string.length(); i++){
            char currentChar = string.charAt(i);
            int val = (int) currentChar;

            if(val >= 65 && val <= 90){
                char newChar = (char) (val + 32);
                newString += newChar;
            }
            //if the char is already lower case
            else{
                newString += currentChar;
            }
        }
        //System.out.println(newString);
        return newString;
    }

    //takes string (of letters and spaces) returns number of words
    //DANGER doesnt take into acount if the string starts or ends with a space
    public static int numOfWords (String string){
        int words = 1;

        //finds the number of words in the string
        //loops through chars in given string
        for(int i = 0; i < string.length(); i++){
            //if current char is " " then add to counter
            if(string.charAt(i) == ' '){
                words++; 
            }
        }
        //System.out.println(words);
        return words;
    }

}
