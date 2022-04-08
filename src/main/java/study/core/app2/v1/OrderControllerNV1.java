package study.core.app2.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping // 스프링은 @Controller 또는 @RequestMapping이 있어 스프링 컨트롤러로 인식
@ResponseBody
public interface OrderControllerNV1 {

    @GetMapping("/nv1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/nv1/no-log")
    String noLog();
}
