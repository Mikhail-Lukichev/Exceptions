import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void checkData(String login, String password, String confirmPassword) {
        // check login
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9_]");
        Matcher matcher = pattern.matcher(login);
        boolean matchFound = matcher.find();
        if (login.length() > 20 || matchFound) {
            throw new WrongLoginException();
        }

        // check password
        pattern = Pattern.compile("[^a-zA-Z0-9_]");
        matcher = pattern.matcher(password);
        matchFound = matcher.find();
        if (password.length() > 20 || matchFound || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }

        System.out.println("Login: " + login + "; password: " + password);
    }

    public static void main(String[] args) {
        String login = "L0g1n_";
        String password = "pass_w0rD";
        String confirmPassword = "pass_w0rD";
        try {
            checkData(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Incorrect login");
        } catch (WrongPasswordException e) {
            System.out.println("Incorrect password");
        } finally {
            System.out.println("Data is checked");
        }
    }
}