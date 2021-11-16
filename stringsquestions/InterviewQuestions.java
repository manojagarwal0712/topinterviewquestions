package stringsquestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class InterviewQuestions {

    /**
     * Maximum occurring character in an input string
     *Input: ”test sample”
     * Output: 't'
     * 
     *
     * Input:”test”
     * Output:'t'
     */

    public static char findMaxOccurChar(String str){
        //create map to keep the iterated char their count
        Map<Character,Integer> mapCharCount = new LinkedHashMap<>();

        //iterate thorugh all the char of string one by one
        for (int i=0; i< str.length(); i++){
            Character ch = str.charAt(i);

            //verify if the char is already exists in Map , if yes - then increment the count of char by one else
            // add the char to map with count 1.
            if(mapCharCount.containsKey(ch)){
                mapCharCount.put(ch,mapCharCount.get(ch)+1);
            }else {
                mapCharCount.put(ch,1);
            }
        }

        //iterate through the created Map and return the char with max count.
        int count =0;
        char ch = ' ';
        for (Map.Entry<Character,Integer> entries : mapCharCount.entrySet()) {
            if(entries.getValue()>count){
                ch=entries.getKey();
                count = entries.getValue();
            }
        }
        return ch;
    }
    
    public static String reverseStringEx1(String str) {
        String strRev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            strRev = strRev + str.charAt(i);
        }
        return strRev;
    }


    /**
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        return output;
    }

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * Input: 123
     * Output: 321
     *
     * test cases:
     * Check for -ve number e.g. -213
     * check max number 2,147,483,647
     *
     * Assume we are dealing with an environment which could only store integers within the 32-bit
     * signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0
     * when the reversed integer overflows.
     *
     */
    public static int reverseInt(int x) {

        int rev = 0;
        while (x != 0) {
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && (x % 10 > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && (x % 10 < -8)) {
                return 0;
            }
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev;
    }

    /**
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     * Input: 121
     * Output: true
     *
     * Input: -121
     * Output: false
     *
     * Input: 10
     * Output: false
     *
     * FUQ: Coud you solve it without converting the integer to a string?
     */
    public static boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }
        if(reverseInt(x)==x){
            return true;
        }
        return false;
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * Example 1:
     *
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */
    public static String longestCommonPrefix(String[] strs) {
        String longCommonPref = "";
        if(strs.length ==0 || strs==null){
            return longCommonPref;
        }
        int index =0;
        for (char ch: strs[0].toCharArray()) {

            for (int i=1; i< strs.length; i ++){
                if(index >=strs[i].length() || ch!=strs[i].charAt(index)){
                    return longCommonPref;
                }
            }
            longCommonPref += ch;
            index++;
        }

        return longCommonPref;
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * Input: "()"
     * Output: true
     *
     * Input: "()[]{}"
     * Output: true
     */
    public static boolean validParentheses(String str){
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (Character ch: str.toCharArray()) {
            if(hashMap.containsKey(ch)){
                hashMap.put(ch, hashMap.get(ch)+1);
            }else{
                hashMap.put(ch,1);
            }
        }
        for (Map.Entry<Character, Integer> entrySet: hashMap.entrySet()) {
            if(entrySet.getValue()%2>0){
                return false;
            }
        }
        return true;
    }

    public static void rearrangeString(String str){
        Stack<Character> stack = new Stack();
        String rearrangeStr ="";
        for (int i=0;i<str.length();i++){
            if(stack.isEmpty()){
                stack.push(str.charAt(i));
            }else{
                if(stack.peek()==str.charAt(i)){
                    stack.push(str.charAt(i));
                }else{
                    rearrangeStr = rearrangeStr+stack.pop() + ""+str.charAt(i);
                }
            }
        }
        if(stack.size()==1){
            System.out.println(rearrangeStr+stack.pop());
        }else{
            throw new IllegalArgumentException("Can not be rearranged");
        }
    }

    /**
     * K’th Non-repeating Character
     * https://www.geeksforgeeks.org/kth-non-repeating-character-python-using-list-comprehension-ordereddict/
     *
     *
     */

    public static void kthNonRepChar(String str, int k){
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character ch:
             str.toCharArray()) {
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for (Map.Entry<Character,Integer> entry:
             map.entrySet()) {

            if(entry.getValue()>1){
                continue;
            }else{
                if(k==1){
                    System.out.println(entry.getKey());
                    break;
                }else{
                    k--;
                }
            }

        }
    }
/**
 * Longest subsequence in a string with atleast k repeated char
 * https://www.geeksforgeeks.org/longest-subsequence-where-every-character-appears-at-least-k-times/
 *
 * Input : str = "geeksforgeeks"
 *          k = 2
 * Output : geeksgeeks
 * Every character in the output
 * subsequence appears at-least 2
 * times.
 *
 */

    public static void longestSubseqWithK(String str, int k){
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch:
             str.toCharArray()) {
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch,1);
        }

        for (Character ch:
             str.toCharArray()) {
            if(map.containsKey(ch))
                if(map.get(ch)>=k)
                    System.out.print(ch);
        }
    }

    /**
     * Given two strings, find if first string is a subsequence of second
     * https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
     * Input: str1 = "AXY", str2 = "ADXCPY"
     * Output: True (str1 is a subsequence of str2)
     *
     * Input: str1 = "AXY", str2 = "YADXCP"
     * Output: False (str1 is not a subsequence of str2)
     *
     */
    public static boolean isSubSequence(String str1, String str2){

        int index =0;
        for (int i =0; i<str1.length() && index<str2.length();i++){
            if(str1.charAt(i)==str2.charAt(index)){
                index++;
            }else {
                continue;
            }
        }

        if(index==str2.length()){
            return true;
        }

        return false;


    }

    /**
     * Sort an array of strings according to string lengths
     * https://www.geeksforgeeks.org/sort-array-strings-according-string-lengths/
     * Input : {"GeeksforGeeeks", "I", "from", "am"}
     * Output : I am from GeeksforGeeks
     *
     * Input :  {"You", "are", "beautiful", "looking"}
     * Output : You are looking beautiful
     *
     * @param str
     */
    public static void sortStringByLength(String str){
        SortedMap<String,Integer> map = new TreeMap<>();

    }

    public static void permutationOfString(char []input){
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch: input) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];

        int index =0;
        for (Map.Entry<Character,Integer> entry: countMap.entrySet()){
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char result[] = new char[input.length];
        permuteUtil(input, count,result,0);

    }

    public static void permuteUtil(char str[],int count[],char result[], int level) {

        // if level equal length of array
        if (level == result.length) {
            for (char ch:
                 result) {
                System.out.print(ch);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1);
            count[i]++; // restoring the count when reaching at the top.
        }
    }

    public static void findLongestCommonPrefix(String []str){

        String pref=null;

        for (int i =0;i<str.length;i++){
            String temp = str[i];;
            if (pref==null){
                pref=temp;
            }else {
                //find prefix between two string (exisintg pref and str[i])
                String tempPref="";
                for (int j =0;j<pref.length() && j<temp.length();j++){
                    if (pref.charAt(j)==temp.charAt(j)){
                        tempPref = tempPref+pref.charAt(j);
                    }else {
                        pref=tempPref;
                        break;
                    }
                }
            }
        }
        System.out.println(pref);
    }

    /**
     * Reverse a string without affecting special characters
     * https://www.geeksforgeeks.org/reverse-a-string-without-affecting-special-characters/
     * 1) Let input string be 'str[]' and length of string be 'n'
     * 2) l = 0, r = n-1
     * 3) While l is smaller than r, do following
     *     a) If str[l] is not an alphabetic character, do l++
     *     b) Else If str[r] is not an alphabetic character, do r--
     *     c) Else swap str[l] and str[r]
     *
     */

    public static void reverseWithoutAffectiveSpecial(char str[]){

        int i =0;
        int j = str.length-1;
        while (i<j){
            if (!Character.isAlphabetic(str[i])){
                i++;
            }
            else if (!Character.isAlphabetic(str[j])){
                j--;
            }
            else {
                char temp= str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
        }
        for (int k =0;k<str.length;k++){
            System.out.println(str[k]);
        }
    }

    /**
     * Given a string, print all possible palindromic partitions
     * https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
     */
    public static void givenStirngFindAllPossiblePartition(String str){

    }

    /**
     * Maximum number of characters between any two same character in a string
     * https://www.geeksforgeeks.org/maximum-number-characters-two-character-string/
     * 1) Use two nested loops. The outer loop picks character from left to right,
     * the inner loop finds farthest occurrence and keeps track of maximum.
     *
     */
    public static int maximumChars(String str){

        int res=-1;

        for (int i =0;i<str.length();i++){
            for (int j=i+1;j<str.length();j++){

                if (str.charAt(i)==str.charAt(j)){
                    res = Math.max(res, Math.abs(j-i-1));
                }
            }
        }
        return res;
    }

    /**
     * https://www.geeksforgeeks.org/check-whether-second-string-can-formed-first-string-using-count-array/
     * Check whether second string can be formed from characters of first string
     * Input : str1 = geekforgeeks, str2 = geeks
     * Output : Yes
     * Input : str1 = geekforgeeks, str2 = and
     * Output :  No
     *1) The idea is to count frequencies of characters of str1 in a count array.
     * 2) Then traverse str2 and decrease frequency of characters of str2 in the count array.
     * If frequency of a characters becomes negative at any point, return false.
     */

    public static void canMakeStr2(String str1, String str2){

    }

    public static void longPal(String str){

        String longPal = "";

        for (int i =0;i<str.length();i++){
            for (int j =i;j<str.length()-1;j++){
                if (longPal.length()< str.substring(i,j).length() && reverseStringEx1(str.substring(i,j)).equalsIgnoreCase(str.substring(i,j))){
                    longPal = str.substring(i,j);
                }
            }
        }
        System.out.println(longPal);
    }

    /**
     * The time complexity can be reduced by storing results of subproblems.
     * The idea is similar to this post. We maintain a boolean table[n][n] that is filled in
     * bottom up manner. The value of table[i][j] is true, if the substring is palindrome,
     * otherwise false. To calculate table[i][j],
     * we first check the value of table[i+1][j-1], if the value is true and str[i] is same as
     * str[j], then we make table[i][j] true. Otherwise, the value of table[i][j] is made false.
     * @param str
     */
    public static void longPalSol(String str){
        int n = str.length();   // get length of input string
        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true

        boolean table [][] = new boolean[n][n];

        int maxLength=1;

        //all substring of lenght 1
        for (int i =0;i<n;i++){
            table[i][i] = true;
        }

        //check for substring of length 2
        int start=0;
        for (int i =0;i<n-1;i++){
            if (str.charAt(i)==str.charAt(i+1)){
                table[i][i+1] = true;
                start =i;
                maxLength =2;
            }
        }
        //check substring of lenght greater then 2
        for (int k=3; k<n;k++){
            //fix starting index
            for (int i=0;i<n-k+1;i++){
                // Get the ending index of substring from
                // starting index i and length k
                int j = i+k-1;
                if (table[i+1][j-1] && str.charAt(i)==str.charAt(j)){
                    table[i][j] = true;
                    if (k>maxLength){
                        maxLength=k;
                        start=i;
                    }
                }

            }
        }

        System.out.println(str.substring(start,start+maxLength-1));
    }

    public static void maxOccChar(String str){
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i =0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }

        System.out.println(map);

        int max = Integer.MIN_VALUE;
        char ch ='#';
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue()>max){
                max = entry.getValue();
                ch = entry.getKey();
            }
        }
        System.out.println(ch+"-"+max);
    }

    /**
     * How to remove all duplicates from a given string?
     * ### Write in place removal of dup
     */
    public static void removDup(String str){
        Set<Character> set = new LinkedHashSet<>();
        for (Character ch:
             str.toCharArray()) {
            set.add(ch);
        }
        String temp ="";
        for (Character ch:
             set) {
            temp = temp+ch;
        }
        str = temp;
        System.out.println(str);
    }

    /**
     * How to print the duplicate characters from the given String?
     *
     */
    public  static void printDup(String str){
        //Take Linked HasMap and in last print the elemets having more then 1 char as those wouod be
        //duplicates
    }

    /**
     * How to remove characters from the first String which are present in the second String?
     *
     *
     */
    public static void removeCharFromFristString(String str1, String str2){
       Queue<Character> queue = new LinkedList<>();
       String temp ="";
        for (Character ch:
             str1.toCharArray()) {
            queue.add(ch);
        }
        while (!queue.isEmpty()){
            Character ch = queue.remove();
            if(!str2.contains(""+Character.toLowerCase(ch))){
                temp = temp+ch;
            }
        }
        System.out.println(temp);
    }

    /**
     * How to check if two strings are rotations of each other?
     *
     * str1= "XYZ", str2="YXZ"
     *
     * **** Warning: while this is complex solution. The easy solition is to
     * add the string1 to it self (XYZXYZ) now check if str2 exist in concatenated string. then
     * rotation exist.
     *
     */
    public static boolean checkTwoStringAreRotation(String str1, String str2) {
        //Rotate the original string by one and compare with the rotated string if equals then
        //return true or else false. do this till the length of str1
        char ch[] = str1.toCharArray();
        if(str1.equalsIgnoreCase(str2)){
            return false;
        }
        for (int i =0;i<ch.length;i++){
            char temp[] = rotatebyOne(ch);
            //verify if the 2 array are same then return true or after the loop it will return false
        }
        return false;
    }
    public static char[] rotatebyOne(char ch[]){
        char temp = ch[0];
        for (int i =0;i<ch.length-1;i++){
            ch[i] = ch[i+1];
        }
        ch[ch.length-1]=temp;
        return ch;
    }

    /**
     * How to find the first non-repeating character in a given String?
     *
     *
     */
    public static void firstNonRepChar(String str){
        // take LinkedHaspMap and keep all the element in it.
        // now find the key with value 1 and that would be first onn -rep char
    }

    /**
     * How to find the smallest substring in a given string containing all characters of another string?
     *
     *
     * Str1:"this is a test string" and str2="tist"
     * output: "t stri"
     */
    public static String findminWindowString(String searchString, String t){

        //map of charachters that we need to match
        Map<Character, Integer> requiredCharacters = new HashMap<>();
        for (int i =0;i<t.length();i++){
            int occurrencesOfCharacter = requiredCharacters.getOrDefault(t.charAt(i),0);
            requiredCharacters.put(t.charAt(i),occurrencesOfCharacter+1);
        }

        /*
    For our window. Map all characters in the window to their occurrence count. You
    will see how we use this below.
  */
        Map<Character, Integer> windowCharacterMapping = new HashMap<Character, Integer>();
        //2 pointers. Left holds the left index of the window we are inspecting and right
        //holds the right index.
        int left =0;
        int right =0;

        int totalCharFrequenciesToMatch = requiredCharacters.size();
        /*
        'totalCharFrequenciesToMatch' is the total characters we need to match frequency for
    in the window. If I have 1 'a' in my window and I need 2 'a' chars...then the char
    frequencies don't match.

    'charFrequenciesInWindowThatMatch' is the count of frequencies that we have satisfied.

       When 'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then it can be
    said that the current window satisfies that property of having all characters with matching
    counts to the string t.

       */

        totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        /*
        We will keep track of the best window we have seen so far
         */
        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        while (right<searchString.length()){

            /*
      Add the character on the right pointer to the hashtable that maps the characters seen
      in the window to their occurrence count
    */
            char characterAtRightPointer = searchString.charAt(right);

            //addCharacterToHashtableMapping();
            int occurrences = windowCharacterMapping.getOrDefault(characterAtRightPointer, 0);
            windowCharacterMapping.put(characterAtRightPointer, occurrences + 1);
            /*
            Is this character part of the requirement?
           */
            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsARequirement) {
                /*
                Does the current window frequency match the required frequency?
                */
                boolean requirementForCharacterMet= requiredCharacters.get(characterAtRightPointer).intValue()
                        == windowCharacterMapping.get(characterAtRightPointer).intValue();

                if (requirementForCharacterMet) {
                    /*
          If so then we have one more frequency requirement that matches...remember when:
          'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then we know that
          we have a satisfying window
        */
                    charFrequenciesInWindowThatMatch++;
                }
            }

             /*
      Does this window satisfy? Ok...if it does try contracting the left pointer inward until
      we go over the right pointer.
    */
            while (charFrequenciesInWindowThatMatch==totalCharFrequenciesToMatch && left<=right){
            /*
        Put these things in plain English so you don't get confused
      */
                char characterAtLeftPointer = searchString.charAt(left);
                int windowSize = right - left + 1;
            /*
        Have we beat the best satisfiable window seen so far? Ok...if so then update
        the tracking variables
      */
                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;;
                    minWindow = searchString.substring(left, right + 1);
                }
            /*
        This character will get contracted out. It won't be in the window anymore once
        left moves forward.
      */
                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);
              /*
        Was this character part of the requirement? If so then its frequency changing matters to us.
      */
              /*
        Was this character part of the requirement? If so then its frequency changing matters to us.
      */
              boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    /*
          Does the character frequence count not fall below the threshold of satisfying?
        */
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer).intValue() <
                            requiredCharacters.get(characterAtLeftPointer).intValue();
                    if (characterFailsRequirement) {
          /*
            If so then we have one less character frequency mapping in the window that matches
          */
                        charFrequenciesInWindowThatMatch--;
                    }
                    /*
        Move the left point forward. We will keep going until the window no longer satisfies.
      */
                    left++;
                }
                /*
      We have moved left as far as it could go. It either led to a window that no longer
      satisfied or left passed the right pointer. Either way...advance the right pointer.
    */
                right++;


            }

        }

        return minWindow;
    }

    /**
     * How to check if two given String is the anagram of each other?
     * Note: An anagram contains are of the same length and contains the same character,
     * but in a different order, for example, "Army" and "Mary" is the anagram.
     *
     *
     */
    public static boolean findTwoStringAreAnagram(String str1, String str2){
        Map<Character,Integer> map = new HashMap<>();
        for (Character ch:
             str1.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.println(map);
        for (Character ch:
                str2.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (Map.Entry<Character,Integer> entry:
             map.entrySet()) {
            if(entry.getValue()%2!=0){
                return false;
            }
        }
        return true;

    }

    /**
     * How do you remove all occurance of a given character from String?
     *
     */
    public static String removeACharFromString(String str, char ch){

        if(str==null)
            return null;

        String temp ="";
        for (int i =0;i<str.length();i++){
            if(str.charAt(i)!=ch){
                temp += str.charAt(i);
            }
        }
        return temp;
    }

}
