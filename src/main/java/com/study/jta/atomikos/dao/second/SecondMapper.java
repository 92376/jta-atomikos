package com.study.jta.atomikos.dao.second;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wujing
 * @since 2019/5/31 10:38
 */
@Mapper
public interface SecondMapper {

    @Insert("insert user_info (name) values (#{name})")
    Integer save(@Param("name") String name);

}