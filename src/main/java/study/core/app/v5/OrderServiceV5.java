package study.core.app.v5;

import org.springframework.stereotype.Service;
import study.core.trace.callback.TraceTemplate;
import study.core.trace.logtrace.LogTrace;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.request()", () -> {
            orderRepository.save(itemId);
            return null;
        });

//        template.execute("OrderService.request()", new TraceCallback<Void>() {
//            @Override
//            public Void call() {
//                orderRepository.save(itemId);
//                return null;
//            }
//        });

    }
}
