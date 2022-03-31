package me.whiteship.refactoring._03_long_function._09_preserve_whole_object;

import java.util.HashMap;
import java.util.Map;

public record Participant(String username, Map<Integer, Boolean> homework) {
    public Participant(String username) {
        this(username, new HashMap<>());
    }

    public void setHomeworkDone(int index) {
        this.homework.put(index, true);
    }
    
    // getRate는 Particpant에서 계산 하는게 적절하다고 생각해 SutdyBoard에서 빼서 위임 함
    double getRate(int totalNumberOfEvents) {
        long count = homework.values().stream()
                .filter(v -> v == true)
                .count();
        return (double) (count * 100 / totalNumberOfEvents);
    }
}
