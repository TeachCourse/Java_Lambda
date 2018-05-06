package cn.teachcourse;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by http://teachcourse.cn on 2018-4-26.
 */
public class DriverTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LambdaExamples test = new LambdaExamples();
//        test.example_1();
//        test.example_2();
//        test.example_3();
//		  test.example_4();
//        example_5(test);
//        test.example_6();
//        test.example_7();
//        test.example_8();
//        test.example_9();
//        test.example_10();
//        test.example_11();
//        test.example_12();
        test.example_13();
    }

    private static void example_5(LambdaExamples test) {
        line(true);
        test.example_5((str) -> false);
        line(true);
        test.example_5((str) -> true);
        line(true);
        test.example_5((str) -> ((String) str).startsWith("L"));
        line(true);
        test.example_5((str) -> ((String) str).length() > 5);
    }

    public static void line(boolean isDraw) {
        if (isDraw)
            System.out.println("--------------");
    }
}
