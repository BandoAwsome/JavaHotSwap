package com.jason;

/**
 * 需要被动更的类
 * @author zhuzhenhao
 * @version 1.0.0
 * @date 2019/5/6 16:41
 */
public class Example {

    /**
     * 简单累加
     * @return: void
     * @date: 2019/5/7 14:50
     */
    public void print () {
        int sum = 0;
        for (int i = 0; i <= 50; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
