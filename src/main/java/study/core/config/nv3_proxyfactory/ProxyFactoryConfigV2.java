package study.core.config.nv3_proxyfactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.app2.v1.*;
import study.core.app2.v2.OrderRepositoryNV2;
import study.core.app2.v2.OrderServiceNV2;
import study.core.app2.v2.OrderControllerNV2;
import study.core.config.nv3_proxyfactory.advice.LogTraceAdvice;
import study.core.trace.logtrace.LogTrace;

@Slf4j
@Configuration
public class ProxyFactoryConfigV2 {

    @Bean
    public OrderControllerNV2 orderControllerNV2(LogTrace logTrace) {
        OrderControllerNV2 target = new OrderControllerNV2(orderServiceNV2(logTrace));
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        OrderControllerNV2 proxy = (OrderControllerNV2) proxyFactory.getProxy();
        log.info("proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    @Bean
    public OrderServiceNV2 orderServiceNV2(LogTrace logTrace) {
        OrderServiceNV2 target = new OrderServiceNV2(orderRepositoryNV2(logTrace));
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        OrderServiceNV2 proxy = (OrderServiceNV2) proxyFactory.getProxy();
        log.info("proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    @Bean
    public OrderRepositoryNV2 orderRepositoryNV2(LogTrace logTrace) {
        OrderRepositoryNV2 target = new OrderRepositoryNV2();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        OrderRepositoryNV2 proxy = (OrderRepositoryNV2) proxyFactory.getProxy();
        log.info("proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*","save*","order*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
