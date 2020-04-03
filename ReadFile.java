package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ReadFile {
    // Function for calculating median
    public static double Medianfiner(ArrayList<Integer> list) {
        int n = list.size();
        // 1 2 3 4 5
        // check for even case
        if (n % 2 != 0)
            return list.get(n/2);
        // 1 2 3 4 5 6
//        (3 + 4) / 2
        return (list.get((n-1)/2) + list.get(n/2))/2.0;
    }

    public static String getString(Double value) {      // get value with string
        String str = "Your median is: " + value;        // create String variable with (Double type) value
        return str;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("numbers.txt"));
        Writer  output = new FileWriter("output.txt");

        ArrayList<Integer> list = new ArrayList<>(); // create a Integer type ArrayList
        while(scan.hasNextInt()) {      // add new line numbers until the nextline is empty
            list.add(scan.nextInt());
        }
        System.out.println(list);
        // list has all the integers

        //ArraySort(list);
        Collections.sort(list);     // use sort function
        System.out.println("Sorted list: "+ list);   // print sorted list

        Double median = Medianfiner(list);      // get median as Double type
        output.write(getString(median));        // write the medians on the output.txt
        scan.close();                           // close scanner
        output.close();                         // close output.txt file.
    }
}