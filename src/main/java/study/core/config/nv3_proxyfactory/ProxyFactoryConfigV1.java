package study.core.config.nv3_proxyfactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.app2.v1.*;
import study.core.config.nv3_proxyfactory.advice.LogTraceAdvice;
import study.core.trace.logtrace.LogTrace;

@Slf4j
@Configuration
public class ProxyFactoryConfigV1 {
    @Bean
    public OrderControllerNV2 orderControllerNV1(LogTrace logTrace) {
        OrderControllerNV2 target = new OrderControllerNV1Impl(orderServiceNV1(logTrace));
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        OrderControllerNV2 proxy = (OrderControllerNV2) proxyFactory.getProxy();
        log.info("proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    @Bean
    public OrderServiceNV2 orderServiceNV1(LogTrace logTrace) {
        OrderServiceNV2 target = new OrderServiceNV1Impl(orderRepositoryNV1(logTrace));
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        OrderServiceNV2 proxy = (OrderServiceNV2) proxyFactory.getProxy();
        log.info("proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    @Bean
    public OrderRepositoryNV1 orderRepositoryNV1(LogTrace logTrace) {
        OrderRepositoryNV1 target = new OrderRepositoryNV1Impl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        OrderRepositoryNV1 proxy = (OrderRepositoryNV1) proxyFactory.getProxy();
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
