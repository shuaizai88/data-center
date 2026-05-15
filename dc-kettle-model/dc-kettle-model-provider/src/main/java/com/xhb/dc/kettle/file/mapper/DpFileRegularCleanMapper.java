package com.xhb.dc.kettle.file.mapper;

import com.xhb.dc.kettle.file.model.DpFileRegularClean;
import com.xhb.dc.kettle.file.dto.DpFileRegularCleanDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * .定时清理mapper.
 * @author songxiaolang
 * @date 2022-01-04 14:39:25
 */
@Mapper
public interface DpFileRegularCleanMapper {

    /**
     * 新增.
     *
     * @param addEntity 保存参数
     * @return 返回数据
     */
    int insert(DpFileRegularClean addEntity);

    /**
     * 修改.
     *
     * @param uptEntity 修改参数
     * @return 返回数据
     */
    int update(DpFileRegularClean uptEntity);

    /**
     * 根据主键查询.
     *
     * @param id 主键
     * @return 返回集合数据
     */
    DpFileRegularCleanDTO getDetail(@Param("id") Integer id);

}
