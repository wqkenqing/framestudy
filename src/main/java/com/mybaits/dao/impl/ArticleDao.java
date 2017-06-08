package com.mybaits.dao.impl;

import com.mybaits.dao.IArticleDao;
import com.mybaits.model.Article;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by wqkenqing on 2017/3/14.
 */
public class ArticleDao implements IArticleDao {
    SqlSession sqlSession;

    public ArticleDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Article get(Long id) {
        return sqlSession.selectOne("selectAritcle", id);
    }

    public Long insert(Article article) {
        return null;
    }

    public Long update(Article article) {
        return null;
    }

    public Long delete(Long id) {
        return null;
    }
}
