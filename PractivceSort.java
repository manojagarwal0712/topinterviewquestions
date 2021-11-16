package com.sorting;

public class PractivceSort {

    public static int partition(int arr[], int start,int end){

        int pivot = arr[end];
        int i = start-1;

        for (int j=start;j<end-1;j++){
            if (arr[j]<=pivot){
                i++;
                //swap(arr[j],arr[i]);
            }
        }

        //swap(arr[i+1],arr[end]);
        return i+1;
    }
    public static void quickSort(int arr[], int start, int end){

        if (start<end){
            int q = partition(arr,start,end);
            quickSort(arr,start,q);
            quickSort(arr,q+1,end);
        }
    }

    public static void main(String[] args) {

    }
}
