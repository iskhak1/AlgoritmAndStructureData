package ru.gb;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        new Main().exercise12(in.nextInt(),in.nextInt());
        in.close();
        new Main().exercise3(100);
    }

    public void exercise12(int number, int rate){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        if(number==0){
            System.out.println("number must be grater then zero! number != 0 ");
            throw new NumberFormatException();
        }
        if(rate % 2 == 0 ){
            do{
               number = number*number;
               rate = rate/2;
            }while(rate!=1);

        }else {
            int helper = number;
            for (int i = 1; i < rate; i++) {
                number = number * helper;
            }
        }
        System.out.println(number);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

   public void exercise3(int i){
       System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
       System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        int sum = 0;
        while(i != 0){
//            System.out.println("i = " + i);
            sum = sum + i;
//            System.out.println("sum = "+sum);
            i--;
        }
       System.out.println(sum);
   }



}