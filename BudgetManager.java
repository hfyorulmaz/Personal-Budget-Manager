package budgetmanager;

import java.util.ArrayList;


public class BudgetManager {

    private ArrayList<Expense> expenseList;

    private String[] categories = {"Food", "Transport", "Utilities", "Entertainment", "Other"};

    public BudgetManager() {
        this.expenseList = new ArrayList<>();
    }

    public String[] getCategories() {
        return categories;
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public boolean isValidCategory(String category) {
        for (String c : categories) {
            if (c.equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }

    public void listAllExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        for (Expense e : expenseList) {
            System.out.println(e);
        }
    }

    public void searchByCategory(String category) {
        boolean found = false;
        for (Expense e : expenseList) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found in category: " + category);
        }
    }

    public double calculateTotalExpense() {
        double total = 0;
        for (Expense e : expenseList) {
            total += e.getAmount();
        }
        return total;
    }

    public Expense findHighestExpense() {
        if (expenseList.isEmpty()) {
            return null;
        }
        Expense highest = expenseList.get(0);
        for (Expense e : expenseList) {
            if (e.getAmount() > highest.getAmount()) {
                highest = e;
            }
        }
        return highest;
    }

    public void printSummary() {
        System.out.println("---- Expense Summary ----");
        System.out.printf("Total Expense: %.2f TL%n", calculateTotalExpense());
        Expense highest = findHighestExpense();
        if (highest != null) {
            System.out.println("Highest Expense: " + highest);
        }
    }
}