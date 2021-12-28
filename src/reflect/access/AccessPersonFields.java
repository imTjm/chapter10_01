package reflect.access;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import reflect.entity.Person;

public class AccessPersonFields {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 本例演示通过反射操作Person的属性
		try {
			// 通过反射加载一个Person实例
			Class cls = Class.forName("reflect.entity.Person");
			Object person = cls.newInstance();

			// 获取name属性
			Field name = cls.getDeclaredField("name");
			// name属性为private，这里已超出其访问范围，不能直接访问
			// 通过setAccessable方法，设定为可以访问
			name.setAccessible(true);
			// 先取值看一下
			System.out.println("赋值前的name：" + name.get(person));
			// 为name属性赋值
			name.set(person, "New Person");
			// 展示一下赋值效果
			System.out.println("赋值后的name：" + name.get(person));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
