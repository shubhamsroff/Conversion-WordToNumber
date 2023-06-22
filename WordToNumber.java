/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Scanner;
public class WordToNumber {

    public static int  getInput(String word) {
        String unitArray[] = {" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String tensArray[] = {" ", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String wordArray[] = word.split(" ");
        int number = 0;
        String k = "";
//        for (String c : wordArray) {
//            System.out.println(c);
//        }
        for (int i = 0; i < wordArray.length; i++) {
            for (int j = 0; j < unitArray.length; j++) {
                if (wordArray[i].equalsIgnoreCase("Million")) {
                    if (i >= 1) {
                        if (wordArray[i - 1].equalsIgnoreCase(unitArray[j])) {
                            number = number + (j * 1000000);
                        }
                    }
                }
                if (wordArray[i].equalsIgnoreCase("Lac")) {
                    if (i >= 1) {
                        if (wordArray[i - 1].equalsIgnoreCase(unitArray[j])) {
                            number = number + (j * 100000);
                        }
                    }
                }
                if (wordArray[i].equalsIgnoreCase("Thousands")) {
                    if (i >= 1) {
                        if (wordArray[i - 1].equalsIgnoreCase(unitArray[j])) {
                            number = number + (j * 1000);
                        }
                        if (j < 10) {
                            if (wordArray[i - 2].equalsIgnoreCase(tensArray[j])) {
//                                System.out.println((i - 2) + " " + j);
                                number = number + (j * 10000);
                            }
                        }
                    }
                }
                if (wordArray[i].equalsIgnoreCase("Hundred")) {
                    if (i >= 1) {
                        if (wordArray[i - 1].equalsIgnoreCase(unitArray[j])) {
                            number = number + (j * 100);
                        }
                    }             

                }
                if (j < 10) {
                    if (i == wordArray.length - 1) {
                        if (wordArray[i].equalsIgnoreCase(unitArray[j])) {
                            number = number + j;
                        }
                        if (wordArray[i - 1].equalsIgnoreCase(tensArray[j])) {
                            number = number + (j * 10);
                        }
                    }
                }

            }
        }
        return number;
    }
    public static  void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println(getInput(sc.nextLine()));
    }
}
