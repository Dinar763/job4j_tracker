package ru.job4j.ex;

import java.util.Arrays;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid()) {
            throw new UserInvalidException("Пользователь не валиден");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Имя пользователя слишком коротокое");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
            new User("Petr Arsentev", true),
            new User("Anna Ivanova", false),
            new User("Iv", true)
        };
        try {
            User user = findUser(users, "Iv");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}