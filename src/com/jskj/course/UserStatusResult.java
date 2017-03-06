package com.jskj.course;

/**
 * Created by xuecheng.cui on 2017/2/4.
 */
public interface UserStatusResult {
    /**
     * 用户登陆成功的code
     */
    public static final int SUCCESS_CODE = 200;
    /**
     * 密码错误的code
     */
    public static final int PASSWORD_ERROR_CODE = 300;
    /**
     * 用户不存在的code
     */
    public static final int USER_NOT_EXIST = 400;
    /**
     * 用于新建用户时，判断用户存在
     */
    int USER_EXISIT = 500;
}
