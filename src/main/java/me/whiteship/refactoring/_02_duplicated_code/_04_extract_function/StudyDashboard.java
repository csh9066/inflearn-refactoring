package me.whiteship.refactoring._02_duplicated_code._04_extract_function;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Rule
 * 1. "의도" 와 "구현"을 분리하라
 * 코드를 읽을 때 어떤 일을 하는지 잘 이해가 안된다면 구현이라고 볼 수 있음
 * 의도를 잘 나타나게 메소드를 쪼개자
 *
 * 2. 무슨 일을 하는지 알아낼려 해라
 * 무슨 일을 하는 코드인지 알아내려고 노력해야 해당 코드를 분리하고 함수 이름으로 "무슨 일을 하는지" 표현 할 수 잇다.
 *
 * 3. 잘 모르면 주석으로 작성해봐라
 * 거대한 함수 안에들어 있는 함수를 추출하는데 좋은 단서가 될 수 있다.
 */
public class StudyDashboard {
    
    // 의도
    private void printParticipants(int eventId) throws IOException {
        GHIssue issue = getGhIssue(eventId);
        Set<String> participants = getUsernames(issue);
        print(participants);
    }

    private void printReviewers() throws IOException {
        GHIssue issue = getGhIssue(30);
        Set<String> reviewers = getUsernames(issue);
        print(reviewers);
    }
    
    
    //구현
    private void print(Set<String> participants) {
        participants.forEach(System.out::println);
    }

    private Set<String> getUsernames(GHIssue issue) throws IOException {
        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));
        return participants;
    }

    private GHIssue getGhIssue(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);
        return issue;
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }

}
