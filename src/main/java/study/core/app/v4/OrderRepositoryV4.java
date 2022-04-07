package study.core.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;
import study.core.trace.template.AbstractTemplate;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생");
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepository.request())");
//
//        TraceStatus status = null;
//        try {
//            status = trace.begin("OrderRepository.request()");
//
//            if (itemId.equals("ex")) {
//                throw new IllegalStateException("예외 발생");
//            }
//            sleep(1000);
//
//            trace.end(status);
//        } catch (Exception e) {
//            trace.exception(status, e);
//            throw e;
//        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
