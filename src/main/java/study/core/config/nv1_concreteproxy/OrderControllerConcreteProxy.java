package study.core.config.nv1_concreteproxy;

import study.core.app2.v2.OrderControllerNV2;
import study.core.app2.v2.OrderServiceNV2;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerNV2 {

    private final OrderControllerNV2 target;
    private final LogTrace trace;

    public OrderControllerConcreteProxy(OrderControllerNV2 target, LogTrace trace) {
        super(null);
        this.target = target;
        this.trace = trace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try{
            status = trace.begin("OrderController.request()");
            // target 호출
            String result = target.request(itemId);
            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
