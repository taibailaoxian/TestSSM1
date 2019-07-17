package com.springmvc.dao;

import com.springmvc.entity.TbDoor;

public interface TbDoorMapper {
    int deleteByPrimaryKey(Integer id);


    int insert(TbDoor record);

    int insertSelective(TbDoor record);

    TbDoor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbDoor record);

    int updateByPrimaryKey(TbDoor record);
}