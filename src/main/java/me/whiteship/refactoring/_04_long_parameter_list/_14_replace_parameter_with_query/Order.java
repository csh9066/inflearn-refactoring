package me.whiteship.refactoring._04_long_parameter_list._14_replace_parameter_with_query;

/**
 * - 함수의 매개변수 목록은 함수의 다양성을 대변하며, 짧을수록 이해하기 좋다 길면 너무 많은 일을 하고 있을지도?
 * - 어떠한 매개변수를 다른 매개변수로 알아 낼 수 있다면 중복 매개변수라 생각할 수 있다
 * - 매겨변수의 값을 전달하는 것은 "함수의 호출하는 쪽" 즉 사용자 입장이다 사용자 입장에서 최대한 책임을 줄이고 내부에서 책임 지도록
 * 해야한다
 * - "임시 변수를 질의 변수로 바꾸기" 와 "함수 선언 바꾸기"를 통해 리팩토링 한다.
 */

public class Order {

    private int quantity;

    private double itemPrice;

    public Order(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double finalPrice() {
        return this.discountedPrice();
    }

    private int getDiscountLevel() {
        int discountLevel = this.quantity > 100 ? 2 : 1;
        return discountLevel;
    }

    private double getBasePrice() {
        double basePrice = this.quantity * this.itemPrice;
        return basePrice;
    }

    private double discountedPrice() {
        return getDiscountLevel() == 2 ? getBasePrice() * 0.90 : getBasePrice() * 0.95;
    }
}
