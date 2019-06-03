package com.study.jta.atomikos.config;

import org.apache.ibatis.session.Configuration;

/**
 * mybatis配置
 *
 * @author wujing
 * @since 2019/4/24 16:37
 */
public class MybatisConfig {

    private MybatisConfig() {
    }

    /**
     * 获取mybatis配置
     *
     * @return
     */
    public static Configuration getConfiguration() {

        // mybatis通用配置
        Configuration configuration = new Configuration();
        // 自动驼峰配置
        configuration.setMapUnderscoreToCamelCase(true);
        // sql日志打印配置
        // configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        return configuration;
    }

}
