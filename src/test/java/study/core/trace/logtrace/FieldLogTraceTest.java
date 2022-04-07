package study.core.trace.logtrace;

import org.junit.jupiter.api.Test;
import study.core.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {
    FieldLogTrace fieldLogTrace = new FieldLogTrace();

    @Test
    void begin_end_level2(){
        TraceStatus status = fieldLogTrace.begin("hello");
        TraceStatus status2 = fieldLogTrace.begin("hello");

        fieldLogTrace.end(status2);
        fieldLogTrace.end(status);
    }

    @Test
    void begin_exception_level2(){
        TraceStatus status = fieldLogTrace.begin("hello");
        TraceStatus status2 = fieldLogTrace.begin("hello");

        fieldLogTrace.exception(status2, new IllegalStateException());
        fieldLogTrace.exception(status, new IllegalStateException());
    }
}