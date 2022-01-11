package manager;


import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookManager {
    public static final String PATH_PHONE = "src/file/phonebook.txt";
    private  final ArrayList<PhoneBook> phoneBooks = new ArrayList<>();
    public final Scanner scanner = new Scanner(System.in);

    public void displayAll() {
        for (PhoneBook phoneBook  : phoneBooks) {
            System.out.println(phoneBook);
        }
    }

    public String getGender(int choice) {
        String gender = "";
        switch (choice) {
            case 1:
                gender = "NAM";
                break;
            case 2:
                gender = "NỮ";
                break;
            case 3:
                gender = "OTHER";
                break;
        }
        return gender;
    }


    public void addPhone() {
        System.out.println("Nhập số điện thoại ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập nhóm");
        String group = scanner.nextLine();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Chọn giới tính");
        System.out.println("1. NAM");
        System.out.println("2. NỮ");
        System.out.println("3. KHÁC");
        int gender = scanner.nextInt();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String birth = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        PhoneBook phoneBook = new PhoneBook(phoneNumber, group, name, getGender(gender), address, birth, email);
        phoneBooks.add(phoneBook);
        writeToFile(PATH_PHONE);
        System.out.println("Thêm thành công");
    }

    public void editPhone(String phone) {
        PhoneBook editPhoneBook = null;
        for (PhoneBook phonebook : phoneBooks) {
            if (phonebook.getPhoneNumber().equals(phone)) {
                editPhoneBook = phonebook;
            }
        }
        if (editPhoneBook != null) {
            System.out.println("Nhập số điện thoại mới");
            String phoneNumber = scanner.nextLine();
            editPhoneBook.setPhoneNumber(phoneNumber);
            System.out.println("Nhâp nhóm mới");
            String group = scanner.nextLine();
            editPhoneBook.setGroup(group);
            System.out.println("Nhập tên mới");
            String name = scanner.nextLine();
            editPhoneBook.setName(name);
            System.out.println("Chọn giới tính");
            System.out.println("1. NAM");
            System.out.println("2. NỮ");
            System.out.println("3. KHÁC");
            int gender = scanner.nextInt();
            editPhoneBook.setGender(getGender(gender));
            System.out.println("Nhập địa chỉ");
            String address = scanner.nextLine();
            editPhoneBook.setAddress(address);
            System.out.println("Nhập ngày sinh");
            String birth =scanner.nextLine();
            editPhoneBook.setBirth(birth);
            System.out.println("Nhập email");
            String email = scanner.nextLine();
            editPhoneBook.setEmail(email);
            writeToFile(PATH_PHONE);
        }
    }

    public void deletePhone(String phone) {
        PhoneBook phoneBook = null;
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phone)) {
                phoneBook = p;
            }
        }
        if (phoneBook != null) {
            phoneBooks.remove(phoneBook);
            System.out.println("Xóa Thành Công");
        } else {
            System.out.println("Không tìm thấy số điện thoại này");
        }
    }

    public void searchPhone(String phone) {
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phoneBooks)) {
                System.out.println(p);
            }
        }
    }


    public void writeToFile(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
                for (PhoneBook phoneBook : phoneBooks) {
                    bufferedWriter.write(phoneBook.getPhoneNumber() + "," + phoneBook.getGroup() + "," + phoneBook.getName() + "," + phoneBook.getGender() + "," + phoneBook.getAddress()  + "\n");
                }
                bufferedWriter.flush();
                bufferedWriter.close();
                System.out.println("Đã ghi file");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PhoneBook> readFile(String path) {
        ArrayList<PhoneBook> phoneBooks = new ArrayList<>();
        File file = new File(PATH_PHONE);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                phoneBooks.add(new PhoneBook(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]));
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return phoneBooks;
    }
}
