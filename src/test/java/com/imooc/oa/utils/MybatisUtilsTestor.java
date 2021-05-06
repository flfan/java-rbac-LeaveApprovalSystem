package com.imooc.oa.utils;

import org.junit.Test;

public class MybatisUtilsTestor {
    @Test
    public void testCase1() {
        String out = (String)MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        System.out.println(out);
    }

}
