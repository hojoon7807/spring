package study.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.app2.v1.*;
import study.core.app2.v2.OrderControllerNV2;
import study.core.app2.v2.OrderRepositoryNV2;
import study.core.app2.v2.OrderServiceNV2;

@Configuration
public class AppNV2Config {
    @Bean
    public OrderServiceNV2 orderServiceNV2(){
        return new OrderServiceNV2(orderRepositoryNV2());
    }

    @Bean
    public OrderRepositoryNV2 orderRepositoryNV2() {
        return new OrderRepositoryNV2();
    }

    @Bean
    public OrderControllerNV2 orderControllerNV2(){
        return new OrderControllerNV2(orderServiceNV2());
    }

}
