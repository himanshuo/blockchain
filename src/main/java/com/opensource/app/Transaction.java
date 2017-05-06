package com.opensource.app;

/**
 * Created by himanshu on 5/4/17.
 */
public class Transaction {
    public int amount;
    public Miner from;
    public Miner to;

    public Transaction(int amount, Miner from, Miner to) {

    }

    protected Transaction clone() throws CloneNotSupportedException {
        return new Transaction(amount, from, to);
    }
}
