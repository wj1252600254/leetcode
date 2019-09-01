package com.leetcode;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("%1$04d, %2$.3f %n", 1, Double.valueOf("3.131445"));
        System.out.println(stringBuilder.toString());
    }

    public void ss1() {

    }

    public void fff() {
        String a = "adadadf";
        Scanner scanner = new Scanner(a);
//        scanner.useDelimiter("d");
        Pattern pattern = Pattern.compile("\\w+");
        while (scanner.hasNext(pattern)) {
            System.out.println(scanner.next());
        }
    }
    public static void ff() {
        //先在常量池中找"11"
        //然后在堆中找"11"引用
        String a = new String("1") + new String("1");
//        String c = new String("11");
        a.intern();
        String b = "11";
        System.out.println(a == b);
        int[] arr = new int[2];
        int i = 0;
        arr[i++] = 100;
        System.out.println(Arrays.toString(arr));
    }

    public static void f() {
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("接受到了");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = bufferedInputStream.read(buff)) != -1) {
                    System.out.println(new String(buff, 0, len));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
