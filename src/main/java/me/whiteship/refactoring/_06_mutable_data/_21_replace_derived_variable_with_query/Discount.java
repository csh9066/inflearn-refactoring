package me.whiteship.refactoring._06_mutable_data._21_replace_derived_variable_with_query;

/**
 * 파생 변수를 질의 함수로 바꾸기
 * - 변경할 수 있는 데이터를 최대한 줄이도록 노력해야 한다
 * - 계산해서 알아낼 수 있는 변수는 제거할 수 있다
 *  - 해당 변수가 어디선가 잘못된 값으로 수정될 수 있는 가능성을 제거할 수 있다
 *  - 계산 자체가 데이터의 의미를 잘 표현하는 경우도 있다
 * - 계산에 필요한 데이터가 불변 값이라면 계산 결과의 해당하는 데이터 역시 불변 값이기때문 유지가 가능하다.
 */

public class Discount {

    private double discount;

    private double baseTotal;

    public Discount(double baseTotal) {
        this.baseTotal = baseTotal;
    }

    public double calculateDiscountedTotal() {
        return this.baseTotal - this.discount;
    }

    public void setDiscount(double number) {
        this.discount = number;
    }
}
