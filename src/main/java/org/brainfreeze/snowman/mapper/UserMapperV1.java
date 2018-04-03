package org.brainfreeze.snowman.mapper;

import org.apache.ibatis.annotations.*;
import org.brainfreeze.snowman.model.User;

import java.util.List;

@Mapper
public interface UserMapperV1 {

    @Select("select * from users order by id asc")
    List<User> findAll();

    @Select("select * from users where  id = #{id}")
    User findById(@Param(value = "id") Long id);

    @Insert("insert into users (name, salary) values (#{name}, #{salary})")
    void insert(User user);

    @Update("update users set name = #{name} ,  salary = #{salary} where id = #{id}")
    void update(User user);

    @Delete("delete from users where id = #{id}")
    void delete(@Param(value = "id") Long id);
}
