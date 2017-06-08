package com.mybaits;

import com.mybaits.dao.IArticleDao;
import com.mybaits.dao.impl.ArticleDao;
import com.mybaits.model.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wqkenqing on 2017/3/14.
 */
public class MybaitsTest {

    public static void main(String[] args) throws IOException {
        String resource = "SqlMapper.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlF = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlF.openSession(true);
        Long i = 2l;
//        Article article=sqlSession.select("selectAritcle",i);

//        Article article = sqlSession.selectOne("selectAritcle", i);
        //       SqlSessionFactory sf=
//        System.out.println(article.getContent());
//        IArticleDao articleDao = new ArticleDao(sqlSession);
            IArticleDao articleDao=sqlSession.getMapper(IArticleDao.class);

            Article article1 = articleDao.get(i);

        System.out.println(article1);

    }

}
