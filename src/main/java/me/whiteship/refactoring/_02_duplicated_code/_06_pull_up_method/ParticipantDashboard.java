package me.whiteship.refactoring._02_duplicated_code._06_pull_up_method;

import java.io.IOException;

public class ParticipantDashboard extends Dashboard {

    public void printParticipants(int eventId) throws IOException {
        printUsernames(eventId);
    }

}
