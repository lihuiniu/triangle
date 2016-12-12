package com.whale.venus;

import java.util.Arrays;
/**
 * Created by Whale on 12/10/2016.
 */
public class Triangle {
    static TriangleType getType(int a, int b, int c)
    {
        int[] array = {a, b ,c};
        if (array == null || array.length != 3){
            return TriangleType.ERROR;
        }
        Arrays.sort(array);
        int len = array.length;
        /**
        for (int i = 0; i < len; i++){
            System.out.println(array[i]);
        }
         */
        boolean isISOSCELES = array[0] == array[1];
        for (int i = 2; i < len; i++){
            if (array[i] <= 0){
                return TriangleType.ERROR;
            }
            if (array[i - 2] + array[i - 1] <= array[i]){
                return TriangleType.ERROR;
            }
            if (array[i] == array[i -1]){
                if (isISOSCELES){
                    return TriangleType.EQUILATERAL;
                } else {
                    isISOSCELES = true;
                }
            }
        }
        if (isISOSCELES){
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }

    static TriangleType isRegularPolygon(int[] array){
        if (array == null || array.length != 3){
            return TriangleType.ERROR;
        }
        Arrays.sort(array);
        int len = array.length;
        /**
         for (int i = 0; i < len; i++){
         System.out.println(array[i]);
         }
         */
        boolean isISOSCELES = array[0] == array[1];
        for (int i = 2; i < len; i++){
            if (array[i] <= 0){
                return TriangleType.ERROR;
            }
            if (array[i - 2] + array[i - 1] <= array[i]){
                return TriangleType.ERROR;
            }
             if (array[i] == array[i -1]){
                 if (isISOSCELES){
                     return TriangleType.EQUILATERAL;
                 } else {
                     isISOSCELES = true;
                 }
            }
        }
        if (isISOSCELES){
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }

    public static void main(String[] args)
    {
        System.out.println(" Input list value of (13,13,1) 's type is: "+ Triangle.getType(13, 13, 1));
        //System.out.println(" Input list value of (13,13,1) 's type is: "+ Triangle.getType(13, 13, 1).getN());

        System.out.println(" Input list value of (6,6,6) 's type is: "+ Triangle.getType(6, 6, 6));
        //System.out.println(" Input list value of (6,6,6) 's type is: "+ Triangle.getType(6, 6, 6).getN());

        System.out.println(" Input list value of (15,5,8) 's type is: "+ Triangle.getType(15, 5, 8));
        //System.out.println(" Input list value of (15,5,8) 's type is: "+ Triangle.getType(15, 5, 8).getN());

        System.out.println(" Input list value of (13,6,16) 's type is: "+ Triangle.getType(13, 6, 16));
        //System.out.println(" Input list value of (13,6,16) 's type is: "+ Triangle.getType(13, 6, 16).getN());

        System.out.println(" Input list value of (13,-6,16) 's type is: "+ Triangle.getType(13, -6, 16));
        //System.out.println(" Input list value of (13,-6,16) 's type is: "+ Triangle.getType(13, -6, 16).getN());

    }
}

enum TriangleType
{
    ISOSCELES(0),
    EQUILATERAL(1),
    SCALENE(2),
    ERROR(3);

    private int n;
    TriangleType(int n){
        this.n = n;
    }

    public int getN(){
        return n;
    }

    public void setN(int n){
        this.n = n;
    }
}

