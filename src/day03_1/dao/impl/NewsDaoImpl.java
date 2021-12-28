package day03_1.dao.impl;

import day03_1.dao.NewsDao;
import day03_1.pojo.News;
import org.apache.log4j.Logger;

/**
 * 新闻模块的DAO实现类
 */
public class NewsDaoImpl implements NewsDao {
    private Logger logger = Logger.getLogger(NewsDaoImpl.class);
    public void save(News news) {
        logger.debug("保存新闻信息到数据库");
        // 省略数据库操作代码
        logger.debug("保存：{ \"ntitle\":\"" + news.getNtitle()+"\", \"ncontent\":\""+news.getNcontent()+"\" }");
    }
}
