package hello.core.order.application;

import hello.core.discount.application.DiscountService;
import hello.core.discount.application.Interface.DiscountServiceInterface;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Interface.MemberRepository;
import hello.core.member.domain.Member;
import hello.core.member.infra.MemoryMemberRepository;
import hello.core.order.application.Interface.OrderServiceInterface;
import hello.core.order.domain.Order;

public class OrderService implements OrderServiceInterface{

    private final MemberRepository memberRepository;
    private final DiscountServiceInterface discountServiceInterface;

    public OrderService(MemberRepository memberRepository, DiscountServiceInterface discountServiceInterface) {
        this.memberRepository = memberRepository;
        this.discountServiceInterface = discountServiceInterface;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = 0;

        if(member.getGrade() == Grade.VIP) {
            discountPrice = (int) (itemPrice * discountServiceInterface.discountRateAmount(member));
        } else {
            discountPrice = discountServiceInterface.discountFixAmount(member);
        }

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
