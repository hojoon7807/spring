package study.core.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;
import study.core.trace.strategy.code.Strategy;

@Slf4j
public class TimeLogTemplate {
    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();
        callback.call(); //위임
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
