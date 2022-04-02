package me.whiteship.refactoring._06_mutable_data._18_split_variable;

/**
 * 변수 쪼개기
 * - 어떤 변수가 여러번 재할당 되어도 적절한 경우
 *  - 반복문에서 순회하는데 사용하는 변수 또는 인덱스
 *  - 값을 축적시키는데 사용하는 변수
 *
 * - 그 밖에 경우에 재할당 되는 변수가 있다면 해당 변수는 여러 용도로 사용되는 것이며 변수를 분리해야 더 이해하기 좋은 코드로 만들 수 있다
 *  - 변수 하나당 하나의 책임만 지도록 만든다
 *  - 상수를 활용하자
 */

public class Haggis {

    private double primaryForce;
    private double secondaryForce;
    private double mass;
    private int delay;

    public Haggis(double primaryForce, double secondaryForce, double mass, int delay) {
        this.primaryForce = primaryForce;
        this.secondaryForce = secondaryForce;
        this.mass = mass;
        this.delay = delay;
    }

    public double distanceTravelled(int time) {
        double result;
        final double primaryAcc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;

        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            final double primaryVelocity = primaryAcc * delay;
            final double secondAcc = (primaryForce + secondaryForce) / mass;
            result += primaryVelocity * secondaryTime + 0.5 * secondAcc * secondaryTime + secondaryTime;
        }

        return result;
    }
}
