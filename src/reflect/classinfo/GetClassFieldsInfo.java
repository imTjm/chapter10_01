package reflect.classinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import reflect.entity.Person;

public class GetClassFieldsInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 获取Person中的所有属性，
		// 包括公共、保护、默认（包）访问和私有属性，但不包括继承的属性,
		// 如果该类或接口不声明任何属性，或者此 Class 实例表示一个基本类型、一个数组或 void，则此方法返回一个长度为 0 的数组。
		Field[] fields = Person.class.getDeclaredFields();

		// 展示属性的一些信息
		System.out.println("===========属性展示==========");
		for (Field field : fields) {
			System.out.println("属性名：" + field.getName());
			System.out.println("类型：" + field.getType().getName());

			System.out.print("访问修饰符：");
			int modifier = field.getModifiers();
			// 判断该属性的访问修饰符
			if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC)
				System.out.println("public");
			else if ((modifier & Modifier.PROTECTED) == Modifier.PROTECTED)
				System.out.println("protected");
			else if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE)
				System.out.println("private");
			else
				System.out.println("default(package)");

			// 判断该属性是否有static修饰符
			if ((modifier & Modifier.STATIC) == Modifier.STATIC)
				System.out.println("这是一个静态属性");
			// 判断该属性是否有final修饰符
			if ((modifier & Modifier.FINAL) == Modifier.FINAL)
				System.out.println("这是一个final属性");

			System.out.println("----------------------------");
		}
	}
}
