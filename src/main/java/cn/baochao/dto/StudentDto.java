package cn.baochao.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by huangbc on 2017/3/11.
 */
public class StudentDto implements Serializable{

    private static final long serialVersionUID = 2332608236621015980L;

    @NotBlank
    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
