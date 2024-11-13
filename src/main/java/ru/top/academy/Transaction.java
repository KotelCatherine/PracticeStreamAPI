package ru.top.academy;

public class Transaction {
    private String product;
    private int quantity;
    private double unitPrice;

    public Transaction(String product, int quantity, double unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

}
