package com.xhb.dc.kettle.portal.model.util.factory.sql.mysql;

import com.xhb.dc.kettle.portal.model.common.DataTypeUtil;
import com.xhb.dc.kettle.portal.model.common.entity.BasicModelMetaDataVO;
import com.xhb.dc.kettle.portal.model.common.entity.ModelFilterVO;
import com.xhb.dc.kettle.portal.model.util.factory.sql.SqlJoin;
import com.xhb.dc.kettle.portal.model.util.factory.sql.filter.CommonSqlFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Description : description</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2020/7/2 5:06 下午</li>
 * <li>Author      : ksice_xt</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@Component
public class MysqlSql extends CommonSqlFilter implements SqlJoin {

    @Override
    public StringBuffer getStringBuffer(List<BasicModelMetaDataVO> basicModelMetaDataVOS, List<ModelFilterVO> modelFilterVOS, String tableName, Boolean isLimit) {
        StringBuffer stringBuffer = new StringBuffer("select ");

        for (BasicModelMetaDataVO basicModelMetaDataVO : basicModelMetaDataVOS) {
//            stringBuffer.append(basicModelMetaDataVO.getColumnName() + " as \"" + basicModelMetaDataVO.getColumnChineseName() + "\",");
            stringBuffer.append(basicModelMetaDataVO.getColumnName() + ",");

        }

        stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" FROM " + tableName);

        if (!StringUtils.isEmpty(modelFilterVOS) && modelFilterVOS.size() > 0) {
            stringBuffer.append(" where ");
            for (ModelFilterVO modelFilterVO : modelFilterVOS) {
                appendSql(stringBuffer, modelFilterVO);
            }
        }
        if (isLimit) {
            stringBuffer.append(" limit 100");
        }
        return stringBuffer;
    }


    @Override
    public void appendSql(StringBuffer stringBuffer, ModelFilterVO modelFilterVO) {
        super.appendSql(stringBuffer, modelFilterVO);
        String fieldType = modelFilterVO.getColumnType().toLowerCase();

        if (DataTypeUtil.dateValid(fieldType)) {

        }
    }

}
