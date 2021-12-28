package reflect.classinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import reflect.entity.Person;

public class GetClassMethodsInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 获取Person中的所有方法，
		// 包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法,
		// 如果该类或接口不声明任何方法，或者此 Class 实例表示一个基本类型、一个数组或 void，则此方法返回一个长度为 0 的数组。
		Method[] methods = Person.class.getDeclaredMethods();

		// 展示方法的一些信息
		System.out.println("===========方法展示==========");
		for (Method method : methods) {
			System.out.println("方法名：" + method.getName());
			System.out.println("返回值类型：" + method.getReturnType().getName());

			// 获取方法的参数列表
			Class[] params = method.getParameterTypes();
			if (params.length == 0) {
				System.out.println("该方法没有参数");
			} else {
				System.out.print("该方法的参数列表为：[");
				for (int i = 0; i < params.length; i++) {
					if (i != 0)
						System.out.print(", ");
					System.out.print(params[i].getName());
				}
				System.out.println("]");
			}

			System.out.print("访问修饰符：");
			int modifier = method.getModifiers();
			// 判断该方法的访问修饰符
			if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC)
				System.out.println("public");
			else if ((modifier & Modifier.PROTECTED) == Modifier.PROTECTED)
				System.out.println("protected");
			else if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)
				System.out.println("private");
			else
				System.out.println("default(package)");

			// 判断该方法是否有static修饰符
			if ((modifier & Modifier.STATIC) == Modifier.STATIC)
				System.out.println("这是一个静态方法");
			// 判断该方法是否有final修饰符
			if ((modifier & Modifier.FINAL) == Modifier.FINAL)
				System.out.println("这是一个final方法");
			// 判断该方法是否有abstract修饰符
			if ((modifier & Modifier.ABSTRACT) == Modifier.ABSTRACT)
				System.out.println("这是一个抽象方法");
			// 判断该方法是否有synchronized修饰符
			if ((modifier & Modifier.SYNCHRONIZED) == Modifier.SYNCHRONIZED)
				System.out.println("这是一个同步方法");

			// 获取方法所属的类或接口的Class实例
			Class declaringClass = method.getDeclaringClass();
			System.out.println("方法声明在：" + declaringClass.getName() + " 中");
			
			// 获取方法抛出的异常类型，即throws子句中声明的异常
			Class[] exceptions = method.getExceptionTypes();
			if (exceptions.length > 0) {
				System.out.print("该方法抛出的异常有：[");
				for (int i = 0; i < exceptions.length; i++) {
					if (i != 0)
						System.out.print(", ");
					System.out.print(exceptions[i].getName());
				}
				System.out.println("]");
			}
			System.out.println("----------------------------");
		}
	}

}
