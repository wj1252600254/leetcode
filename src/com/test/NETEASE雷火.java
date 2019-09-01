package com.test;


import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class NETEASE雷火 {
    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(5.0/3));
    }


    public static void q1() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int n = Integer.valueOf(strings[0]);
        int m = Integer.valueOf(strings[1]);
        ArrayList<int[]> queue = new ArrayList<>();
        int x, y, w, h, cnt = 0;
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            x = Integer.valueOf(s[0]);
            y = Integer.valueOf(s[1]);
            w = Integer.valueOf(s[2]);
            h = Integer.valueOf(s[3]);
            cnt++;
            queue.add(new int[]{cnt,x, x + w, y, y + h});
        }
        for (int i = 0; i < m; i++) {
            String[] s = scanner.nextLine().split(" ");
            int xi = Integer.valueOf(s[0]);
            int yi = Integer.valueOf(s[1]);
            if (i != m - 1) {
                System.out.println(find(queue, xi, yi, n));
            } else {
                System.out.print(find(queue, xi, yi, n ));
            }

        }
    }

    private static int find(ArrayList<int[]> queue, int x, int y, int len) {
        for (int i = len - 1; i >= 0; i++) {
            int[] a = queue.get(i);
            if (x >= a[1] && x <= a[2] && y >= a[3] && y <= a[4]) {
                int[] remove = queue.remove(i);
                queue.add(remove);
                return remove[0];
            }
        }
        return -1;
    }


    public static void q3() {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.valueOf(scanner.nextLine());
        boolean isEven = false;
        if ((len & 1) == 1) {
            isEven = true;
        }
        int[] A = new int[len / 2 + 1];
        int[] B = new int[len / 2+1];
        int cnt = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        String num = scanner.nextLine();
        String[] stirngs = num.split(" ");
        for (int i = 0; i < len; i++) {
            queue.add(Integer.valueOf(stirngs[i]));
        }

        for (int i = 1; i <= len / 2; i++) {
            getMax(queue, cnt, A);
            getMax(queue, cnt, B);
            cnt++;
        }
        int resA = getSum(A);
        int resB = getSum(B);

        if (isEven) {
                resA += Math.abs(queue.poll() - A[len / 2]);
        }
        System.out.print(resA+" "+resB);

    }

    private static void getMax(LinkedList<Integer> queue, int cnt, int[] arr) {
        int left = queue.getFirst();
        int right = queue.getLast();
        int lastNum = arr[cnt-1];
        if (Math.abs(lastNum - left) >= Math.abs(lastNum - right)) {
            arr[cnt] = queue.removeFirst();
        } else {
            arr[cnt] = queue.removeLast();
        }
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }
        sum += Math.abs(arr[0]);
        return sum;
    }


    public static void q5() {
        try {
            URL url=new URL("http://59.111.13.242/leihuo_2019_guess.zip");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void q2() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        double up = Double.valueOf(strings[0]);
        int down = Integer.valueOf(strings[1]);




    }

}
