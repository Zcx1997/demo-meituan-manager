package com.pro.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@TableName("root")
@Getter
@Setter
public class Root {
    private String username;
    private String password;

    public Root(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
