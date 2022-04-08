package study.core.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import study.core.trace.strategy.code.template.TimeLogTemplate;

@Slf4j
public class TemplateCallbackTest {
    @Test
    void callbackV1(){
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(()->log.info("logic1 execute"));
        timeLogTemplate.execute(()->log.info("logic2 execute"));
    }
}
