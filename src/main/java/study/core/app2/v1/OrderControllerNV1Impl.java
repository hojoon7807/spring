package study.core.app2.v1;

public class OrderControllerNV1Impl implements OrderControllerNV2 {

    private final OrderServiceNV2 orderService;

    public OrderControllerNV1Impl(OrderServiceNV2 orderServiceNV1) {
        this.orderService = orderServiceNV1;
    }

    @Override
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
