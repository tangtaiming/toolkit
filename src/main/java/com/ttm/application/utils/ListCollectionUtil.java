package com.ttm.application.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * List 集合工具
 * @author tangtaiming
 * @date 2022.10.24 17:14
 */
public class ListCollectionUtil {

    /**
     * 分割集合数据
     * @param list
     * @param subListSize
     * @return
     */
    public static List<List<String>> groupList(List<String> list, int subListSize) {
        int listSize = list.size();
        int toIndex = subListSize;
        //用List<String>存起来新的分组后数据
        List<List<String>> newSubList = new ArrayList<>();
        for (int i = 0; i < list.size(); i += subListSize) {
            //作用为toIndex最后没有500条数据则剩余几条newList中就装几条
            if (i + subListSize > listSize) {
                toIndex = listSize - i;
            }
            List<String> newList = list.subList(i, i + toIndex);
            newSubList.add(newList);
        }

        return newSubList;
    }

    /**
     * 平均分配
     * @param source
     * @param n
     * @param <T>
     * @return
     */
    public <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<>();
        //先计算出余数
        int remainder = source.size() % n;
        //计算商
        int number = source.size() / n;
        //偏移量
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }

        return result;
    }

}
