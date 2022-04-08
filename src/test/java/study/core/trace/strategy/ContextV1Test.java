package study.core.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import study.core.trace.strategy.code.ContextV1;
import study.core.trace.strategy.code.Strategy;
import study.core.trace.strategy.code.StrategyLogic1;
import study.core.trace.strategy.code.StrategyLogic2;
import study.core.trace.template.code.AbstractTemplate;
import study.core.trace.template.code.SubClassLogic1;

@Slf4j
public class ContextV1Test {
    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직1 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직2 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1(){
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }
    @Test
    void strategyV2(){
//        Strategy strategy1 = () ->{
//            log.info("비즈니스 로직1 실행");
//        };
//
//        Strategy strategy2 = () ->{
//            log.info("비즈니스 로직2 실행");
//        };

        ContextV1 context1 = new ContextV1(()-> log.info("비즈니스 로직1 실행"));
        ContextV1 context2 = new ContextV1(()-> log.info("비즈니스 로직2 실행"));
        context1.execute();
        context2.execute();
    }
}
