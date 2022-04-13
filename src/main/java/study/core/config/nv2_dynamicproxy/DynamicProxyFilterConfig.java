package study.core.config.nv2_dynamicproxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.app2.v1.*;
import study.core.config.nv2_dynamicproxy.handler.LogTraceFilterHandler;
import study.core.trace.logtrace.LogTrace;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request*", "order*", "save*"};
    @Bean
    public OrderRepositoryNV1 orderRepositoryV1(LogTrace trace) {
        OrderRepositoryNV1Impl orderRepository = new OrderRepositoryNV1Impl();

        OrderRepositoryNV1 proxy = (OrderRepositoryNV1)Proxy.newProxyInstance(OrderRepositoryNV1.class.getClassLoader(),
                new Class[]{OrderRepositoryNV1.class},
                new LogTraceFilterHandler(orderRepository, trace, PATTERNS));
        return proxy;
    }

    @Bean
    public OrderServiceNV2 orderServiceV1(LogTrace trace) {
        OrderServiceNV1Impl orderService = new OrderServiceNV1Impl(orderRepositoryV1(trace));

        OrderServiceNV2 proxy = (OrderServiceNV2) Proxy.newProxyInstance(OrderServiceNV2.class.getClassLoader(),
                new Class[]{OrderServiceNV2.class},
                new LogTraceFilterHandler(orderService, trace, PATTERNS));
        return proxy;
    }

    @Bean
    public OrderControllerNV2 orderControllerV1(LogTrace trace) {
        OrderControllerNV1Impl orderController = new OrderControllerNV1Impl(orderServiceV1(trace));

        OrderControllerNV2 proxy = (OrderControllerNV2) Proxy.newProxyInstance(OrderControllerNV2.class.getClassLoader(),
                new Class[]{OrderControllerNV2.class},
                new LogTraceFilterHandler(orderController, trace, PATTERNS));
        return proxy;
    }
}
