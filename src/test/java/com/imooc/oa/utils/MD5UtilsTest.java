package com.imooc.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilsTest {

    @Test
    public void MD5Digest() {
        String test = MD5Utils.MD5Digest("test");
        System.out.println(test);
    }
}