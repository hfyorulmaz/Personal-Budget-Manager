package budgetmanager;

import java.time.LocalDate;


public class Expense extends Transaction {

    private String category;

    public Expense(String description, double amount) {
        super(description, amount);
        this.category = "Other";
    }

    public Expense(String description, double amount, String category) {
        super(description, amount);
        setCategory(category);
    }

    public Expense(String description, double amount, String category, LocalDate date) {
        super(description, amount, date);
        setCategory(category);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            this.category = "Other";
        } else {
            this.category = category;
        }
    }

    @Override
    public String getType() {
        return "Expense";
    }

    @Override
    public String toString() {
        return super.toString() + " | Category: " + category;
    }
}