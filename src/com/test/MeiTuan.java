package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MeiTuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReviewEncourage reviewEncourage = new ReviewEncourage(scanner.nextInt());
        PrizePool prizePool = new PrizePool();
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(3);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reviewEncourage.bonus(prizePool);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reviewEncourage.contribution(prizePool);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                reviewEncourage.coupon(prizePool);
            }
        });
        threadPoolExecutor.submit(t1);
        threadPoolExecutor.submit(t2);
        threadPoolExecutor.submit(t3);
        try {
            Thread.sleep(2500);
            threadPoolExecutor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static String[] unit = new String[]{""};
    static String[] num = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};


    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String content = text.substring(1, text.length() - 1);
        String[] strings = content.split(",");
        List<String> ans = new ArrayList<>();
        for (String str : strings) {
            handleContent(str.substring(1, str.length() - 1), ans);
        }
    }

    public static void handleContent(String str, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();

    }

    public static void testf1() {
        System.out.println("A");
    }

//    *************

    public static void f2() {

    }

    public static void testf2() {

    }

    //    *************
    public static void f3() {

    }

    public static void testf3() {

    }

    //    *************
    public static void f4() {

    }


    public static void testf4() {

    }
}


class PrizePool {
    public void send(String input) {
        System.out.print(input);
    }
}

class ReviewEncourage {
    private final int n;
    private AtomicInteger cnt = new AtomicInteger(1);
    private volatile boolean isB = true;

    LinkedBlockingQueue<String> a = new LinkedBlockingQueue(1);
    LinkedBlockingQueue<String> b = new LinkedBlockingQueue<>(1);
    LinkedBlockingQueue<String> c = new LinkedBlockingQueue<>(1);

    public ReviewEncourage(int n) {
        this.n = n;
        try {
            a.put("A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }      // 构造函数,n为中奖用户数


    public void bonus(PrizePool prizePool) {

        while (cnt.get() <= n) {
            try {
                prizePool.send(a.take());
                cnt.getAndIncrement();
                if (cnt.get() > n) {
                    break;
                }

                if (isB) {
                    b.put("B");
                } else {
                    c.put("C");
                }
            } catch (InterruptedException e) {
                break;
            }
        }

    }  // 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) {

        while (cnt.get() <= n) {
            try {
                prizePool.send(b.take());
                cnt.getAndIncrement();
                if (cnt.get() > n) {
                    break;
                }

                isB = false;
                a.put("A");
            } catch (InterruptedException e) {
                break;
            }
        }


    }  // 仅能打印B，表示发放优惠券

    public void contribution(PrizePool prizePool) {

        while (cnt.get() <= n) {
            try {
                prizePool.send(c.take());
                cnt.getAndIncrement();
                if (cnt.get() > n) {
                    break;
                }
                isB = true;
                a.put("A");
            } catch (InterruptedException e) {
                break;
            }

        }

    }  // 仅能打印C，表示发放贡献值
}
