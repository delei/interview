package cn.delei.java.basic;

import cn.delei.PrintUtil;

import java.lang.annotation.Target;

class User<A> {
    private A name;

    public A getName() {
        return name;
    }

    public void setName(A name) {
        this.name = name;
    }
}

class Info<B extends Number> {
    private B name;

    public B getName() {
        return name;
    }

    public void setName(B name) {
        this.name = name;
    }
}

/**
 * 泛型
 * 常用的字母表示含义：
 * E - Element (在集合中使用，因为集合中存放的是元素)
 * T - Type（Java 类）
 * K - Key（键）
 * V - Value（值）
 * N - Number（数值类型）
 * ？ -  表示不确定的java类型
 */
public class GenericsDemo01 {
    public static void main(String[] args) {
        PrintUtil.printTitle("普通泛型");
        User<String> u1 = new User<String>();
        u1.setName("user01");
        System.out.printf("%-10s", "u1");
        System.out.println(u1.getName());
        User<Integer> u2 = new User<Integer>();
        u2.setName(100);
        System.out.printf("%-10s", "u2");
        System.out.println(u2.getName());

        PrintUtil.printTitle("泛型上下限制(边界)");
        Info<Integer> info1 = new Info<Integer>();
        info1.setName(200);
        System.out.printf("%-10s", "info1");
        System.out.println(info1.getName());
        Info<Double> info2 = new Info<Double>();
        info2.setName(200.00d);
        System.out.printf("%-10s", "info2");
        System.out.println(info2.getName());

        // Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number'
        // Info<String> info3=new Info<String>();

        // 只能传入Integer的父类或者Integer
        // Info<Double> info3=new Info<Double>();
        // showKeyValue(info3);
        Info<Number> info3 = new Info<Number>();
        showKeyValue(info3);

        PrintUtil.printTitle("泛型类型擦除");
        // true
        System.out.println(u1.getClass() == u2.getClass());
        // true
        System.out.println(true);
        // true
        System.out.println(info1.getClass() == info3.getClass());

    }

    private static void showKeyValue(Info<? super Integer> obj) {
        System.out.println(obj);
    }
}
