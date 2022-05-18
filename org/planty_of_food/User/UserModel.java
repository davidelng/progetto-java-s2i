package org.planty_of_food.User;

public class UserModel {
    private int userID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String documentID;

    public UserModel(
            int userID,
            String firstName,
            String lastName,
            String dateOfBirth,
            String address,
            String documentID) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.documentID = documentID;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDocumentID() {
        return this.documentID;
    }
}
