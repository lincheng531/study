package com.lincheng.study.basejava.collection;

import com.lincheng.study.basejava.StudyBasejavaApplication;
import com.lincheng.study.basejava.vo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author lincheng5
 * @date 2021/6/16 23:29
 *
 * Iterable本身不存放数据，仅用于遍历集合
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyBasejavaApplication.class)
public class CollectionIteratorTest {

    @Test
    @SuppressWarnings({"all"})
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(new Book("三国","罗贯中",22.22));
        collection.add(new Book("小李飞刀","龙哥",12.234));
        collection.add(new Book("红楼梦","曹雪芹",89.2));

        Iterator iterator = collection.iterator();

        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

        //异常NoSochElementException
        iterator.next();
        //希望现次遍历，需要重置迭代器。
        iterator = collection.iterator();
    }
}


