package com.softkit.testapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>() {
            {
                add("11111");
                add("22222222");
                add("33333333");
                add("444");
                add("11");
                add("222");
                add("3333");
                add("4444444");
                add("11111111");
                add("222222");
                add("33333333");
                add("4");
                add("1");
                add("2222222222");
                add("3");
                add("44444444444444");
            }
        };

        int colsCount = 0;
        boolean valid = false;

        while (!valid) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String colsCountString = reader.readLine();
                colsCount = Integer.parseInt(colsCountString);
            } catch (Exception e) {
                System.out.println("Something went wrong...");
                continue;
            }

            if (colsCount > 0)
                valid = true;
            else
                System.out.println("Something went wrong...");
        }

        for (int i = 0; i < strings.size(); i++) {

            String currentString = strings.get(i);
            System.out.print(currentString);

            int longestElSize = 0;
            for (int j = 0; j <= strings.size() / colsCount; j++) {

                int index = i % colsCount + j * colsCount;
                if (index >= strings.size())
                    break;

                int elSize = strings.get(index).length();

                if (elSize > longestElSize) {
                    longestElSize = elSize;
                }
            }

            for (int j = 0; j < longestElSize - currentString.length(); j++) {
                System.out.print(" ");
            }

            if ((i + 1) % colsCount == 0) {
                System.out.print("\n");
            } else {
                System.out.print("\t");
            }
        }
    }
}