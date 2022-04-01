package study.core.scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.AutoAppConfig;
import study.core.member.MemberRepository;
import study.core.member.MemberService;
import study.core.member.MemberServiceImpl;
import study.core.member.MemoryMemberRepository;
import study.core.order.OrderService;
import study.core.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemoryMemberRepository.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        assertThat(orderService).isInstanceOf(OrderServiceImpl.class);
    }
}
