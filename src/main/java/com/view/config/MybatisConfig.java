package com.view.config;

import com.view.mapper.UserTestMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/22.
 */
//@Transaction
@Configuration
public class MybatisConfig {
    @Autowired
    BasicDataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(){
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.view");
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/sqlmapper/*.xml"));
            sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:/mybatis-config.xml"));
            SqlSessionFactory sqlSessionFactory =null;

            try {
                sqlSessionFactory = sqlSessionFactoryBean.getObject();
            }catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
            org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
            configuration.setMapUnderscoreToCamelCase(true);
            return sqlSessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean(name = "SqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }

    @Bean
    public UserTestMapper userTestMapper(){
        return getSqlSessionTemplate().getMapper(UserTestMapper.class);
    }
}
