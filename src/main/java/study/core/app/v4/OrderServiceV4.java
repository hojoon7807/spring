package study.core.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.core.app.v3.OrderRepositoryV3;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;
import study.core.trace.template.AbstractTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.request()");

//        TraceStatus status = null;
//        try {
//            status = trace.begin("OrderService.request()");
//            orderRepository.save(itemId);
//            trace.end(status);
//        } catch (Exception e) {
//            trace.exception(status, e);
//            throw e;
//        }
    }
}
