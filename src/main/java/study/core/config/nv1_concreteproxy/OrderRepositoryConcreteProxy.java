package study.core.config.nv1_concreteproxy;

import study.core.app2.v2.OrderRepositoryNV2;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;

public class OrderRepositoryConcreteProxy extends OrderRepositoryNV2 {

    private final OrderRepositoryNV2 target;
    private final LogTrace trace;

    public OrderRepositoryConcreteProxy(OrderRepositoryNV2 target, LogTrace trace) {
        this.target = target;
        this.trace = trace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepository.request()");
            // target 호출
            target.save(itemId);
            trace.end(status);

        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
