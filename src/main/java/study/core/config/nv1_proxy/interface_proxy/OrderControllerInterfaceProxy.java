package study.core.config.nv1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.core.app2.v1.OrderControllerNV1;
import study.core.app2.v1.OrderServiceNV1;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerNV1 {

    private final OrderControllerNV1 target;
    private final LogTrace trace;

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
