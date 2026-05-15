package com.xhb.dc.kettle.run.server.feign;

import com.xhb.dc.kettle.portal.model.businessmodel.api.BusinessModelServiceApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


/**
 * @Author: jeremychen
 * @Descripition:
 * @Date:2020/2/19 3:09 下午
 */
@Component
@FeignClient(value = "dp-portal-model-management-provider",path = "/businessModel")
public interface BusinessModelServiceApiClient extends BusinessModelServiceApi {


}
