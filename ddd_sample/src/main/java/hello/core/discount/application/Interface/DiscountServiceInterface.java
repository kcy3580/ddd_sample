package hello.core.discount.application.Interface;

import hello.core.member.domain.Member;

public interface DiscountServiceInterface {
    int discountFixAmount(Member member);
    double discountRateAmount(Member member);
}
