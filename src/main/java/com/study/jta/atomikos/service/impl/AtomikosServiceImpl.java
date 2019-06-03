package com.study.jta.atomikos.service.impl;

import com.study.jta.atomikos.dao.first.FirstMapper;
import com.study.jta.atomikos.dao.second.SecondMapper;
import com.study.jta.atomikos.service.AtomikosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujing
 * @since 2019/5/31 14:29
 */
@Slf4j
@Service
public class AtomikosServiceImpl implements AtomikosService {

    @Autowired
    private FirstMapper firstMapper;

    @Autowired
    private SecondMapper secondMapper;

    @Override
    @Transactional(transactionManager = "jtaTransactionManager", rollbackFor = Throwable.class)
    public Map<String, Object> save(String name) {

        Map<String, Object> map = new HashMap<>(16);
        map.put("first", firstMapper.save(name));
        map.put("second", secondMapper.save(name));
        log.error("error {}", 1 / 0);

        return map;
    }

}
