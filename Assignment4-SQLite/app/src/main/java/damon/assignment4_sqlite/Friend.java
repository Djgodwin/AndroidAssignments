package damon.assignment4_sqlite;

import java.util.UUID;

/**
 * Created by Damon on 3/19/2017.
 */

public class Friend {

    private UUID id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public Friend() {
        this(UUID.randomUUID());
    }

    public Friend(UUID newId) {
        id = newId;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String newEmailAddress) {
        this.emailAddress = newEmailAddress;
    }
}
