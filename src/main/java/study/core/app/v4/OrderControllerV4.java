package study.core.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.core.app.v3.OrderServiceV3;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;
import study.core.trace.template.AbstractTemplate;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {
    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "OK";
            }
        };

        return template.execute("OrderController.request()");

//        TraceStatus status = null;
//
//        try {
//            status = trace.begin("OrderController.request()");
//            orderService.orderItem(itemId);
//            trace.end(status);
//            return "ok";
//        } catch (Exception e) {
//            trace.exception(status, e);
//            throw e;
//        }
    }
}
