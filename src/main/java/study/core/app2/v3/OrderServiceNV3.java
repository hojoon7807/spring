package study.core.app2.v3;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceNV3 {
    private final OrderRepositoryNV3 orderRepository;

    public OrderServiceNV3(OrderRepositoryNV3 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId){
        orderRepository.save(itemId);
    };
}
