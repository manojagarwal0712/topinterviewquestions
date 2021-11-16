package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayTopInterview {

    /**
     * How to find all pairs on integer array whose sum is equal to given number?
     * <p>
     * Read more: https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html#ixzz66qRoTN8t
     */

    //It usage extra space hasset ,if not allowed to use xtra space.
    public static void findPairWithSumSol1(int arr[], int key) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int temp = key - arr[i];
            if (set.contains(temp)) {
                System.out.print(arr[i] + "," + temp);
            } else {
                set.add(arr[i]);
            }
            System.out.print("|");
        }
    }


    // in place solution.
    // sort the array
    //1) take 2 pointer one form left and another feom right
    // 2) check of arr[left] + arr[right] = sum
    // 3) print the pair, advance left and right
    // 4) if arr[left] + arr[right] < sum , then advance left pointer (as we have to increas the sum)
    // 5) if arr[left] + arr[right] > sum , then decreas right pointer (as we have to decreas the sum to get the pair)

    public static void findPairWithSumSol2(int arr[], int key) {
        // considring array is sorted

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] == key) {
                System.out.print(arr[left] + "," + arr[right]);
                left++;
                right--;
            } else if (arr[left] + arr[right] > key) {
                right--;
            } else {
                left++;
            }
            System.out.println();
        }
    }

    /*
    Write a program to remove duplicates from array in Java
     */
    //sol1 using collectiona and extra space
    public static void removeDupSol1(int arr[]) {
        Set<Integer> set = new LinkedHashSet<>();
        for (Integer a :
                arr) {
            set.add(a);
        }
        int temp[] = new int[set.size()];
        int index = 0;
        for (Integer a :
                set) {
            temp[index] = a;
            index++;
        }
        arr = temp;
        for (Integer a :
                arr) {
            System.out.println(a);
        }

    }

    /**
     * Union of 2 array means all the elements those are in Array-A and Array -B or both.
     */
    public static void findUnionOfTwoArray(int arr1[], int arr2[]) {
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                System.out.println(arr2[j]);
                j++;
            } else {
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            System.out.println(arr1[i]);
            i++;
        }
        while (j < arr2.length) {
            System.out.println(arr2[j]);
            j++;
        }
    }

    /**
     * Intersection is about common elements in both the array
     */
    public static void findIntersectionOfTwoArray(int arr1[], int arr2[]) {
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
    }

    /**
     * There is an array with every element repeated twice except one
     * 1) the solution is use hastable and find the element which has count 1
     * 2) second sol- use XOR, a) a number 6 ^6 = 0, 6^0=6. if we use XOR first element with
     * all other then we will get the dup number.
     */

    /*
        How to find kth smallest element in unsorted array
     */
    public static void kthSmallestElement(int[] arr, int n) {

    }

    /**
     * Combine 2 integer sorted array into a sorted output
     * (Eg array1 = [1,2,5], array 2 = [3,5,6], Expected output - [1,2,3,4,5,6])
     *
     *
     */
    public static void mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int arr[] = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            arr[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length) {
            arr[k] = arr2[j];
            k++;
            j++;
        }
        for (int a :
                arr) {
            System.out.println(a);
        }
    }

    /**
     * Given an array of integers, replace every number with the next higher number to its
     * right. If a number can’t be replaced, we leave it as-it is.
     * For example, the list: 5, 2, 1, 4, 6, 7 needs to be changed to 6, 4, 4, 6, 7, 7.
     */

    public static void replaceWithNexthire(int arr[]){
        int arrCopy[]=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            arrCopy[i]=arr[i];
        }
        Arrays.sort(arrCopy);
        for (int i =0;i<arr.length;i++){

        }
/// to be done.
    }


    public static void main(String[] args) {
        int arr[] = new int[]{1, 2};
        int arr2[] = new int[]{3, 5, 6,7};

        mergeTwoSortedArray(arr, arr2);
    }
}
