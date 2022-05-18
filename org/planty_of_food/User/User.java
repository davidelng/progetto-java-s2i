package org.planty_of_food.User;

import java.util.ArrayList;

public class User {

    private ArrayList<UserModel> data;

    public User() {
        this.data = UserService.readUsers();
    }

    public ArrayList<UserModel> getUsers() {
        return this.data;
    }

}
