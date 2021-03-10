package com.lincheng.study.jdk1_8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1.7 hashmap
 *      数组-链表
 * 1.8 hashmap
 *      数组-链表-红黑树（大于8）
 *      除了添加，别的所有操作的效率都提高了。
 *
 *      ConcurrentHashMap
 *      CAS算法
 * 1.8
 *    直接使用Matespace(元空间)物理内存，垃圾回收机制概率变低
 *
 *
 */
@SpringBootApplication
public class StudyJdk18Application {

    public static void main(String[] args) {
        SpringApplication.run(StudyJdk18Application.class, args);
    }

}
