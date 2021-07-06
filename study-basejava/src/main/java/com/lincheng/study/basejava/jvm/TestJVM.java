package com.lincheng.study.basejava.jvm;

import java.util.Random;

/**
 * @author linCheng
 * @date 2021/7/6 11:26
 */
@SuppressWarnings({"all"})
public class TestJVM {


    public static void main(String[] args) {
        testOutOfMemoty();
    }


    /**
     * 堆 OOM
     */
    public static void testOutOfMemoty(){
        //-Xms8m -Xms8m -XX:+PrintGCDetails

        //byte[] bytes = new byte[40 * 1024 * 1024];

        String string = "lincheng";
        while (true){
            string += string + new Random().nextInt(88888888) + new Random().nextInt(99999999);
        }


    }


     /**
     *  Runtime 信息
     */
    public static void testRuntimeInfo(){
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx:MAx_ MEMORY ="+ maxMemory +"(字节,)"+ (maxMemory / (double)1024 / 1024) + "MB" );
        System.out.println("-Xms:TOTAL_ MEMORY =" + totalMemory +"(字节,)" + (totalMemory / (double)1024 / 1024) + "MB");
    }



}
