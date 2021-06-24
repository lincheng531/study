package com.lincheng.study.basejava.collection;

import com.lincheng.study.basejava.StudyBasejavaApplication;
import com.lincheng.study.basejava.vo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * @author lincheng5
 * @date 2021/6/20 16:00
 *
 * set 是无序的
 * set 不允许重复元素，所有最多一个null对象
 *
 *
 * 1. HashSet底层是HashMap
 * 2.添加一个元素时，先得到hash值-会
 * 转成->索引值
 * 3.找到存储数据表table，看这个索引
 * 位置是否已经存放的有元素
 * 4.如果没有，
 * 直接加入
 * 5.如果有，调用equals比较，如果
 * 相同，就放弃添加，如果不相同，则
 * 添加到最后
 * 6. 在Java8中，如果条链表的元素个数
 * 超过TREEIFY THRESHOLD(默认
 * 是8),
 * 并且table的大小>=
 * MIN TREEIFY CAPACITY(默认64),
 * 就会进行树化(红黑树)
 *
 *
 *
 *
 *
 * 1. HashSet底层是HashMap, 第一-次添加
 *      时，table 数组扩容到16,临界值
 *      (threshold)是16咖载因子
 *      (loadFactor)是0.75 = 12
 * 2.如果table数组使用到了临界值12,就
 *      会扩容到16* 2 = 32,新的临界值就是
 *      32*0.75 = 24,依次类推
 * 3.在Java8中，如果一条链表的元素个数到
 *      达TREEIFY THRESHOLD(默认是8),
 *      并且table的大小>=MIN TREEIFY CAPACITY(默认64),就
 *      会进行树化(红黑树),否则仍然采用数组,扩容机制
 *
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyBasejavaApplication.class)
@SuppressWarnings({"all"})
public class SetTest {





    @Test
    public void test4(){
        /*
        1) LinkedHashSet是HashSet的子类
        2) LinkedHashSet底层是一个LinkedHashMap,底层维护了一个数组+双向链表
        3) LinkedHashSet根据元素的hashCode值来决定元素的存储位置，同时使用链表维护元素的次序(图)，这使得元素看起来是以插入顺序保存的。
        4) LinkedHashSet不允许添重复元素
         */

        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456) ;
        set.add(new Employee("刘", 1001));
        set.add(123) ;
        set.add("HSP");
        System.out.println(set);

    }

    @Test
    public void test3(){

        /*
        定义一个EmpZoyee类,该类包含: private 成员属性name ,age要求:
        创建3个Employee对象放入HashSet中
        当name和age的值相同时，认为是相同员I,不能添加到HashSet集合中
        */
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("tom",18));
        hashSet.add(new Employee("li",28));
        hashSet.add(new Employee("tom",18));

        System.out.println(hashSet);
    }

    @Test
    public void test2(){

        //hashset,底层是hashMap

        HashSet hashSet = new HashSet();
        hashSet.add("john");
        hashSet.add("lucy");
        hashSet.add("john");//重复
        hashSet.add("jack");
        hashSet.add(null);//
        hashSet.add(null);//再次添加nulL

    }


    @Test
    public void test1(){
     /*
     定义了辅助变更
     HashMap.Node<K,V>[] tab;
     HashMap.Node<K,V> p;
     int n, i;

        //if 语句表示如果 当前table是nuLl, 或者大小=0
        //就是第一次扩容，到16个空间。
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;

        //(1)根据key,得到hash 去计算该key 应该存放到tabLe表的哪个索引位置
        //并把这个位置的对象，赋给p
        //(2)判断p是否为nuLl
        //(2.1)如果p为null, 表示还没有存放元素，就创建一 个Node (key="java" , vaLue=PRESENT)
        //(2.2)就放在该位置tab[i] = newNode(hash, key, value, nuLl)
        //就不能加入
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            HashMap.Node<K,V> e; K k;

            //如果当前索引位置对应的链表的第一个元素和准备添加的key的hash值一样
            //并且满足下面两个条件
             （1）准备加入的key 和 p 指向的Node结点的key是同一个对象
             （2） p指向的Node结点的key的equals() 和准备加入的key比较后相同
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;

            //再判断p是不是一颗红黑树，
            //如果是一颗红黑树，就调用putTreeVal,来进行添加
            else if (p instanceof HashMap.TreeNode)
                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);

            // 如果tabLe对应索引位置，已经是一个链表，就使用for循环比较
            //(1) 依次和该链表的每一个元素比较后，都不相同,则加入到该链表的最后
                    注意在把元素添加到链表后，立即判断该链表是否已经达到8个结点
                    就调用treeifyBin() 对当前这个链表进行树化(转成红黑树)
                    注意，在转成红黑树时，要进行判断，判断条件，
                    if (tab == nuLl |1 (n = tab.Length) < MIN_ TREEIFY_ CAPACITY(64) )
                    resize();
                    如果上面条件成立，先table扩容。
                    只有上面条件不成立时，才进行转成红黑树
            //(2) 依次和该链表的每一个元素比较过程中，如果有相同情况，就直接break
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;*/



    }





}
