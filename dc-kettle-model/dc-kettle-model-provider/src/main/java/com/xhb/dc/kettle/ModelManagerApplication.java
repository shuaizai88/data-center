package com.xhb.dc.kettle;

import com.xhb.dc.kettle.portal.model.config.DefaultDatasource;
import com.xhb.dc.kettle.portal.model.datasource.dto.DatasourceDTO;
import com.xhb.dc.kettle.portal.model.datasource.mapper.DatasourceMapper;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.pentaho.di.core.encryption.KettleTwoWayPasswordEncoder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 系统管理启动Main
 *
 * @author gavin
 * @since 2020-01-09 15:59
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableSwagger2
@EnableCaching
@MapperScan(value = {"com.xhb.dc.kettle.portal.model.**.mapper","com.xhb.dc.kettle.portal.common.group.**.mapper",
        "com.xhb.dc.kettle.portal.common.project.**.mapper","com.xhb.dc.kettle.file.mapper"})
@ComponentScan(value = {"com.xhb.dc.kettle.portal.model","com.xhb.dc.kettle.portal.common.group","com.xhb.dc.kettle.portal.common.project",
         "com.xhb.dc.kettle.file"})
public class ModelManagerApplication {

    @Resource
    DefaultDatasource defaultDatasource;

    @Resource
    DatasourceMapper datasourceMapper;

    public static final KettleTwoWayPasswordEncoder PASSWORD_ENCODER = new KettleTwoWayPasswordEncoder();



    public static void main(String[] args) {
        new SpringApplicationBuilder(ModelManagerApplication.class).run(args);
    }


    @PostConstruct
    public void initDatasource() {
        DatasourceDTO datasourceDTO = datasourceMapper.getDatasourceByNameAndUserId(defaultDatasource.getDsName());
        if (StringUtils.isEmpty(datasourceDTO)) {
            defaultDatasource.setCreateTime(new Date());
            defaultDatasource.setUpdateTime(new Date());
            defaultDatasource.setDatasourceId(UUID.randomUUID().toString());
            String encode = PASSWORD_ENCODER.encode(defaultDatasource.getDsPassword());
            defaultDatasource.setDsPassword(encode);
            datasourceMapper.insertDefaultDataSource(defaultDatasource);
        }

    }
}
