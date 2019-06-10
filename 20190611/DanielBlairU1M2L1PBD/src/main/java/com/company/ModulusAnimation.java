package com.company;

public class ModulusAnimation {
    public static void main(String[] args) throws Exception {
        int length = 10;
        for (int i = 0; i < length * 5; i++) {
            if (i % length == 0)
                System.out.print(" d \r");
            else if (i % length == 1)
                System.out.print(" da \r");
            else if (i % length == 2)
                System.out.print(" dan \r");
            else if (i % length == 3)
                System.out.print(" Dan \r");
            else if (i % length == 4)
                System.out.print(" Dan b \r");
            else if (i % length == 5)
                System.out.print(" Dan bl \r");
            else if (i % length == 6)
                System.out.print(" Dan bla \r");
            else if (i % length == 7)
                System.out.print(" Dan blai \r");
            else if (i % length == 8)
                System.out.print(" Dan blair \r");
            else if (i % length == 9)
                System.out.print(" Dan Blair \r");

            Thread.sleep(300);
        }

    }
}
