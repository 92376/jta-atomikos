package com.study.jta.atomikos.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 写数据源配置
 *
 * @author wujing
 * @date: 2019/03/27 14:26
 */
@Configuration
@MapperScan(basePackages = "com.study.jta.atomikos.dao.second", sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class DataSourceSecondConfig {

    @Bean(name = "secondDataSource")
    @ConfigurationProperties("app.datasource.second")
    public DataSource dataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource)
            throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(MybatisConfig.getConfiguration());

        return bean.getObject();
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("secondDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}