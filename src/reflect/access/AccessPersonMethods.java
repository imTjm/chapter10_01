package reflect.access;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import reflect.entity.Person;

public class AccessPersonMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 本例演示通过反射操作Person的方法
		try {
			// 通过反射加载Person类
			Class clz = Class.forName("reflect.entity.Person");

			// 根据方法名和参数列表获取static final int getAge()方法，没有参数可以不写或用null表示
			Method getAge = clz.getDeclaredMethod("getAge", null);
			// getAge方法为default(package)，这里已超出其访问范围，不能直接访问
			// 通过setAccessable方法，设定为可以访问
			getAge.setAccessible(true);
			// 调用getAge方法并传参，没有参数可以不写或用null表示
			// getAge方法为静态方法，调用时可以不指定具体Person实例
			Object returnAge = getAge.invoke(null, null);
			System.out.println("年龄是：" + returnAge);

			Object person = clz.newInstance(); // 创建Person实例

			// 根据方法名和参数列表获取private void silentMethod()方法，没有参数可以不写或用null表示
			Method silentMethod = clz.getDeclaredMethod("silentMethod", null);
			// silentMethod方法为private，这里已超出其访问范围，不能直接访问
			// 通过setAccessable方法，设定为可以访问
			silentMethod.setAccessible(true);
			// 调用silentMethod方法并传参，没有参数可以不写或用null表示
			silentMethod.invoke(person, null);

			// 根据方法名和参数列表获取public void setName(String)方法
			Method setName = clz.getDeclaredMethod("setName", String.class);
			// setName方法为public，这里可以直接访问
			// 调用setName方法并传参
			setName.invoke(person, "New Person");
			// 验证一下结果，调用public String getName()方法得到name的值
			Object returnName = clz.getDeclaredMethod("getName").invoke(person);
			System.out.println("刚才设定的name是：" + returnName);


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
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
