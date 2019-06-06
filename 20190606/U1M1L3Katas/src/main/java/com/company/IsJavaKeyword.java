package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a word to see if it's a Java keyword!");
        String javaKey = myScanner.nextLine().toLowerCase();

        if (javaKey.equals("abstract") ||
                javaKey.equals("assert") ||
                javaKey.equals("boolean") ||
                javaKey.equals("break") ||
                javaKey.equals("byte") ||
                javaKey.equals("case") ||
                javaKey.equals("char") ||
                javaKey.equals("class") ||
                javaKey.equals("continue") ||
                javaKey.equals("const") ||
                javaKey.equals("default") ||
                javaKey.equals("do") ||
                javaKey.equals("double") ||
                javaKey.equals("else") ||
                javaKey.equals("enum") ||
                javaKey.equals("extends") ||
                javaKey.equals("final") ||
                javaKey.equals("finally") ||
                javaKey.equals("float") ||
                javaKey.equals("for") ||
                javaKey.equals("goto") ||
                javaKey.equals("if") ||
                javaKey.equals("implements") ||
                javaKey.equals("import") ||
                javaKey.equals("instanceof") ||
                javaKey.equals("int") ||
                javaKey.equals("interface") ||
                javaKey.equals("long") ||
                javaKey.equals("native") ||
                javaKey.equals("new") ||
                javaKey.equals("package") ||
                javaKey.equals("private") ||
                javaKey.equals("protected") ||
                javaKey.equals("public") ||
                javaKey.equals("return") ||
                javaKey.equals("short") ||
                javaKey.equals("stack") ||
                javaKey.equals("strictfp") ||
                javaKey.equals("super") ||
                javaKey.equals("switch") ||
                javaKey.equals("synchronized") ||
                javaKey.equals("this") ||
                javaKey.equals("throw") ||
                javaKey.equals("throws") ||
                javaKey.equals("transient") ||
                javaKey.equals("try") ||
                javaKey.equals("void") ||
                javaKey.equals("volatile") ||
                javaKey.equals("while")) {
            System.out.println(javaKey + " is a Java keyword!");
        } else {
            System.out.println(javaKey + " is not a Java keyword");
        }
    }
}
