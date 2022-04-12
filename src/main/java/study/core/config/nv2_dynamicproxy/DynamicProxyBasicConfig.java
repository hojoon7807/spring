package study.core.config.nv2_dynamicproxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.app2.v1.*;
import study.core.config.nv2_dynamicproxy.handler.LogTraceBasicHandler;
import study.core.trace.logtrace.LogTrace;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyBasicConfig {
    @Bean
    public OrderRepositoryNV1 orderRepositoryV1(LogTrace trace) {
        OrderRepositoryNV1Impl orderRepository = new OrderRepositoryNV1Impl();

        OrderRepositoryNV1 proxy = (OrderRepositoryNV1)Proxy.newProxyInstance(OrderRepositoryNV1.class.getClassLoader(),
                new Class[]{OrderRepositoryNV1.class},
                new LogTraceBasicHandler(orderRepository, trace));
        return proxy;
    }

    @Bean
    public OrderServiceNV1 orderServiceV1(LogTrace trace) {
        OrderServiceNV1Impl orderService = new OrderServiceNV1Impl(orderRepositoryV1(trace));

        OrderServiceNV1 proxy = (OrderServiceNV1) Proxy.newProxyInstance(OrderServiceNV1.class.getClassLoader(),
                new Class[]{OrderServiceNV1.class},
                new LogTraceBasicHandler(orderService, trace));
        return proxy;
    }

    @Bean
    public OrderControllerNV1 orderControllerV1(LogTrace trace) {
        OrderControllerNV1Impl orderController = new OrderControllerNV1Impl(orderServiceV1(trace));

        OrderControllerNV1 proxy = (OrderControllerNV1) Proxy.newProxyInstance(OrderControllerNV1.class.getClassLoader(),
                new Class[]{OrderControllerNV1.class},
                new LogTraceBasicHandler(orderController, trace));
        return proxy;
    }
}
