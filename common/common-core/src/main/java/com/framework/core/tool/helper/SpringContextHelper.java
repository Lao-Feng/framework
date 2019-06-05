package com.framework.core.tool.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Spring上下文工具类
 *
 * @author Fengjie
 * @date 2019-5-29 下午4:16
 */
@Component
public class SpringContextHelper implements ApplicationContextAware {

    /**
     * 上下文对象实例
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHelper.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     *
     * @param name bean 名称
     * @return 获取的bean
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     *
     * @param clazz bean的类型
     * @param <T>   泛型类型
     * @return bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }


    /**
     * 获取 Spring 上下文中 clazz 的实现类
     *
     * @param clazz 基础接口或者基础类
     * @param <T>   指定的类型
     * @return Map接口的 Bean 集合
     */
    public static <T> Map<String, T> getBeanOfType(Class<T> clazz) {
        return getApplicationContext().getBeansOfType(clazz);
    }


    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name  bean名称
     * @param clazz bean的类型
     * @param <T>   泛型类型
     * @return bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}