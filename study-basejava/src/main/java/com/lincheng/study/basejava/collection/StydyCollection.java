package com.lincheng.study.basejava.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author lincheng5
 * @date 2021/6/25 0:21
 */
public class StydyCollection {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //倒序
        Collections.reverse(list);
        //随机排序
        Collections.shuffle(list);
        //指定位置交换
        Collections.swap(list,0,1);
        //自然数，最大值
        Collections.max(list);
        //指定元素出现的次数
        Collections.frequency(list,1);
        //指定元素替换
        Collections.replaceAll(list,1,0);
        //确保一个集合不能被修改,如果再次添加会报出异常
        Collections.unmodifiableCollection(list);
        //把ArrayList变成线程安全。
        List<Integer> integers = Collections.synchronizedList(list);

    }
}
