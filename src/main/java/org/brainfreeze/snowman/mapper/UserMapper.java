package org.brainfreeze.snowman.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.brainfreeze.snowman.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users order by id asc")
    public List<User> findAll();
}
