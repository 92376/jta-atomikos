package com.study.jta.atomikos.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.UserTransaction;

/**
 * @author wujing
 * @since 2019/5/31 14:51
 */
@Configuration
public class JtaTransactionManagerConfig {

    @Bean(name = "jtaTransactionManager")
    public JtaTransactionManager jtaTransactionManager () {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }

}