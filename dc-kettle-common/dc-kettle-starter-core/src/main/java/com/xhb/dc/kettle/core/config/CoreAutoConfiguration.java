package com.xhb.dc.kettle.core.config;

import com.xhb.dc.kettle.core.handler.GlobalExceptionHandler;
import com.xhb.dc.kettle.core.handler.GlobalWebsocketExceptionAspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * core包自动配置.
 *
 * @author gavin
 * @since 2020/2/7 5:47 下午
 */
@Configuration
@Import({GlobalExceptionHandler.class, GlobalWebsocketExceptionAspect.class})
public class CoreAutoConfiguration {
}
