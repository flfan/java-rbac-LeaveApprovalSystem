package com.imooc.oa.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    public static String MD5Digest(String source) {
        return DigestUtils.md5Hex(source);
    }

    public static String MD5Digest(String source, Integer salt) {
        char[] ca = source.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            ca[i] = (char)(ca[i] + salt);
        }
        String target = new String(ca);
        String md5 = DigestUtils.md5Hex(target);
        return md5;
    }

    public static void main(String[] args) {
        String test = MD5Utils.MD5Digest("test",(Integer)188);
        System.out.println(test);
    }
}
