package com.lincheng.study.quartz.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-17 16:05
 **/
@Component
public class SpringUtils implements BeanFactoryPostProcessor {

    // Spring应用上下文环境
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        SpringUtils.beanFactory = configurableListableBeanFactory;
    }

    /**
     * 获取对象
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * 获取对象
     * @return Object 一个以所给名字注册的bean的实例
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBeanByType(Class<T> clzee) throws Exception {
        try {
            return beanFactory.createBean(clzee);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 注入一个对象
     * @return Object 一个以所给名字注册的bean的实例
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static void setBean(String springId, Object obj) throws Exception {
        beanFactory.registerSingleton(springId, obj);
    }

    /**
     * 获取类型为requiredType的对象
     * @return
     * @throws Exception
     */
    public static <T> T getBean(Class<T> clz) throws Exception {
        try {
            @SuppressWarnings("unchecked")
            T result = (T) beanFactory.getBean(clz);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     * @return boolean
     * @throws Exception
     */
    public static boolean isSingleton(String name) throws Exception {
        return beanFactory.isSingleton(name);
    }

    /**
     * @param name
     * @return Class 注册对象的类型
     * @throws Exception
     */
    public static Class<?> getType(String name) throws Exception {
        return beanFactory.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static String[] getAliases(String name) throws Exception {
        return beanFactory.getAliases(name);
    }

}
