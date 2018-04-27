package cn.teachcourse;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class LambdaExamples {
    /**
     * 例子1：() -> {}代码块替代了整个匿名类
     */
    void example_1(){
        new Thread(()->System.out.println("() -> {}代码块替代了整个匿名类")).start();
    }

    /**
     * 例子2：带参数的匿名内部类
     */
    void example_2(){
        JButton btn=new JButton();
        btn.addActionListener((e)->{
            String name=e.getActionCommand();
            System.out.println(name);
        });
    }
    /**
     * 例子3：遍历列表
     */
    void example_3(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        features.forEach(n -> System.out.println(n));
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
    }
}
