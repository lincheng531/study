package com.lincheng.study.basejava.collection;

import com.lincheng.study.basejava.StudyBasejavaApplication;
import com.lincheng.study.basejava.vo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author lincheng5
 * @date 2021/6/17 0:04
 *
 *
 * arrayList是由数组来实现数据的存储的。
     * 用transient（瞬间）来修饰时，表示该属性不会被序列化
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyBasejavaApplication.class)
@SuppressWarnings({"all"})
public class ListTest {

    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Book("三国","罗贯中",22.22));
        arrayList.add(new Book("小李飞刀","龙哥",12.234));
        arrayList.add(new Book("红楼梦","曹雪芹",89.2));

    }

    @Test
    public void test2(){
        Vector vector = new Vector();
        vector.add(new Book("三国","罗贯中",22.22));
        vector.add(new Book("小李飞刀","龙哥",12.234));
        vector.add(new Book("红楼梦","曹雪芹",89.2));
    }

    @Test
    public void test3(){
        LinkedList linkedList = new LinkedList();
        for(int i= 1;i <= 2; i++) {
            linkedList.add(i);
        }
        linkedList.add(100);
        linkedList.add(100);


        linkedList.remove();

        for (Object object : linkedList) {
            System.out.println(object);
        }


        linkedList.set(0, "韩顺平教育");
        System.out.println("===");
        for (Object object : linkedList) {
            System.out.println(object);
        }


        Object object = linkedList.get(0);
        System.out.println("object=" + object);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

    }
}
