package com.metrix;

public class Matrixs {

    public static void transPoseOfMatrix(int arr[][], int row, int col){
        for (int i =0; i< row;i++) {
            for (int j = 0; j < col; j++) {

                if (i < j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }

    }

    public static void printTwoDmatrcx(int arr[][],int row, int col){
        for (int i =0; i< row;i++){
            for (int j =0; j<col;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * https://www.youtube.com/watch?v=V9dZ-qqCLmc
     *
     * @param arr
     * @param row
     * @param col
     */
    public static void rotateBy90Degree(int arr[][], int row, int col){

        // fid transpose ofa matrix and then interchange the columns
        transPoseOfMatrix(arr,row,col);

        for (int i=0;i<row;i++){
            for (int j=0;j<col/2;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][col-1-j];
                arr[i][col-1-j] = temp;
            }
        }
        printTwoDmatrcx(arr,row,col);

    }

    public static void printSpiral(int arr[][], int row, int col){

        int rowBeg =0;
        int colBeg =0;
        row = row-1;
        col = col-1;

        while (rowBeg<=row && colBeg<=col){

            for (int i=colBeg; i<col;i++){
                System.out.print(arr[rowBeg][i]);
            }
            System.out.println();
            rowBeg++;

            for (int j=rowBeg;j<row;j++){
                System.out.print(arr[j][col]);
            }
            System.out.println();
            col--;

            if(rowBeg<=row){
                for (int i=col; i>colBeg;i--){
                    System.out.print(arr[col][row]);
                }
                col--;
            }


        }

    }

    public void transpose(int arr[][], int m, int n){

        for (int i =0;i<n;i++){
            for (int j =i;j<m;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }
        reverseColumn(arr,n,m);
        for (int i =0;i<n;i++){
            for (int j =0;j<m;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    public void reverseColumn(int arr[][], int n, int m){

        for (int i =0;i<n/2;i++){
            for (int j =0;j<m;j++){
                int temp =arr[i][j];
                arr[i][j]= arr[n-i-1][j];
                arr[n-i-1][j] = temp;
            }
        }
        /*for (int i =0;i<n;i++){
            for (int j =0;j<m;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

    }


    static int ROW=0; // its size of 2D arrray m
    static int COL =0; // its size of 2D array n

    public static boolean isSafe(int arr[][], int col, int row, boolean isVisted[][]){

        if (row>0 && row<ROW && col>0 && col<COL && !isVisted[row][col]){
            return true;
        }
        return false;
    }

    public static void DFS(int arr[][], int row, int col, boolean isVisited[][]){

        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell

        int rowNbr[] = new int[]{1,0,1,0,-1,-1,1,-1};
        int colNbr[] = new int[]{0,1,1,-1,0,-1,-1,1};
        isVisited[row][col] = true;

        //recur for all connected neighbours
        for (int k =0;k<8;k++){
            if (isSafe(arr,row+rowNbr[k],col+colNbr[k],isVisited)){
                DFS(arr,row+rowNbr[k],col+colNbr[k],isVisited);
            }
        }
    }

    public static void findIsland(int arr[][], int m, int n){
        int count=0;
        boolean isVisited[][] = new boolean[m][n];
        for (int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                if (arr[i][j]==1 && !isVisited[i][j]){
                    DFS(arr,i,j,isVisited);
                    count++;
                }
            }
        }
    }

    /**
     * Find row number of a binary matrix having maximum number of 1s
     *
     */

    public static void findMaxOne(int arr[][], int m, int n){

        int rowNbr=-1;
        int maxcount =-1;

        for (int i =0;i<m;i++){
            int count=0;
            for (int j=0;j<n;j++){
                if (arr[i][j]==1){
                    count++;
                }
            }

            if (count>maxcount){
                maxcount=count;
                rowNbr = i;
            }
        }
        System.out.println(rowNbr +" - "+ maxcount);
    }
    public static void main(String[] args) {
        Matrixs matrixs = new Matrixs();

        int arr[][] = { { 0, 0, 1},
                        { 0, 1, 1},
                        { 0, 0, 0} };
        //rotateBy90Degree(arr, 3,3);
        //matrixs.transpose(arr,3,3);
        matrixs.findMaxOne(arr,3,3);
    }
}
