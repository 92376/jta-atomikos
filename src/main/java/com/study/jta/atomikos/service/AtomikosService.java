package com.study.jta.atomikos.service;

import java.util.Map;

/**
 * @author wujing
 * @since 2019/5/31 14:29
 */
public interface AtomikosService {

    /**
     * 保存
     *
     * @param name
     * @return
     */
    Map<String, Object> save(String name);

}
