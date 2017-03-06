package com.jskj.course.domain;

/**
 * Created by xuecheng.cui on 2017/2/4.
 */
public class Result {
    public int code;
    public String msg;
    public Result() {}

    public Result(int code,String msg) {
        this.msg = msg;
        this.code = code;
    }
}
