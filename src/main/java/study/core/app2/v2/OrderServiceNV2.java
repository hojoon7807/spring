package study.core.app2.v2;

public class OrderServiceNV2 {
    private final OrderRepositoryNV2 orderRepository;

    public OrderServiceNV2(OrderRepositoryNV2 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId){
        orderRepository.save(itemId);
    };
}
