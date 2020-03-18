package com.ex.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class JSR303Test {
    private int id;
    @NotNull(message = "姓名不能为空")
    @Size(min = 1, max = 10, message = "姓名长度在0到10之间")
    private String name;
    private boolean gender;
    @Min(value = 1, message = "年龄必须大于0")
    private int age;
    @NotNull(message = "生日必须不为空")
    @Past(message = "生日必须是在过去")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
