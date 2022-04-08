package study.core.app.v5;

import org.springframework.stereotype.Repository;
import study.core.trace.callback.TraceCallback;
import study.core.trace.callback.TraceTemplate;
import study.core.trace.logtrace.LogTrace;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {
        template.execute("OrderRepository.request()", (TraceCallback<Void>) () -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            OrderRepositoryV5.this.sleep(1000);
            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
