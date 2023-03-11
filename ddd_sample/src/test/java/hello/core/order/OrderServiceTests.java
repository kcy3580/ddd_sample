package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.application.Interface.MemberServiceInterface;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.order.application.Interface.OrderServiceInterface;
import hello.core.order.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTests {
    MemberServiceInterface memberServiceInterface;
    OrderServiceInterface orderServiceInterface;

    @BeforeEach //테스트를 실행하기 전 무조건 실행
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        memberServiceInterface = appConfig.memberServiceInterface();
        orderServiceInterface = appConfig.orderServiceInterface();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "oscar", Grade.BASIC);
        memberServiceInterface.join(member);

        Order order = orderServiceInterface.createOrder(memberId, "itemA", 40000);
        System.out.println("order = " + order);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
