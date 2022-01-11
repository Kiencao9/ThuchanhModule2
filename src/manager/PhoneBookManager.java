package manager;


import model.PhoneBook;
import validate.Validate;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookManager {
    public static final String PATH_PHONE = "src/file/phonebook.csv";
    private  final ArrayList<PhoneBook> phoneBooks;
    public final Scanner scanner = new Scanner(System.in);

    public PhoneBookManager() {
        if (new File(PATH_PHONE).length() == 0) {
            this.phoneBooks = new ArrayList<>();
        } else {
            this.phoneBooks = readFile(PATH_PHONE);
        }
    }

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
        scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String birth = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        PhoneBook phoneBook = new PhoneBook(phoneNumber, group, name, getGender(gender), address, birth, email);
        phoneBooks.add(phoneBook);
        writeToFile(PATH_PHONE);
        System.out.println("Thêm thành công");
    }

    public void editPhone() {
        System.out.println("Nhập SĐT muốn sửa");
        String phone = scanner.nextLine();
        PhoneBook editPhoneBook = null;
        for (PhoneBook phonebook : phoneBooks) {
            if (phonebook.getPhoneNumber().equals(phone)) {
                editPhoneBook = phonebook;
            }
        }
        if (editPhoneBook != null) {
            String phoneNumber = Validate.validatePhoneNumber();
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
            String email = Validate.validateEmail();
            editPhoneBook.setEmail(email);
            writeToFile(PATH_PHONE);
        }
    }

    public void deletePhone() {
        System.out.println("Nhập SĐT muốn xóa");
        String phone =scanner.nextLine();
        PhoneBook phoneBook = null;
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phone)) {
                phoneBook = p;
            }
        }
        if (phoneBook != null) {
            System.out.println("Bạn chắc chắn muốn xóa");
            System.out.println("Nhập Y để xóa");
            System.out.println("Nhập bất kì để thoát");
            String deleteY = scanner.nextLine();
            if (deleteY.equals("Y")) {
                phoneBooks.remove(phoneBook);
                writeToFile(PATH_PHONE);
                System.out.println("Xóa Thành Công");
            }

        } else {
            System.out.println("Không tìm thấy số điện thoại này");
        }
    }

    public void searchPhone() {
        System.out.println("Nhập SĐT muốn tìm");
        String phone = scanner.nextLine();
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phone)) {
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
                    bufferedWriter.write(phoneBook.getPhoneNumber() + "," + phoneBook.getGroup() + "," + phoneBook.getName() + "," + phoneBook.getGender() + "," + phoneBook.getAddress()  + "," + phoneBook.getBirth() + "," + phoneBook.getEmail()  + "\n");
                }
                bufferedWriter.flush();
                bufferedWriter.close();
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
