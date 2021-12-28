package reflect.entity;

import java.io.IOException;

public final class Student extends BaseClass implements java.io.Serializable {

    // 成员变量
    private String name;
    static final int age = 30;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sleep() {
        System.out.println("sleep......");
    }
}
