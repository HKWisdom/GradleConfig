package com.wisdom.gradleconfigdemo.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by hukun on 2018/1/18.
 */


public class TUtil {

    /**
     * 类转换初始化
     * @param o 当前类
     * @param i 泛型数组的索引
     * @param <T> 泛型的类型
     * @return
     */

    /**
     * getGenericSuperclass()获得带有泛型的父类
     *Type是 Java 编程语言中所有类型的公共高级接口。
     * 它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
     *Parameterized Type参数化类型，即泛型
     *getActualTypeArguments 获取参数化类型的数组，泛型可能有多个
     *newInstance() 获取到泛型的实例
     */
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass()))
                    .getActualTypeArguments()[i]).newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (ClassCastException e) {
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
