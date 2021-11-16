package com.array;

import java.util.HashSet;
import java.util.Set;

public class Arrays {


    /**
     * arr[] = 1,2,3,4,5,6,7
     * output: arr[]= 3,4,5,6,7,1,2
     */
    public static void rotateArray(int arr[], int d){
        for (int i =0;i<d;i++){
            shiftByOne(arr);
        }
        for (int a:
             arr) {
            System.out.println(a);

        }
    }

    public static void shiftByOne(int arr[]){

        int indexLast = arr.length-1;
        int temp = arr[0];
        for (int i =0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[indexLast] = temp;
    }

    public static void rotateArrayReversalAlgo(int arr[], int d){
        reverseArray(arr,0,d-1);
        reverseArray(arr,d,arr.length-1);
        reverseArray(arr,0,arr.length-1);
        for (int a:
                arr) {
            System.out.println(a);

        }
    }

    public static void reverseArray(int []arr, int start, int end){

        while (start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * in binary search array will be sorted
     *
     * @param arr
     * @param key
     */
    public static int binarySearch(int arr[],int start, int end, int key){

        if (end >= start) {
            int mid = start + (end - start) / 2;

            if (key == arr[mid])
                return mid;
            if (key > arr[mid])
                return binarySearch(arr, mid + 1, end, key);
            if (key < arr[mid])
                return binarySearch(arr, start, mid - 1, key);
        }
        return -1;
    }

    /**
     * Search an element in a sorted and rotated array
     * arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
     * key = 3
     * Output : Found at index 8
     *
     *
     */

    public static int searchInSortedRotatedArray(int arr[], int start, int end, int key){

        int pivot = findPivot(arr);
        //if we dont find a pivot then array is not rotated at all
        if(pivot==-1)
            return binarySearch(arr,0,end-1,key);

        if(arr[pivot]==key)
            return pivot;
        if(arr[pivot]<=key)
            return binarySearch(arr,0,pivot-1,key);

        return binarySearch(arr,pivot+1,end-1,key);
    }

    public static int findPivot(int arr[]){
        for (int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1])
                return i+1;
        }
        return -1;

    }

    public static void rearrangeArray(int arr[]){
        Set<Integer> set = new HashSet<>();

        for (int i =0;i<arr.length;i++){
            set.add(arr[i]);
        }

        for (int i=0;i<arr.length;i++){
            if(set.contains(i)){
                arr[i] =i;
            }else{
                arr[i]=-1;
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void reverseArray(int arr[]){
        int start =0;
        int end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for (int a:
             arr) {
            System.out.println(a);
        }
    }

    /**
     * Given a phone number. Check whether it is unique or not
     *
     */

    public boolean checkPhoneUnique(int arr[]){

        int sum = 45;
        for (int i =0;i<10;i++){
            sum = sum-arr[i];
        }
        if (sum==0){
            return true;
        }
        return false;
    }

    public static void findBestFitBox(int arr[], int key){
        for (int i=0;i<arr.length;i++){
            int a = Math.min(arr[i],key);
            if (a>=key){
                System.out.println(arr[i]);
                return;
            }
        }
        System.out.println(-1);
    }


    public int maxSubArrayCubitTime(int[] nums) {

        int n = nums.length;
        int maximumSubArraySum = Integer.MIN_VALUE;

    /*
      We will use these outer 2 for loops to investigate all
      windows of the array.

      We plant at each 'left' value and explore every
      'right' value from that 'left' planting.
      These are our bounds for the window we will investigate.
    */
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {

        /*
          Let's investigate this window
        */
                int windowSum = 0;

        /*
          Add all items in the window
        */
                for (int k = left; k <= right; k++) {
                    windowSum += nums[k];
                }

        /*
          Did we beat the best sum seen so far?
        */
                maximumSubArraySum = Math.max(maximumSubArraySum, windowSum);

            }
        }

        return maximumSubArraySum;
    }
    /**
     *
     * https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/MaxContiguousSubarraySum/MaxContiguousSubarraySum.java
     *
     */

    public static int maxSubArray(int[] nums) {

    /*
      We default to say the the best maximum seen so far is the first
      element.
      We also default to say the the best max ending at the first element
      is...the first element. (this is because on Leetcode we must choose a
      subarray of at least one item, we cannot choose nothing)
    */
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

    /*
      We will investigate the rest of the items in the array from index
      1 onward.
    */
        for (int i = 1; i < nums.length; i++){

      /*
        We are inspecting the item at index i.
        We want to answer the question:
        "What is the Max Contiguous Subarray Sum we can achieve ending at index i?"
        We have 2 choices:
        maxEndingHere + nums[i] (extend the previous subarray best whatever it was)
          1.) Let the item we are sitting at contribute to this best max we achieved
          ending at index i - 1.
        nums[i] (start and end at this index)
          2.) Just take the item we are sitting at's value.
        The max of these 2 choices will be the best answer to the Max Contiguous
        Subarray Sum we can achieve for subarrays ending at index i.
        Example:
        index     0  1   2  3   4  5  6   7  8
        Input: [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]
                 -2, 1, -2, 4,  3, 5, 6,  1, 5    'maxEndingHere' at each point

        The best subarrays we would take if we took them:
          ending at index 0: [ -2 ]           (snippet from index 0 to index 0)
          ending at index 1: [ 1 ]            (snippet from index 1 to index 1) [we just took the item at index 1]
          ending at index 2: [ 1, -3 ]        (snippet from index 1 to index 2)
          ending at index 3: [ 4 ]            (snippet from index 3 to index 3) [we just took the item at index 3]
          ending at index 4: [ 4, -1 ]        (snippet from index 3 to index 4)
          ending at index 5: [ 4, -1, 2 ]     (snippet from index 3 to index 5)
          ending at index 6: [ 4, -1, 2, 1 ]  (snippet from index 3 to index 6)
          ending at index 7: [ 4, -1, 2, 1, -5 ]    (snippet from index 3 to index 7)
          ending at index 8: [ 4, -1, 2, 1, -5, 4 ] (snippet from index 3 to index 8)
        Notice how we are changing the end bound by 1 everytime.
      */
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);

      /*
        Did we beat the 'maxSoFar' with the 'maxEndingHere'?
      */
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static  void medianOfTwoSortedArray(int arr1[], int arr2[]){
        int i =0;
        int j =0;
        int k =0;
        int arr[] = new int[9];
        for (k=0;k<arr.length;k++){
            if (arr1[i]<arr2[j]){
                arr[k]=arr1[i];
                i++;
            }else {
                arr[k]=arr2[j];
                j++;
            }
        }
        int med= arr[arr1.length]+arr[arr1.length-1];
        System.out.println(med);

    }

    public static void main(String[] args) {
            int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};

        //System.out.println(searchInSortedRotatedArray(arr,0,arr.length-1,6));
        //reverseArray(arr);
        System.out.println(maxSubArray(arr));
        //medianOfTwoSortedArray(ar1,ar2);



    }
}
