package me.whiteship.refactoring._02_duplicated_code._06_pull_up_method;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 메소드 올리기
 Why ?
 중복 코드를 함수로 쪼개지 않을경우 미래에 버그를 만들어낼 빌미 제공
 A에서 코드를 고치고 B에는 반영X boom
 - 중복되는 메서드를 상위 클래스의 메서드로 옮겨 위임한다
 */
public class Dashboard {

    public static void main(String[] args) throws IOException {
        ReviewerDashboard reviewerDashboard = new ReviewerDashboard();
        reviewerDashboard.printReviewers();

        ParticipantDashboard participantDashboard = new ParticipantDashboard();
        participantDashboard.printParticipants(15);
    }

    protected void printUsernames(int eventId) throws IOException {
        // Get github issue to check homework
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);

        // Get usernames
        Set<String> usernames = new HashSet<>();
        issue.getComments().forEach(c -> usernames.add(c.getUserName()));

        // Print usernames
        usernames.forEach(System.out::println);
    }
}
