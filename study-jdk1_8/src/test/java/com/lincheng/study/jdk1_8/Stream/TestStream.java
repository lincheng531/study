package com.lincheng.study.jdk1_8.Stream;

import com.alibaba.fastjson.JSON;
import com.lincheng.study.jdk1_8.domain.Employee;
import com.lincheng.study.jdk1_8.domain.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author linCheng
 * @date 2021/4/22 10:25
 */
public class TestStream {


    private List<User> userList = Arrays.asList(
            new User("张三", 11),
            new User("王五", 20),
            new User("王五", 91),
            new User("张三", 8),
            new User("李四", 44),
            new User("李四", 44),
            new User("赵六", 45)
    );



    @Test
    public void testForEach(){
        userList.forEach(user -> System.out.println(JSON.toJSONString(user)));
    }


    @Test
    public void testSorted(){
        List<User> users = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users));
    }

    @Test
    public void testFilter(){
        List<User> users = userList.stream().filter(user -> user.getAge() > 30).collect(Collectors.toList());

        List<User> collect = userList.stream().filter(user -> user.getAge() != 11).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
    }


    @Test
    public void testLimit(){
        // 从第三个开始截断，只输出前三个
        List<User> users = userList.stream().sorted(Comparator.comparing(User::getAge)).limit(3).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users));
    }


    @Test
    public void testSkip(){
        // 跳过前三个元素，从第四个开始输出
        List<User> users = userList.stream().sorted(Comparator.comparing(User::getAge)).skip(3).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users));
    }

    @Test
    public void testDistinct(){
        List<User> users = userList.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users));
    }


    @Test
    public void testNum(){
        IntSummaryStatistics num = userList.stream().mapToInt(User::getAge).summaryStatistics();
        System.out.println("总共人数：" + num.getCount());
        System.out.println("平均年龄：" + num.getAverage());
        System.out.println("最大年龄：" + num.getMax());
        System.out.println("最小年龄：" + num.getMin());
        System.out.println("年龄之和：" + num.getSum());
    }


    @Test
    public void testMap() {
        //接收一个方法作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<Integer> ages = userList.stream().map(User::getAge).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(ages));
    }



    @Test
    public void testFlatMap() {
        //对每个元素执行mapper指定的操作，并用所有mapper返回的Stream中的元素组成一个新的Stream作为最终返回结果
        //通俗易懂就是将原来的stream中的所有元素都展开组成一个新的stream
        //创建一个 装有两个泛型为integer的集合
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
        // 将两个合为一个
        Stream<Integer> integerStream = stream.flatMap((Function<List<Integer>, Stream<Integer>>) Collection::stream);
        // 为新的集合
        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
    }


    @Test
    public void testFindFirst(){
        //获取第一个元素.
        User user = userList.stream().findFirst().orElse(null);
        System.out.println(JSON.toJSONString(user));
    }



    @Test
    public void testReduce() {
        //Reduce 归约
        //sum()、max()、min()、count()等都是reduce操作，将他们单独设为函数只是因为常用
        //allMatch：检查是否匹配所有元素
        //anyMatch：检查是否至少匹配一个元素
        //noneMatch：检查是否没有匹配所有元素
        //findFirst：返回第一个元素
        //findAny：返回当前流中的任意元素
        //count：返回流中元素的总个数
        //max：返回流中最大值
        //min：返回流中最小值



        //找到年龄最大的
        User user = userList.stream().reduce((s1, s2) -> s1.getAge() > s2.getAge() ? s1 : s2).orElse(null);
        System.out.println(JSON.toJSONString(user));


        User minUser = userList.stream().min(Comparator.comparing(User::getAge)).orElse(null);
        System.out.println(JSON.toJSONString(minUser));


        List<Employee> emps = Arrays.asList(
                new Employee("张三", 18, 9999.9,2),
                new Employee("李四", 22, 6666.9,1),
                new Employee("王五", 23, 8888.9,1),
                new Employee("赵六", 26, 7777.9,1),
                new Employee("田七", 20, 5555.9,1)
        );

        // 全部 Employee 是 Free，就会返回true
        boolean flag = emps.stream()
                .allMatch((e) -> e.getStatus().equals("1"));
        System.out.println(flag);

        // 只要有 1 个 Employee 是 Free，就会返回true
        boolean flag1 = emps.stream()
                .anyMatch((e) -> e.getStatus().equals("1"));
        System.out.println(flag1);

        // 全部 Employee 都不是 1，就会返回 true
        // 只要有一个 Employee 是 1，就会返回 false
        boolean flag2 = emps.stream()
                .noneMatch((e) -> e.getStatus().equals("1"));
        System.out.println(flag2);

        Optional<Employee> emp1 = emps.stream()
                .findFirst();
                System.out.println(emp1.get());

        // 如果是数据较少，串行地情况下，一般会返回第一个结果
        // 如果是并行的情况，那就不能确保是第一个。
        Optional<Employee> emp2 = emps.parallelStream() // 并行流
                .filter((e) -> e.getStatus().equals("1"))
                .findAny();
        System.out.println(emp2.get());


    }

    @Test
    public void testCollect() {
        // 使用Collectors.joining()拼接字符串
        Stream<String> stream = Stream.of("张三","李四","王五","赵六");
        String s = stream.collect(Collectors.joining("-", "(", ")"));
        System.out.println(s);


        List<Employee> emps = Arrays.asList(
                new Employee("张三", 18, 9999.9,2),
                new Employee("李四", 22, 6666.9,1),
                new Employee("王五", 23, 8888.9,1),
                new Employee("赵六", 26, 7777.9,1),
                new Employee("田七", 20, 5555.9,1)
        );

        // 拼接字符串
        // reduce也可以实现拼接字符串，自行尝试
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 收集成指定集合
        HashSet<String> collect1 = list.stream()
                .map(String::valueOf)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect1);

        // 求平均值
        Double avgSalary = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avgSalary);

        // 求和的3种方式
        double sum = emps.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        double sum2 = emps.stream()
                .mapToDouble(Employee::getSalary)
                .reduce(0, Double::sum);
        double sum3 = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        // 最大值、最小值，也可以收集
        // 举一反三。。。略

        // 一级分组
        Map<Integer, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        // 多级分组
        Map<Integer, Map<String, List<Employee>>> mapMap = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    // 返回值作为第二层Map的key
                    if (e.getAge() > 35) {
                        return "开除";
                    } else {
                        return "继续加班";
                    }
                })));
        System.out.println(mapMap);

        // 分区（分成两部分）
        Map<Boolean, List<Employee>> listMap = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 6000));
        System.out.println(listMap);

        //总结（方便地获取多种数据统计方式的结果）
        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());
        System.out.println(dss.getSum());
        System.out.println(dss.getCount());
        System.out.println(dss.getAverage());

    }


    @Test
    public void foundStream() {
        // 1. 通过Collection系列集合的 stream() 方法或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2. 通过 Arrays 类中的静态方法 stream() 获取数组流
        String[] strArr = new String[10];
        Stream<String> stream1 = Arrays.stream(strArr);

        // 3. 通过 Stream 类中的静态方法 of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");


        // 4. 创建无限流，要有终止操作才有效果
        // （1）迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.forEach(System.out::println); // 不停打印，停不下来
        stream3.limit(10) // 中间操作
                .forEach(System.out::println); // 终止操作



        // （2）生成
        Stream.generate(() -> new Random().nextInt(32))
                .limit(32)
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        String a = "1";
        boolean present = Optional.ofNullable(a).isPresent();
        System.out.println(present);
    }


}
