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
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    phoneBookManager.displayAll();
                    break;
                case 2:
                    phoneBookManager.addPhone();
                    break;
                case 3:
                    phoneBookManager.editPhone();
                    break;
                case 4:
                    phoneBookManager.deletePhone();
                    break;
                case 5:

                    phoneBookManager.searchPhone();
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
