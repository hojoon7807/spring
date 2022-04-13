package study.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.app2.v1.*;

@Configuration
public class AppNV1Config {
    @Bean
    public OrderServiceNV2 orderServiceNV1(){
        return new OrderServiceNV1Impl(orderRepositoryNV1());
    }

    @Bean
    public OrderRepositoryNV1 orderRepositoryNV1() {
        return new OrderRepositoryNV1Impl();
    }

    @Bean
    public OrderControllerNV2 orderControllerNV1(){
        return new OrderControllerNV1Impl(orderServiceNV1());
    }

}
