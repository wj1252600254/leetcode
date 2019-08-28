package com.test;

import java.util.Scanner;

public class HuaWeiMoni {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] strings = a.split(" ");
        int first = Integer.valueOf(strings[0]);
        int second = Integer.valueOf(strings[1]);
        System.out.println(first + second);

    }


}
