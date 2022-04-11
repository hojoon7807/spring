package study.core.config.nv1_concreteproxy;

import study.core.app2.v2.OrderRepositoryNV2;
import study.core.app2.v2.OrderServiceNV2;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceNV2 {

    private final OrderServiceNV2 target;
    private final LogTrace trace;

    public OrderServiceConcreteProxy(OrderServiceNV2 target, LogTrace trace) {
        super(null);
        this.target = target;
        this.trace = trace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.request()");
            // target 호출
            target.orderItem(itemId);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
