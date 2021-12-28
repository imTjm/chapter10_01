package day03_1.factory;

import day03_1.dao.NewsDao;
import day03_1.dao.impl.NewsDaoImpl;

/**
 * 创建NewsDao实例的工厂类
 */
public class SimpleDaoFactory {
    /**
     * 创建NewsDao实例的工厂方法
     */
    public static NewsDao getInstance() {
        return new NewsDaoImpl();
    }
}
