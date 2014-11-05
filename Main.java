package com.company;

import java.util.Scanner;

public class Main
{
    public static int fill_dreapta(int[][] Array,int x, int y, int k, int n)
    {
        int i;
        for(i = y; i<n && Array[x][i]==0; i++)
            Array[x][i] = ++k;

        return i-1;
    }

    public static int fill_stanga(int[][] Array,int x, int y, int k, int n)
    {
        int i;
        for(i = y; i>=0 && Array[x][i]==0; i--)
            Array[x][i] = ++k;

        return i+1;
    }

    public static int fill_sus(int[][] Array,int x, int y, int k, int n)
    {
        int i;
        for(i = x; i>=0 && Array[i][y]==0; i--)
            Array[i][y] = ++k;

        return i+1;
    }

    public static int fill_jos(int[][] Array,int x, int y, int k, int n)
    {
        int i;
        for(i = x; i<n && Array[i][y]==0; i++)
            Array[i][y] = ++k;

        return i-1;
    }

    public static void print_Array(int[][] Array, int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(Array[i][j] + " ");
            System.out.println();
        }


    }

    public static void main(String[] args)
    {
        int coord_X = 0, coord_Y = 0, curr_Index = 0, size_Array;
        int[][] myArray = new int[5][5];

        Scanner input = new Scanner(System.in);

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                myArray[i][j] = 0;

        System.out.println("Dimensiunea matricii(n):");
        size_Array = input.nextInt();

        while(curr_Index < size_Array * size_Array)
        {
            coord_Y = fill_dreapta(myArray,coord_X,coord_Y,curr_Index,size_Array);
            curr_Index = myArray[coord_X][coord_Y];
            coord_X++;

            coord_X = fill_jos(myArray,coord_X,coord_Y,curr_Index,size_Array);
            curr_Index = myArray[coord_X][coord_Y];
            coord_Y--;

            coord_Y = fill_stanga(myArray,coord_X,coord_Y,curr_Index,size_Array);
            curr_Index = myArray[coord_X][coord_Y];
            coord_X--;

            coord_X = fill_sus(myArray,coord_X,coord_Y,curr_Index,size_Array);
            curr_Index = myArray[coord_X][coord_Y];
            coord_Y++;

        }

        print_Array(myArray,size_Array);

    }
}
