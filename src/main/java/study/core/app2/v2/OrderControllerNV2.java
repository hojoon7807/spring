package study.core.app2.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@ResponseBody
public class OrderControllerNV2 {
    private final OrderServiceNV2 orderService;

    public OrderControllerNV2(OrderServiceNV2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/nv2/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/nv2/no-log")
    public String noLog() {
        return "ok";
    }
}
