package study.core.trace.logtrace;

import org.junit.jupiter.api.Test;
import study.core.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class ThreadLocalLogTraceTest {
    ThreadLocalLogTrace threadLocalLogTrace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2(){
        TraceStatus status = threadLocalLogTrace.begin("hello");
        TraceStatus status2 = threadLocalLogTrace.begin("hello");
        TraceStatus status3 = threadLocalLogTrace.begin("hello");

        threadLocalLogTrace.end(status3);
        threadLocalLogTrace.end(status2);
        threadLocalLogTrace.end(status);
    }

    @Test
    void begin_exception_level2(){
        TraceStatus status = threadLocalLogTrace.begin("hello");
        TraceStatus status2 = threadLocalLogTrace.begin("hello");

        threadLocalLogTrace.exception(status2, new IllegalStateException());
        threadLocalLogTrace.exception(status, new IllegalStateException());
    }
}