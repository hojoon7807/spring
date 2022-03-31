package study.core;

import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;
import study.core.member.MemberServiceImpl;
import study.core.order.Order;
import study.core.order.OrderService;
import study.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderServiceImpl orderService = new OrderServiceImpl();
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;

        Member member = new Member(memberId, "hojoon", Grade.VIP);

        memberService.join(member);
        Order itemA = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("itemA = " + itemA);
        System.out.println("itemA.calculatePrice() = " + itemA.calculatePrice());
    }
}
