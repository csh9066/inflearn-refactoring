package me.whiteship.refactoring._04_long_parameter_list._01_before;

/**
 * 긴 매개변수 목록
 * - 어떤 함수의 매개변수가 많을 수록 함수의 역할을 이해하기 어렵다
 *  - 과연 그 함수가 한가지 일만 하고 있는 거인가?
 *  - 불필요한 매개변수는 없는가?
 *  - 하나의 자료구조로 뭉칠 수 있는가
 */

public class Order {

    private int quantity;

    private double itemPrice;

    public Order(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double finalPrice() {
        double basePrice = this.quantity * this.itemPrice;
        int discountLevel = this.quantity > 100 ? 2 : 1;
        return this.discountedPrice(basePrice, discountLevel);
    }

    private double discountedPrice(double basePrice, int discountLevel) {
        return discountLevel == 2 ? basePrice * 0.9 : basePrice * 0.95;
    }
}
