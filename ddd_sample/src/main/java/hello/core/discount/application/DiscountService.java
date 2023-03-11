package hello.core.discount.application;

import hello.core.discount.application.Interface.DiscountServiceInterface;
import hello.core.discount.domain.Discount;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;

public class DiscountService implements DiscountServiceInterface {

    @Override
    public int discountFixAmount(Member member) {
        Discount discount = new Discount();

        return discount.getDiscountFixAmount();
    }

    @Override
    public double discountRateAmount(Member member) {
        Discount discount = new Discount();

        if(member.getGrade() == Grade.VIP) {
            discount.setDiscountRate(0.1);
            return discount.getDiscountRate();
        } else {
            return 0;
        }
    }

}
