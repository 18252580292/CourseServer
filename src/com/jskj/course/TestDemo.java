package com.jskj.course;

import com.alibaba.fastjson.JSON;
import com.jskj.course.domain.Result;

/**
 * Created by xuecheng.cui on 2017/2/4.
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        Result result = new Result();
        result.msg = "用户不存在";
        result.code = UserStatusResult.USER_NOT_EXIST;
        System.out.println(JSON.toJSONString(result));
    }
}
