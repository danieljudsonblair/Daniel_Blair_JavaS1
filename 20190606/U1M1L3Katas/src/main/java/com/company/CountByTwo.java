
package com.company;


import java.util.Scanner;

        public class CountByTwo {
            public static void main(String[] args) {
                Scanner myscanner = new Scanner(System.in);
                System.out.println("Please Enter a number");
                int num= Integer.parseInt(myscanner.nextLine());
                for(int i=0; i<=num ; i = i + 2){
                    System.out.println(i + "\r");
                }
            }
        }


