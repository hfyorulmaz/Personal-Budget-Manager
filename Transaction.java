package budgetmanager;

import java.time.LocalDate;


public abstract class Transaction {

    private static int idCounter = 1;

    private final int id;
    private String description;
    private double amount;
    private LocalDate date;

    public Transaction(String description, double amount) {
        this.id = idCounter++;
        setDescription(description);
        setAmount(amount);
        this.date = LocalDate.now();
    }

    public Transaction(String description, double amount, LocalDate date) {
        this.id = idCounter++;
        setDescription(description);
        setAmount(amount);
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("[#%d] %s | %.2f TL | %s", id, description, amount, date);
    }
}