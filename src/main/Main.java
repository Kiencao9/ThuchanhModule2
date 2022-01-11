package main;

import manager.PhoneBookManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("**********  MENU  **********");
            System.out.println(" 1. Hiển thị danh bạ");
            System.out.println(" 2. Thêm mới danh bạ");
            System.out.println(" 3. Cập nhật danh bạ");
            System.out.println(" 4. Xóa danh bạ");
            System.out.println(" 5. Tìm kiếm danh bạ");
            System.out.println(" 6. Ghi File CSV");
            System.out.println(" 7. Đọc File CSV");
            System.out.println(" 0. Quay lại");
            System.out.println("Nhập lựa chọn");
            try {
                choice = scanner.nextInt();
                while (choice < 0 || choice > 8) {
                    System.err.println("Chỉ nhập số từ 0 đến 7");
                    choice = scanner.nextInt();
                }
            } catch (Exception e) {
                System.err.println("Chỉ được nhập số");
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    phoneBookManager.displayAll();
                    break;
                case 2:
                    phoneBookManager.addPhone();
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại muốn sửa");
                    String phoneNumber1 = scanner.nextLine();
                    phoneBookManager.editPhone(phoneNumber1);
                    break;
                case 4:
                    System.out.println("Nhập số điện thoại muốn xóa");
                    String phoneNumber2 = scanner.nextLine();
                    phoneBookManager.deletePhone(phoneNumber2);
                    break;
                case 5:
                    System.out.println("Nhập số điện thoại muốn tìm");
                    String phoneNumber3 = scanner.nextLine();
                    phoneBookManager.searchPhone(phoneNumber3);
                    break;
                case 6:
                    phoneBookManager.writeToFile(PhoneBookManager.PATH_PHONE);
                    break;
                case 7:
                    phoneBookManager.readFile(PhoneBookManager.PATH_PHONE);
                    break;
            }
        } while (choice != 0);
    }
}
