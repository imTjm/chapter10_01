package reflect.access;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AccessPersonConstructors {
    public static void main(String[] args) {
        // 测试反射调用构造方法
        try {
            Class clz = Class.forName("reflect.entity.Person");
            Object obj = clz.newInstance();
            System.out.println(obj);

            // 获取Person的无参构造
            Constructor c1 = clz.getDeclaredConstructor();
            // Person的无参构造为public，这里可以直接访问
            obj = c1.newInstance();
            System.out.println(obj);

            // 获取Person的单参构造
            Constructor c2 = clz.getDeclaredConstructor(String.class);
            // Person的单参构造为private，这里已超出其访问范围，不能直接访问
            // 通过setAccessable方法，设定为可以访问
            c2.setAccessible(true);
            obj = c2.newInstance("New Person");
            System.out.println(obj);

            // 获取Person的三参构造
            Constructor c3 = clz.getDeclaredConstructor(String.class,
                    String.class, String.class);
            // Person的三参构造为protected，这里已超出其访问范围，不能直接访问
            // 通过setAccessable方法，设定为可以访问
            c3.setAccessible(true);
            obj = c3.newInstance("New Person", "beijing", "Hello!");
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
