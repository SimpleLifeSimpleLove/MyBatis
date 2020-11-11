package com.wxx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * Date: 2020/11/10 19:34
 * Content:
 */
@Alias("User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String password;  // 这个字段和数据库中的字段不一致，数据库中为pwd，根据id查询用户，会导致该字段password=null
}
