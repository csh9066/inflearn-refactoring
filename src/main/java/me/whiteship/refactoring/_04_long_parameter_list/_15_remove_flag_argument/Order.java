package me.whiteship.refactoring._04_long_parameter_list._15_remove_flag_argument;

import java.time.LocalDate;

/**
 * - 플래그는 보통 함수에 매개변수로 전달해서, 함수 내부 로직을 분기하는데 사용한다
 * - 플래그를 사용하는 함수는 차이를 파악하기 힘들다
 * - 플래그 매개변수를 사용하지말고 함수를 분리해서 알맞는 이름을 정해주자
 * - 나의 추가 생각) 요거 다형성으로 분리해도 괜찮을거 같다 둘다 고민 해보자
 */

public class Order {

    private LocalDate placedOn;
    private String deliveryState;

    public Order(LocalDate placedOn, String deliveryState) {
        this.placedOn = placedOn;
        this.deliveryState = deliveryState;
    }

    public LocalDate getPlacedOn() {
        return placedOn;
    }

    public String getDeliveryState() {
        return deliveryState;
    }
}
