package com.emilio.tvseriesquiz.model.pojo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ADUser{
    protected int code;
    private String name;
    private String username;
    private String email;
}
