package Utilites;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

public class Console {
    static Scanner in = new Scanner(System.in);

    public static int getClientPort() {
        int port = -10;
        try {
            while (port == -10) {
                System.out.print("Укажите порт:\n$ ");
                String s = in.nextLine();
                port = Integer.parseInt(s);
                if (port > 0 || port < 65536) return port;
                else return getClientPort();
            }
            return port;
        } catch (Exception e) {
            return getClientPort();
        }
    }

    public HashMap register() throws NoSuchAlgorithmException {
        System.out.print("log\\sign:\n$ ");
        //String s = in.nextLine();
        String s = "log";
        if (s.equals("log") || s.equals("sign")) {
            HashMap loginAndPassword = this.getLoginAndPassword();
            loginAndPassword.put("reg", s);
            return loginAndPassword;
        } else return this.register();
    }


    public HashMap getLoginAndPassword() throws NoSuchAlgorithmException {
        HashMap loginAndPassword = new HashMap();
        loginAndPassword.put("login", this.getLogin());
        loginAndPassword.put("password", this.getPassword());
        return loginAndPassword;
    }

    public String getLogin() {
        System.out.print("Укажите логин:\n$ ");
        //String login = in.nextLine();
        String login = "1";
        if (login.equals("")) return getLogin();
        return login;
    }

    public String getPassword() throws NoSuchAlgorithmException {
        System.out.print("Укажите пароль:\n$ ");
        //String password = in.nextLine();
        String password = "1";
        if (password.equals("")) return getPassword();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

