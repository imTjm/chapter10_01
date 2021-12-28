package day03_1.service.impl;

import day03_1.dao.NewsDao;
import day03_1.factory.SimpleDaoFactory;
import day03_1.pojo.News;
import day03_1.service.NewsService;

/**
 * 新闻模块业务类
 */
public class NewsServiceImpl implements NewsService {
    // 实例化所依赖的NewsDao对象
    private NewsDao dao = SimpleDaoFactory.getInstance();

    public void addNews(News news) {
        // 调用NewsDao的方法保存新闻信息
        dao.save(news);
    }
}

