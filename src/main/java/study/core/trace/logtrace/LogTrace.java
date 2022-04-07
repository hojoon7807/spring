package study.core.trace.logtrace;

import study.core.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status , Exception e);
}
