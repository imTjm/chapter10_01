package reflect.classinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import reflect.entity.Person;

public class GetClassConstructorsInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 获取Person类声明的所有构造方法
		// 它们是公共、保护、默认（包）访问和私有构造方法
		// 如果此 Class 实例表示一个接口、一个基本类型、一个数组类或 void，则此方法返回一个长度为 0 的数组
		Constructor[] cons = Person.class.getDeclaredConstructors();

		// 构造方法的一些信息
		System.out.println("=========构造方法展示=========");
		for (Constructor con : cons) {

			System.out.print("访问修饰符：");
			int modifier = con.getModifiers();
			// 判断该构造方法的访问修饰符
			if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC)
				System.out.println("public");
			else if ((modifier & Modifier.PROTECTED) == Modifier.PROTECTED)
				System.out.println("protected");
			else if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)
				System.out.println("private");
			else
				System.out.println("default(package)");

			// 获取构造方法的参数列表
			Class[] params = con.getParameterTypes();
			if (params.length == 0) {
				System.out.println("该构造方法没有参数");
			} else {
				System.out.print("该构造方法的参数列表为：[");
				for (int i = 0; i < params.length; i++) {
					if (i != 0)
						System.out.print(", ");
					System.out.print(params[i].getName());
				}
				System.out.println("]");
			}

			System.out.println("----------------------------");
		}

	}

}