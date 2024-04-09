package com.kessie.EventManagementSystem.Module;

import com.kessie.EventManagementSystem.PaymentStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @Column(nullable = false)
    private double amount;

    public Payment(User user, double amount, String paymentMethod, long transactionId, PaymentStatus paymentStatus) {
        this.user = user;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
    }

    @Column(nullable = false)
    private String paymentMethod;
    @Column(nullable = false)
    private long transactionId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private PaymentStatus paymentStatus;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date paymentDate;

    public Payment() {
    }

    public Payment(long paymentId, User user, double amount, String paymentMethod, long transactionId, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.user = user;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
        this.paymentDate = new Date();
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
