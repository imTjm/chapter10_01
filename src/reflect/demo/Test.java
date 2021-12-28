package reflect.demo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws Exception {

        //1、加载配置文件
        Properties properties = new Properties();
        ClassLoader classLoader = Test.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("config.properties");

        //获取文件
        properties.load(inputStream);

        //2、读取配置文件
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //3、加载该类进内存
        Class<?> cls = Class.forName(className);
        //4、创建对象
        Object obj = cls.newInstance();
        //5、获取方法对象
        Method method = cls.getMethod(methodName);
        //6、执行犯法
        method.invoke(obj);


    }
}
