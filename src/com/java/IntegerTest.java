package com.java;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = Integer.valueOf(1);
        f(a);
        System.out.println(a);
        f(b);
        System.out.println(b);


        A a1 = new A();
        a1.setNum(10);
        A b1 = new A();
        b1.setNum(20);
        System.out.println(f1(a1));
        System.out.println(a1);
        f2(a1);
        System.out.println(a1);
        System.out.println(f1(b1));
    }

    private static void f(Integer a) {
        a = new Integer(123);
    }

    /**
     * 在方法中使指针引用其它对象，那么这两个指针此时指向的是完全不同的对象，在一方改变其所指向对象的内容时对另一方没有影响
     * @param a
     * @return
     */
    private static A f1(A a) {
        a = new A();
        a.setNum(100);
        return a;
    }

    public static void f2(A a) {
        a.setNum(100);
    }

}

class A {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "A{" +
                "num=" + num +
                '}';
    }
}

