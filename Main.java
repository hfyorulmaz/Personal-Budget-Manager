package budgetmanager;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetManager manager = new BudgetManager();
        boolean running = true;

        while (running) {
            printMenu();

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Hata: Lutfen sadece sayisal bir deger girin (1-5).");
                scanner.nextLine(); 
                continue;
            }
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addExpense(scanner, manager);
                    break;
                case 2:
                    manager.listAllExpenses();
                    break;
                case 3:
                    System.out.print("Aranacak kategori: ");
                    String searchCategory = scanner.nextLine();
                    manager.searchByCategory(searchCategory);
                    break;
                case 4:
                    manager.printSummary();
                    break;
                case 5:
                    running = false;
                    System.out.println("Program sonlandiriliyor...");
                    break;
                default:
                    System.out.println("Gecersiz secim! Lutfen 1 ile 5 arasinda bir deger girin.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== Kisisel Butce Yoneticisi =====");
        System.out.println("1. Gider Ekle");
        System.out.println("2. Giderleri Listele");
        System.out.println("3. Kategoriye Gore Gider Ara");
        System.out.println("4. Toplam Harcama Ozetini Goster");
        System.out.println("5. Cikis");
        System.out.print("Seciminiz: ");
    }

    private static void addExpense(Scanner scanner, BudgetManager manager) {
        try {
            System.out.print("Aciklama: ");
            String description = scanner.nextLine();

            System.out.print("Tutar (sadece sayi, ornek: 150.50): ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Hata: Tutar alaninda gecersiz karakter girdiniz. Islem iptal edildi.");
                return;
            }

            System.out.print("Kategori (Food, Transport, Utilities, Entertainment, Other): ");
            String category = scanner.nextLine();

            if (!manager.isValidCategory(category)) {
                System.out.println("Uyari: Gecersiz kategori girildi, 'Other' olarak ayarlandi.");
                category = "Other";
            }

            Expense expense = new Expense(description, amount, category);
            manager.addExpense(expense);
            System.out.println("Gider basariyla eklendi -> " + expense);

        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}