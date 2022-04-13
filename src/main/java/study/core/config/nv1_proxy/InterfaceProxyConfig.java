package study.core.config.nv1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.app2.v1.*;
import study.core.config.nv1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import study.core.config.nv1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import study.core.config.nv1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import study.core.trace.logtrace.LogTrace;

@Configuration
public class InterfaceProxyConfig {
    @Bean
    public OrderServiceNV2 orderService(LogTrace trace){
        OrderServiceNV1Impl orderServiceImpl = new OrderServiceNV1Impl(orderRepository(trace));
        return new OrderServiceInterfaceProxy(orderServiceImpl, trace);
    }

    @Bean
    public OrderRepositoryNV1 orderRepository(LogTrace trace) {
        OrderRepositoryNV1Impl orderRepositoryImpl = new OrderRepositoryNV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepositoryImpl, trace);
    }

    @Bean
    public OrderControllerNV2 orderController(LogTrace trace){
        OrderControllerNV1Impl orderControllerImpl = new OrderControllerNV1Impl(orderService(trace));
        return new OrderControllerInterfaceProxy(orderControllerImpl, trace);
    }

}
