package study.core.config.nv1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.core.app2.v1.OrderServiceNV1;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceNV1 {
    private final OrderServiceNV1 target;
    private final LogTrace trace;


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
