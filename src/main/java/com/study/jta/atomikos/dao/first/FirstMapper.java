package com.study.jta.atomikos.dao.first;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wujing
 * @since 2019/5/31 10:36
 */
@Mapper
public interface FirstMapper {

    @Insert("insert user_info (name) values (#{name})")
    Integer save(@Param("name") String name);

}
