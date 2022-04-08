package study.core.app2.v1;

public class OrderControllerNV1Impl implements OrderControllerNV1{

    private final OrderServiceNV1 orderService;

    public OrderControllerNV1Impl(OrderServiceNV1 orderServiceNV1) {
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
