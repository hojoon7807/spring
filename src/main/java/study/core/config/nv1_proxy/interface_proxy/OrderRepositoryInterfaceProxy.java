package study.core.config.nv1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.core.app2.v1.OrderRepositoryNV1;
import study.core.trace.TraceStatus;
import study.core.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryNV1 {

    private final OrderRepositoryNV1 target;
    private final LogTrace trace;

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
