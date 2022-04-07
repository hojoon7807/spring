package study.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.trace.logtrace.FieldLogTrace;
import study.core.trace.logtrace.LogTrace;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace(){
        return new FieldLogTrace();
    }
}
