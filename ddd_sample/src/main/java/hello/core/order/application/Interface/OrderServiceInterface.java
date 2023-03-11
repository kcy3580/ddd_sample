package hello.core.order.application.Interface;

import hello.core.order.domain.Order;

public interface OrderServiceInterface {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
