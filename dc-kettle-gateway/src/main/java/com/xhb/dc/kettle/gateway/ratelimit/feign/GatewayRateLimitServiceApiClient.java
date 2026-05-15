package com.xhb.dc.kettle.gateway.ratelimit.feign;


import com.xhb.dc.kettle.system.gateway.api.GatewayRateLimitServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 网关限流接口客户端.
 *
 * @author gavin
 * @since 2020/6/13 3:10 下午
 */
@FeignClient(name = "dataintegration-portal-system-management-provider", contextId = "portal-system-management-provider-rateLimit",path = "/gateway/rateLimit")
public interface GatewayRateLimitServiceApiClient extends GatewayRateLimitServiceApi {
}
