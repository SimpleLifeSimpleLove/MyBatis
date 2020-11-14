package com.wxx.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Date: 2020/11/14 21:34
 * Content:
 */
@Data
public class User implements Serializable {

    private int id;
    private String name;
    private String pwd;
}
