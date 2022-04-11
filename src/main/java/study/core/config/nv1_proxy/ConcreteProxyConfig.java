package study.core.config.nv1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.app2.v2.OrderControllerNV2;
import study.core.app2.v2.OrderRepositoryNV2;
import study.core.app2.v2.OrderServiceNV2;
import study.core.config.nv1_concreteproxy.OrderControllerConcreteProxy;
import study.core.config.nv1_concreteproxy.OrderRepositoryConcreteProxy;
import study.core.config.nv1_concreteproxy.OrderServiceConcreteProxy;
import study.core.trace.logtrace.LogTrace;

@Configuration
public class ConcreteProxyConfig {
    @Bean
    public OrderRepositoryNV2 orderRepositoryV2(LogTrace trace){
        OrderRepositoryNV2 target = new OrderRepositoryNV2();
        return new OrderRepositoryConcreteProxy(target,trace);
    }

    @Bean
    public OrderServiceNV2 orderServiceV2(LogTrace trace){
        OrderServiceNV2 target = new OrderServiceNV2(orderRepositoryV2(trace));
        return new OrderServiceConcreteProxy(target, trace);
    }

    @Bean
    public OrderControllerNV2 orderControllerV2(LogTrace trace){
        OrderControllerNV2 target = new OrderControllerNV2(orderServiceV2(trace));
        return new OrderControllerConcreteProxy(target, trace);
    }
}
