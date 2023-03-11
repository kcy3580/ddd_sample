package hello.core;

import hello.core.member.application.Interface.MemberServiceInterface;
import hello.core.member.application.MemberService;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import hello.core.order.application.Interface.OrderServiceInterface;
import hello.core.order.application.OrderService;
import hello.core.order.domain.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceInterface memberServiceInterface = applicationContext.getBean("memberServiceInterface", MemberServiceInterface.class);
        OrderServiceInterface orderServiceInterface = applicationContext.getBean("orderServiceInterface", OrderServiceInterface.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "oscar", Grade.VIP);
        memberServiceInterface.join(member);

        Order order = orderServiceInterface.createOrder(memberId, "itemNameA", 10000);

        System.out.println("order.toString() = " + order.toString());
    }
}
