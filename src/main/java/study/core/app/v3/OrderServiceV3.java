package study.core.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.core.app.v2.OrderRepositoryV2;
import study.core.trace.TraceId;
import study.core.trace.TraceStatus;
import study.core.trace.hellotrace.HelloTraceV2;
import study.core.trace.logtrace.LogTrace;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.request()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
