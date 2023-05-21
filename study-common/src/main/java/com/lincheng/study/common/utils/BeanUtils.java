package com.lincheng.study.common.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


public final class BeanUtils {


    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        /* 1.源对象与目标对象都不能为空 */
        if (target == null || source == null) {
            return;
        }

        /* 2.深度拷贝 */
        List<String> ignoreProperties = new ArrayList<>(Arrays.asList(getNullPropertyNames(source)));
        ignoreProperties.add("objectType");
        org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties.toArray(new String[ignoreProperties.size()]));

    }


    public static <T> T copyBean(Object source, Class<T> targetClass){
        if (source == null){
            return null;
        }

        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, target);
            return target;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        throw new BeanCopyException(source, targetClass);
    }

    private static class BeanCopyException extends RuntimeException{
        public BeanCopyException(Object source, Class<?> targetClass) {
            super("Bean Copy Error: source=>" + source.toString() + ", targetClass=>" + targetClass.toString());
        }
    }


    public static void copyList(List sourceList, List targetList, Class<?> targetClazz) {
        if (CollectionUtils.isNotEmpty(sourceList) && Optional.ofNullable(targetList).isPresent()) {
            sourceList.forEach(source -> {
                try {
                    Object target = targetClazz.newInstance();
                    org.springframework.beans.BeanUtils.copyProperties(source, target);
                    targetList.add(target);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    public static void copyListIgnoreNull(List sourceList, List targetList, Class<?> targetClazz) {
        if (CollectionUtils.isNotEmpty(sourceList) && Optional.ofNullable(targetList).isPresent()) {
            sourceList.forEach(source -> {
                try {
                    Object target = targetClazz.newInstance();
                    List<String> ignoreProperties = new ArrayList<>(Arrays.asList(getNullPropertyNames(source)));
                    ignoreProperties.add("objectType");
                    org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties.toArray(new String[ignoreProperties.size()]));
                    targetList.add(target);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}
