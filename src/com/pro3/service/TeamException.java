package com.pro3.service;

/**
 * ClassName:TeamException
 * Package:com.pro3.service
 * Date 2023/4/25 - 20:59
 * author:Jim367
 * Description:
 */

public class TeamException extends Exception{
    static final long serialVersionUID = -33875229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
