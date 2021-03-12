package com.zxc.springboot.exception;

/**
 * @author ZXC
 * @create 2021-01-20 20:36
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户没发现");
    }
}
