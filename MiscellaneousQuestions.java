package com.miscellaneous;

import java.util.*;

public class MiscellaneousQuestions {

    class Interval implements Comparator<int []> {

        @Override
        public int compare(int []a, int []b) {
            return a[0]-b[0];
        }

        boolean overlap(int[]a, int []b){
            int front = Math.max(a[0],b[0]);
            int back = Math.min(a[1],b[1]);
            return (back-front)>0 ? true:false;
        }

        int[][] mergeInt(int[][] interval){
            Arrays.sort(interval, new Interval());
            Stack<int[]> stake = new Stack<>();
            stake.push(interval[0]);
            for (int i=1;i<interval.length;i++){
                if(overlap(stake.peek(),interval[i])){
                    int[] t = stake.pop();
                    t[1] = Math.max(t[1],interval[i][1]);
                    stake.push(t);

                }
                stake.push(interval[i]);
            }

            int[][] res = new int[stake.size()][2];
            for (int i =res.length-1; i>=0; i--){
                res[i] = stake.pop();
            }
            return res;
        }
    }

    /**
     * Given a non-negative number represented as an array of digits,
     *
     * add 1 to the number ( increment the number represented by the digits ).
     * If the vector has [1, 2, 3]
     *
     * the returned vector should be [1, 2, 4]
     *
     * as 123 + 1 = 124.
     *
     * @param arrayList
     */
    public static void plusOne(Vector<Integer> arrayList) {
        int size = arrayList.size();
        //add 1 to the last digit
        arrayList.set(size-1, arrayList.get(size-1)+1);
        int carry = arrayList.get(size-1)/10;
        arrayList.set(size-1, arrayList.get(size-1)%10);

        for (int i=size-2; i>=0;i--){
            if(carry==1){
                arrayList.set(i, arrayList.get(i)+1);
                carry = arrayList.get(i)/10;
                arrayList.set(i,arrayList.get(i)%10);
            }
        }
        if(carry==1){
            arrayList.add(0,1);
        }

        int i = 0;
        //remove zeroes at the front
        while (i < arrayList.size() - 1 && arrayList.get(i) == 0) {
            arrayList.remove(i);
        }
    }

    /*public static int maximumGap(final List<Integer> list) {
        int max = 0;
        for (int i =0; i < list.size();i++){
            for (int j =1; j< list.size();j++){
                if(list.get(i)<=list.get(j) && max<j-i){
                    max=j-i;
                }
            }
        }
        return max;
    }*/

    /**
     * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in
     * linear time using less than O(n) space and traversing the stream sequentially O(1) times.
     *Input: [3 4 1 4 1]
     * OutPut: 1
     * If there are multiple possible answers ( like in the sample case above ), output any one.
     *
     * If there is no duplicate, output -1
     * @param list
     * @return
     */
    public static int repeatedNumber(final List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        if(list==null)
            return -1;
        for (int i =0; i<list.size(); i++){
            if(set.contains(list.get(i))){
                return list.get(i);
            }
            else {
                set.add(list.get(i));
            }
        }
        return -1;
    }

    public static int maximumGap(final List<Integer> list) {
        if(list.size()<2 || list==null){
            return 0;
        }
        int diff =0;
        for (int i=0;i<list.size()-1;i++){
            if(list.get(i)-list.get(i+1)>diff){
                diff =list.get(i)-list.get(i+1);
            }
        }
        return diff;
    }

    public static  int firstMissingPositive(ArrayList<Integer> arrayList) {

        Set<Integer> set = new HashSet<>();

        for (int i=0; i<arrayList.size();i++){
            if(arrayList.get(i)>0){
                set.add(arrayList.get(i));
            }
        }
        for (int i=1;i<arrayList.size();i++){
            if (!set.contains(i))
                return i;
            else
                continue;
        }
        return 0;
    }

    public static  boolean  alphaNumeric(char ch)
    {
        if( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int isPalindrome(String str) {
        if(str==null)
            return 0;

        String strRev="";
        int index =0;
        String strOrg="";
        for (int i=str.length()-1;i>=0;i--){
            if(alphaNumeric(str.charAt(i)))
                strRev = strRev+str.charAt(i);

        }
        for (int i=0;i<str.length();i++){
            if(alphaNumeric(str.charAt(i)))
                strOrg = strOrg+str.charAt(i);
        }
        if(strOrg.equalsIgnoreCase(strRev))
            return 1;

        return 0;

    }


    public static void main(String[] args) {
        /*Vector<Integer> vect=new Vector<>();
        vect.add(0);
        plusOne(vect);*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(isPalindrome(null));

    }

}
