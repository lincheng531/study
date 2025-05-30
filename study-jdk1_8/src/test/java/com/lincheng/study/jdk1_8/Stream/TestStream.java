package com.lincheng.study.jdk1_8.Stream;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.lincheng.study.common.utils.BeanUtils;
import com.lincheng.study.jdk1_8.domain.Employee;
import com.lincheng.study.jdk1_8.domain.User;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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
    public void testForEach() {
        userList.forEach(user -> System.out.println(JSON.toJSONString(user)));
    }

    @Test
    public void testListObjectToListString() {
        List<String> ids = userList.stream().map(User::getName).collect(Collectors.toList());
    }


    @Test
    public void testSorted() {
        //排序
        List<User> users = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users));
        List<User> userAsc = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(userAsc));
        List<User> usersDesc = userList.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(usersDesc));
    }

    @Test
    public void testFilter() {
        //过滤
        List<User> users = userList.stream().filter(user -> user.getAge() > 30).collect(Collectors.toList());

        List<User> collect = userList.stream().filter(user -> user.getAge() != 11).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
    }


    @Test
    public void testLimit() {
        // 从第三个开始截断，只输出前三个

        // 正序
        List<User> users = userList.stream().sorted(Comparator.comparing(User::getAge)).limit(3).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users));

        //倒序
        List<User> users2 = userList.stream().sorted(Comparator.comparing(User::getAge, Comparator.reverseOrder())).limit(3).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users2));

    }


    @Test
    public void testSkip() {
        // 跳过前三个元素，从第四个开始输出
        List<User> users = userList.stream().sorted(Comparator.comparing(User::getAge)).skip(3).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(users));
    }


    @Test
    public void testNum() {

        //DoubleSummaryStatistics doubleSummaryStatistics = lmaUsrLoadctrlRstEntities.stream().mapToDouble(e -> e.getDAvgLoadCtrl() == null ? 0 : e.getDAvgLoadCtrl().doubleValue()).summaryStatistics();

        IntSummaryStatistics num = userList.stream().mapToInt(User::getAge).summaryStatistics();
        System.out.println("总共人数：" + num.getCount());
        System.out.println("平均年龄：" + num.getAverage());
        System.out.println("最大年龄：" + num.getMax());
        System.out.println("最小年龄：" + num.getMin());
        System.out.println("年龄之和：" + num.getSum());

        //获取年龄最大的Person
        User maxAgePerson = userList.stream().max(Comparator.comparing(User::getAge)).orElse(new User());
        System.out.println(maxAgePerson);
        //获取年龄最小的Person
        User minAgePerson = userList.stream().min(Comparator.comparing(User::getAge)).orElse(new User());
        System.out.println(minAgePerson);


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
    public void testFindFirst() {
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
                new Employee("张三", 18, 9999.9, 2),
                new Employee("李四", 22, 6666.9, 1),
                new Employee("王五", 23, 8888.9, 1),
                new Employee("赵六", 26, 7777.9, 1),
                new Employee("田七", 20, 5555.9, 1)
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


        List<Employee> emps = Arrays.asList(
                new Employee(1, "张三", 18, 1.0, 2),
                new Employee(1, "张三", 18, 2.0, 2),
                new Employee(1, "张三", 18, 3.0, 2),
                new Employee(2, "李四", 22, 6666.9, 1),
                new Employee(3, "王五", 23, 8888.9, 1),
                new Employee(4, "赵六", 26, 7777.9, 1),
                new Employee(5, "田七", 20, 5555.9, 1)
        );

        // 使用Collectors.joining()拼接字符串
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六");
        String s = stream.collect(Collectors.joining("-", "(", ")"));
        System.out.println(s);
        String s1 = emps.stream().map(Employee::getName).collect(Collectors.joining(";"));
        System.out.println(s1);


        List<Employee> employeeList = new ArrayList<>();
        Map<Integer, List<Employee>> checkMap = emps.stream().collect(Collectors.groupingBy(Employee::getId));
        checkMap.forEach((key, value) -> {
            value.stream().reduce((a, b) -> new Employee(a.getId(), a.getName(), a.getAge(), a.getSalary() + b.getSalary(), a.getStatus())).ifPresent(employeeList::add);
        });
        System.out.println(JSON.toJSONString(employeeList));


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

        Map<String, Integer> mapKeyValue = emps.stream().collect(Collectors.toMap(Employee::getName, Employee::getAge, (value1, value2) -> value2));
        System.out.println(JSON.toJSONString(mapKeyValue));

        // 一级分组
        Map<String, Employee> mapKeyObject = emps.stream().collect(Collectors.toMap(Employee::getName, a -> a, (k1, k2) -> k1));
        System.out.println(JSON.toJSONString(mapKeyObject));

        Map<Integer, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        Map<String, List<Integer>> collect7 = emps.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.mapping(Employee::getId, Collectors.toList())));
        System.out.println(collect7);


        Map<Integer, String> map1 = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,
                        Collectors.mapping(Employee::getName,
                                Collectors.joining(","))));
        System.out.println(JSON.toJSONString(map1));


        // 二级分组
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


        Map<Integer, Map<String, Employee>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.toMap(Employee::getName, a -> a, (k1, k2) -> k1)));
        Map<Integer, Map<String, List<Employee>>> collect4 = emps.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getName)));

        // 三级分组
        Map<Integer, Map<Integer, Map<String, Employee>>> collect2 = emps.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getStatus, Collectors.toMap(Employee::getName, a -> a, (k1, k2) -> k1))));

        //集合根据一个字段去重
        List<Employee> collect3 = emps.stream().filter(distinctByKey(Employee::getAge)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect3));

        //对象去重，去空
        List<Employee> collect6 = emps.stream().filter(Objects::nonNull).distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect6));

        //数组去重
        List<String> collect5 = emps.stream().map(Employee::getName).distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect5));


        // 分区（分成两部分）
        Map<Boolean, List<Employee>> listMap = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 6000));
        System.out.println(listMap);

        //总结（方便地获取多种数据统计方式的结果）
        DoubleSummaryStatistics dss = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());
        System.out.println(dss.getSum());
        System.out.println(dss.getCount());
        System.out.println(dss.getAverage());


        IntSummaryStatistics num = userList.stream().mapToInt(User::getAge).summaryStatistics();
        System.out.println(num.getMax());
        System.out.println(num.getMin());
        System.out.println(num.getSum());
        System.out.println(num.getCount());
        System.out.println(num.getAverage());


        //获取最小年龄的对象
        Employee employeeMin = emps.stream().min(Comparator.comparingLong(Employee::getAge)).orElse(new Employee());
        System.out.println(JSON.toJSONString(employeeMin));
        //获取最大年龄的对象
        Employee employeeMax = emps.stream().max(Comparator.comparingLong(Employee::getAge)).orElse(new Employee());
        System.out.println(JSON.toJSONString(employeeMax));

    }

    @Test
    public void flatMapTest() {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            arrayList.add(3);
            arrayList.add(22);
            arrayList.add(11);
            arrayList.add(44);
            arrayList.add(null);
            arrayList.add(4);
            lists.add(arrayList);

            List<Integer> arrayList2 = JSON.parseArray(JSON.toJSONString(arrayList), Integer.class);
            arrayList2.add(55);
            lists.add(arrayList2);

            List<Integer> arrayList3 = JSON.parseArray(JSON.toJSONString(arrayList), Integer.class);
            arrayList3.add(99);
            arrayList3.add(-2);
            lists.add(arrayList3);


            //将子集合抽上来形成一个大集合
        List<List<Integer>> collect1 = lists.stream().collect(Collectors.toList());

        List<Integer> collect = lists.stream().flatMap(item -> item.stream().filter(Objects::nonNull))
                    .collect(Collectors.toList());

            System.out.println(collect);
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
        System.out.println(System.currentTimeMillis());

        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        String result = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(result);

        String s = String.join(",", list);
        System.out.println(s);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        hashMap.put("3", "3");

    }

    @Test
    public void testAllMatch() {
        //检查是否匹配所有元素，只有全部符合才返回true
        List<String> list = Arrays.asList("springboot", "springcloud", "redis", "git", "netty", "java", "html", "docker");
        // 判断是否所有元素长度大于五
        boolean result = list.stream().allMatch(obj -> obj.length()>5);
        System.out.println(result);
    }

    @Test
    public void testAnyMatch() {
        //检查集合中元素是否有任意一个满足条件。只要有一个满足返回true
        List<String> list = Arrays.asList("springboot", "springcloud", "redis", "git", "netty", "java", "html", "docker");
        // 判断是否有元素长度大于五
        boolean result = list.stream().anyMatch(obj -> obj.length()>5);
        System.out.println(result);
    }



    @Test
    public void testBigDecimal() {


        //常用
        //2.4
        System.out.println("四舍五入(保留位后一位是5进位) = " + new BigDecimal("2.35").setScale(1, BigDecimal.ROUND_HALF_UP));
        //2.3
        System.out.println("四舍五入(保留位后一位是5舍弃) = " + new BigDecimal("2.35").setScale(1, BigDecimal.ROUND_HALF_DOWN));
        //4.6
        //向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
        System.out.println("四舍五入(保留位是奇数) = " + new BigDecimal("4.55").setScale(1, BigDecimal.ROUND_HALF_EVEN));
        //4.4
        //向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
        System.out.println("四舍五入(保留位是偶数) = " + new BigDecimal("4.45").setScale(1, BigDecimal.ROUND_HALF_EVEN));
        // 2.4
        System.out.println("进位= " + new BigDecimal("2.31").setScale(1, BigDecimal.ROUND_UP));


        BigDecimal bignum1 = new BigDecimal("10");
        BigDecimal bignum2 = new BigDecimal("5");
        BigDecimal bignum3 = null;

        //加法
        bignum3 = bignum1.add(bignum2);
        System.out.println("和 是：" + bignum3);

        //减法
        bignum3 = bignum1.subtract(bignum2);
        System.out.println("差  是：" + bignum3);

        //乘法
        bignum3 = bignum1.multiply(bignum2);
        System.out.println("积  是：" + bignum3);

        //除法
        bignum3 = bignum1.divide(bignum2, 6, RoundingMode.HALF_UP);
        System.out.println("商  是：" + bignum3);


        BigDecimal a = new BigDecimal("0");
        BigDecimal b = new BigDecimal("0.0");
        //前提为a、b均不能为null
        if (a.compareTo(b) < 0) {
            System.out.println("a小于b");
        }

        if (a.compareTo(b) == 0) {
            System.out.println("a等于b");
        }

        if (a.compareTo(b) > 0) {
            System.out.println("a大于b");
        }

        if (a.compareTo(b) > -1) {
            System.out.println("a大于等于b");
        }

        if (a.compareTo(b) < 1) {
            System.out.println("a小于等于b");
        }

    }


    //去重
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return object -> seen.putIfAbsent(keyExtractor.apply(object), Boolean.TRUE) == null;
    }
}
