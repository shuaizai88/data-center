package com.xhb.dc.kettle.portal.model.util.mapper;

import com.xhb.dc.kettle.portal.model.util.model.ExcelTables;

public interface ExcelTablesMapper {
    int deleteByPrimaryKey(String id);

    int insert(ExcelTables record);

    int insertSelective(ExcelTables record);

    ExcelTables selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExcelTables record);

    int updateByPrimaryKey(ExcelTables record);
}