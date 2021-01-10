package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class OrderServiceImplTest{

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name",Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository , new RateDiscountPolicy());
        Order order = orderService.createOrder(1L , "itemA" , 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}