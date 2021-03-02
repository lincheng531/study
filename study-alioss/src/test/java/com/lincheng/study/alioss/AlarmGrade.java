package com.lincheng.study.alioss;

import java.util.Arrays;

public enum AlarmGrade {

    ATTENTION("attention", "提示"),
    WARNING("warning","警告"),
    SERIOUS("serious", "严重"),
    FAULT("fault", "故障"),
    UNKNOWN("unknown", "未知");

    private String key;

    private String name;

    /**
     * @param key
     * @param name
     */
    AlarmGrade(String key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * @return Returns the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }


    /**
     * 根据Key得到枚举的Value
     * 普通for循环遍历，比较判断
     *
     * @param key
     * @return
     */
    public static AlarmGrade getEnumType(String key) {
        AlarmGrade[] alarmGrades = AlarmGrade.values();
        for (int i = 0; i < alarmGrades.length; i++) {
            if (alarmGrades[i].getKey().equals(key)) {
                return alarmGrades[i];
            }
        }
        return AlarmGrade.UNKNOWN;
    }

    /**
     * 根据Key得到枚举的Value
     * 增强for循环遍历，比较判断
     *
     * @param key
     * @return
     */
    public static AlarmGrade getEnumType1(String key) {
        AlarmGrade[] alarmGrades = AlarmGrade.values();
        for (AlarmGrade alarmGrade : alarmGrades) {
            if (alarmGrade.getKey().equals(key)) {
                return alarmGrade;
            }
        }
        return AlarmGrade.UNKNOWN;
    }

    /**
     * 根据Key得到枚举的Value
     * Lambda表达式，比较判断（JDK 1.8）
     *
     * @param key
     * @return
     */
    public static AlarmGrade getEnumType2(String key) {
        AlarmGrade[] alarmGrades = AlarmGrade.values();
        AlarmGrade result = Arrays.asList(alarmGrades).stream()
                .filter(alarmGrade -> alarmGrade.getKey().equals(key))
                .findFirst().orElse(AlarmGrade.UNKNOWN);

        return result;
    }

    /**
     * 根据Key得到枚举的Value
     * Lambda表达式，比较判断（JDK 1.8）
     *
     * @param key
     * @return
     */
    public static AlarmGrade getEnumType3(String key) {
        return Arrays.asList(AlarmGrade.values()).stream()
                .filter(alarmGrade -> alarmGrade.getKey().equals(key))
                .findFirst().orElse(AlarmGrade.UNKNOWN);
    }


    public static void main(String[] args) {
        String grade = "attention";
        System.out.println("第一种方式：普通for循环遍历，比较判断 \n" + grade + ": " + AlarmGrade.getEnumType(grade).getName());
        System.out.println("\n第二种方式：增强for循环遍历，比较判断 \n" + grade + ": " + AlarmGrade.getEnumType1(grade).getName());
        System.out.println("\n第三种方式：Lambda表达式，比较判断 \n" + grade + ": " + AlarmGrade.getEnumType2(grade).getName());
        System.out.println("\n第四种方式：Lambda表达式，比较判断 \n" + grade + ": " + AlarmGrade.getEnumType3(grade).getName());
    }

}
