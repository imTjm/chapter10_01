package day03_1.dao;

import day03_1.pojo.News;

/**
 * 新闻模块的DAO接口
 */
public interface NewsDao {
    /**
     * 保存新闻信息的方法
     */
    public void save(News news);
}
