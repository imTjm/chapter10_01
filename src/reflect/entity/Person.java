package reflect.entity;

import java.io.IOException;

public final class Person extends BaseClass implements java.io.Serializable {

    // 成员变量
    private String name;
    static final int age = 30;
    protected String address;
    public String message;

    // 成员方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static final int getAge() {
        return age;
    }

    protected String getAddress() {
        return address;
    }

    private void silentMethod() throws IOException, NullPointerException {
        System.out.println("这是悄悄话");
    }

    // 以下声明用于通过反射获取构造方法信息测试
    public Person() {
    }

    public void eat(){
        System.out.println("eat....");
    }

    private Person(String name) {
        this.name = name;
    }

    protected Person(String name, String address, String message) {
        this.name = name;
        this.address = address;
        this.message = message;
    }

    @Override
    public String toString() {
        return "{name:" + name + ", age:" + age + ", address:" + address
                + ", message:" + message + "}";
    }
}
