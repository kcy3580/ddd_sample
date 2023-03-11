package hello.core;

import hello.core.discount.application.DiscountService;
import hello.core.member.application.Interface.MemberServiceInterface;
import hello.core.member.application.MemberService;
import hello.core.member.infra.MemoryMemberRepository;
import hello.core.order.application.Interface.OrderServiceInterface;
import hello.core.order.application.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberServiceInterface memberServiceInterface() {
        return new MemberService(memberRepository()); //생성자 주입
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderServiceInterface orderServiceInterface() {
        return new OrderService(memberRepository(), discountService());
    }

    @Bean
    public DiscountService discountService() {
        return new DiscountService();
    }
}
