package com.lincheng.study.jdk1_8;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyJdk18Application.class)
public class StudyJdk18ApplicationTests {

    @Test
    public void test1(){

        HashMap hashMap = new HashMap();
        hashMap.put("1","1");
        hashMap.put("2","1");
        hashMap.put("3","1");
        hashMap.put("4","1");
        HashMap<String,String> hashMap2 = new HashMap<>();
        hashMap2.put("1","1");
        hashMap2.put("2","1");
        Set<Map.Entry<String, String>> entries = hashMap2.entrySet();
        Set<String> strings = hashMap2.keySet();
        for (Map.Entry<String, String> map : hashMap2.entrySet()){
            map.getKey();
            map.getValue();
        }

        hashMap2.forEach((key,value)->{

        });

        Hashtable hashtable = new Hashtable();
        hashtable.put(null,"1");


        Properties properties = new Properties();
        properties.put("1",1);
    }

    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("d");
        treeSet.add("b");

        System.out.println(JSON.toJSONString(treeSet));
    }

}
