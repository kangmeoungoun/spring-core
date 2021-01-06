package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp{
    public static void main(String[] args){

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Long MemberId = 1L;
        Member member = new Member(MemberId , "memberA" , Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(MemberId , "itemA" , 20000);
        System.out.println(order.calculatePrice());
    }
}
