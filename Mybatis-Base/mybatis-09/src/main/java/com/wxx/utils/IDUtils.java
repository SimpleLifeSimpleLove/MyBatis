package com.wxx.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * Date: 2020/11/13 13:50
 * Content:
 */
public class IDUtils {

    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test() {
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
    }
}
