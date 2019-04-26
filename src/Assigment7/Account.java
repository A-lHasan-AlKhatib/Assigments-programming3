package Assigment7;

import java.io.Serializable;

public class Account implements Serializable, Comparable<Account>{
    
    private int accNo;
    private String accName;
    private float accBalance;

    public Account(int accNo, String accName, float accBalance) {
        this.accNo = accNo;
        this.accName = accName;
        this.accBalance = accBalance;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public float getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }

    @Override
    public String toString() {
        return "Number : " + this.accNo + "\nName : " + this.accName +
                "\nBalance : " + this.accBalance ;
    }


    @Override
    public int compareTo(Account o) {
        return Double.compare(this.getAccBalance(), o.getAccBalance());
    }
    
}