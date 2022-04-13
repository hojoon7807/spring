package study.core.app2.v1;

public class OrderServiceNV1Impl implements OrderServiceNV2 {

    private final OrderRepositoryNV1 orderRepository;

    public OrderServiceNV1Impl(OrderRepositoryNV1 orderRepositoryNV1) {
        this.orderRepository = orderRepositoryNV1;
    }

    @Override
    public void orderItem(String itemId){
        orderRepository.save(itemId);
    };
}
