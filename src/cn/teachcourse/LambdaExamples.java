package cn.teachcourse;

import javax.swing.*;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExamples {
    /**
     * 例子1：() -> {}代码块替代了整个匿名类
     */
    void example_1() {
        new Thread(() -> System.out.println("() -> {}代码块替代了整个匿名类")).start();
    }

    /**
     * 例子2：带参数的匿名内部类
     */
    void example_2() {
        JButton btn = new JButton();
        btn.addActionListener((e) -> {
            String name = e.getActionCommand();
            System.out.println(name);
        });
    }

    /**
     * 例子3：遍历列表方式一
     */
    void example_3() {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
    }

    /**
     * 例子4：遍历列表方式二
     */
    void example_4() {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        // 使用Java 8的方法引用更方便，方法引用由双冒号(::)操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
    }

    /**
     * 例子5：函数式接口Predicate用法一
     */
    void example_5(Predicate condition) {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> {
            if (condition.test(n)) {
                System.out.println(n + " ");
            }
        });
    }

    /**
     * 例子6：函数式接口Predicate用法二
     */
    void example_6() {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API", "Long long ago");
        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以L开始，长度大于等于四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("L");
        Predicate<String> fourLetterLong = (n) -> n.length() >= 4;
        features.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println("nName, which starts with 'L' and is more than four letter: " + n));
    }

    /**
     * 例子7：使用map()方法
     */
    void example_7() {
        // 计算每一个字符串的长度
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API", "Long long ago");
        features.stream().map((cost) -> ((String) cost).length()).forEach(System.out::println);
    }

    /**
     * 例子8：使用reduce()方法
     */
    void example_8() {
        //为每个订单加上12%的税，并计算总额
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }

    /**
     * 例子9：使用filter()方法
     */
    void example_9() {
        //查询数组中大于200，小于400的数据
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        Predicate<Integer> moreThan = (s) -> s > 200;
        Predicate<Integer> lessThan = (s) -> s < 400;
        costBeforeTax.stream().filter(moreThan.and(lessThan)).forEach(System.out::println);
    }

    /**
     * 例子10：使用collect()方法
     */
    void example_10(){
        //查询数组中大于200，小于400的数据，并放入新的集合data
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500,360,300,100,420,234,756);
        Predicate<Integer> moreThan = (s) -> s > 200;
        Predicate<Integer> lessThan = (s) -> s < 400;
        List<Integer> data=costBeforeTax.stream().filter(moreThan.and(lessThan)).collect(Collectors.toList());
        data.forEach(System.out::println);
        DriverTest.line(true);
        System.out.println(data);
    }
    /**
     * 例子11：distinct()函数的使用
     */
    void example_11(){
        //去掉重复的元素，并组合一个新集合data
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500,360,300,100,420,234,756);
        List<Integer> data=costBeforeTax.stream().distinct().collect(Collectors.toList());
        data.forEach(System.out::println);
        DriverTest.line(true);
        System.out.println(data);
    }

    /**
     * 例子12：IntSummaryStatistics类的用法
     */
    void example_12(){
        List<Integer> primes = Arrays.asList(100, 200, 300, 400, 500,360,300,100,420,234,756);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }
}
