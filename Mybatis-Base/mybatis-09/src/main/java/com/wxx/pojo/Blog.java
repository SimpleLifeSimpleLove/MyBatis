package com.wxx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Date: 2020/11/13 13:44
 * Content:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date createTime;  // 属性名和字段名不一致，需要在配置文件中开启驼峰命名法
    private int views;
}
