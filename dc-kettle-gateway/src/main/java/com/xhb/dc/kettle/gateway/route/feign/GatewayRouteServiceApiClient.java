package com.xhb.dc.kettle.gateway.route.feign;

import com.xhb.dc.kettle.system.gateway.api.GatewayRouteServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 网关路由接口客户端.
 *
 * @author gavin
 * @since 2020/6/13 3:10 下午
 */
@FeignClient(value = "dataintegration-portal-system-management-provider", path = "/gateway/route")
public interface GatewayRouteServiceApiClient extends GatewayRouteServiceApi {
}
