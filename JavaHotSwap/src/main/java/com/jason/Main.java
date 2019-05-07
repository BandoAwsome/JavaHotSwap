package com.jason;

/**
 * 测试类
 * @author zhuzhenhao
 * @version 1.0.0
 * @date 2019/5/6 16:37
 */
public class Main {

    public static void main(String[] args) {
        final Excample excample = new Excample();
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        excample.print();
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
