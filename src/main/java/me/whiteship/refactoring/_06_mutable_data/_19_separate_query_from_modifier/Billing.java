package me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier;

/**
 * 질의 함수와 변경 함수 분리하기
 * - 명령-조회 분리 규칙
 *  - 어떤 값을 리턴하는 함수는 사이드 이팩트가 없어야 한다
 * -
 */

public class Billing {

    private Customer customer;

    private EmailGateway emailGateway;

    public Billing(Customer customer, EmailGateway emailGateway) {
        this.customer = customer;
        this.emailGateway = emailGateway;
    }

    public double getTotalOutstanding() {
        double result = customer.getInvoices().stream()
                .map(Invoice::getAmount)
                .reduce((double) 0, Double::sum);
        return result;
    }

    public void sendBill() {
        emailGateway.send(formatBill(customer));
    }

    private String formatBill(Customer customer) {
        return "sending bill for " + customer.getName();
    }
}
