package validate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    static Scanner scanner = new Scanner(System.in);

    public static String validatePhoneNumber() {
        String phone;
        String regex = "^(0|\\+84)(\\s|\\.)?(\\d{9,11}+)$";
        while (true) {
            System.out.println("Input PhoneNumber");
            try {
                phone = scanner.nextLine();
                if (phone.matches(regex)) {
                    break;
                } else {
                    System.err.println("Mời nhập lại");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return phone;
    }

    public static String validateEmail() {
        String email;
        String regex = "^[A-Za-z]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        while (true) {
            System.out.println("Input Email");
            try {
                email = scanner.nextLine();
                if (email.matches(regex)) {
                    break;
                } else {
                    System.err.println("Email sai định dạng");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return email;
    }
}
