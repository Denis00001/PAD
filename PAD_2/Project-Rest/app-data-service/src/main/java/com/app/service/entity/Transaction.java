
package com.app.service.entity;
import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("transaction")
public class Transaction {
    
    @XStreamAlias("transactionId")
    private int transactionId;
    
    @XStreamAlias("ownerName")
    private String ownerName;
   
    @XStreamAlias("accountNumber")
    private long accountNumber;
    
    private String transactionFormat;

    public Transaction(int transactionId, String ownerName, long accountNumber, String transactionFormat) {
        this.transactionId = transactionId;
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.transactionFormat = transactionFormat;
    }

    public Transaction() {
    }   
    
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionFormat() {
        return transactionFormat;
    }

    public void setTransactionFormat(String transactionFormat) {
        this.transactionFormat = transactionFormat;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", ownerName=" + ownerName + ", accountNumber=" + accountNumber + ", transactionFormat=" + transactionFormat + '}';
    }
    
    
    
}
