package com.jason;

import java.io.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * 代理类
 * @author zhuzhenhao
 * @version 1.0.0
 * @date 2019/5/6 16:53
 */
public class JavaAgent {

    /**
     * agentmain入口，接收Instrumentation
     * @param agentArgs
     * @param inst
     * @return: void
     * @date: 2019/5/7 14:55
     */
    public static void agentmain(String agentArgs, Instrumentation inst) throws Exception {
        System.out.println("开始热更新");
        // 获得所有已被装载的class文件
        Class[] classes = inst.getAllLoadedClasses();
        for (Class clazz : classes) {
            if (clazz.getName().equalsIgnoreCase(agentArgs)) {
                inst.addTransformer(new ClassFileTransformer() {
                    /**
                     * 修改字节文件的逻辑点
                     * @param loader
                     * @param className
                     * @param classBeingRedefined
                     * @param protectionDomain
                     * @param classfileBuffer
                     * @return: byte[]
                     * @date: 2019/5/7 14:58
                     */
                    @Override
                    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                        System.out.println("hotswap class name :" + className);
                        byte[] bytes = fileToBytes(new File("C:\\Users\\zhuzhenhao\\Desktop\\Example.class"));
                        return bytes;
                    }
                }, true);
                // 重转换
                inst.retransformClasses(clazz);
            }
        }
        System.out.println("热更新结束");
    }

    /**
     * 将编译完成的class文件转化为字节数组
     * @param file
     * @return: byte[]
     * @date: 2019/5/7 14:54
     */
    public static byte[] fileToBytes(File file) {
        try {
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            in.close();
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
