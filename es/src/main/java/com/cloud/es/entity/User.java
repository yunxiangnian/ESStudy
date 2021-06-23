package com.cloud.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lisw
 * @create 2021/6/23 14:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String name;
    private String gender;
    private Integer age;
}
