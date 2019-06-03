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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 读数据源配置
 *
 * @author wujing
 * @date: 2019/03/27 14:26
 */
@Configuration
@MapperScan(basePackages = "com.study.jta.atomikos.dao.first", sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class DataSourceFirstConfig {

    @Primary
    @Bean(name = "firstDataSource")
    @ConfigurationProperties(prefix = "app.datasource.first")
    public DataSource dataSource() {
        return new AtomikosDataSourceBean();
    }

    @Primary
    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource)
            throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(MybatisConfig.getConfiguration());

        return bean.getObject();
    }

    @Primary
    @Bean(name = "firstTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("firstDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "firstSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}