package com.mybaits.dao;

import com.mybaits.model.Article;

/**
 * Created by wqkenqing on 2017/3/14.
 */
public interface IArticleDao {
    Article get(Long id);

    Long insert(Article article);

    Long update(Article article);

    Long delete(Long id);
}
