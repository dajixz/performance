package com.apsd.performance.vo;

import lombok.Data;

/**
 * @author 大稽
 * @date2018/12/3112:58
 */
@Data
public class ResponseVo {
    private int code;
    private String msg;
    private Object data;
}
