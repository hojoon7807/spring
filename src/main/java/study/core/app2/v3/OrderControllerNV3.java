package study.core.app2.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import study.core.app2.v2.OrderServiceNV2;

@Slf4j
@RestController
public class OrderControllerNV3 {
    private final OrderServiceNV3 orderService;

    public OrderControllerNV3(OrderServiceNV3 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/nv3/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/nv3/no-log")
    public String noLog() {
        return "ok";
    }
}
