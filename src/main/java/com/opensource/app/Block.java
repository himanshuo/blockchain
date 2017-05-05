package com.opensource.app;

import java.util.List;

/**
 * Created by himanshu on 5/4/17.
 */
public class Block {
    public int blockNumber;
    public int nonce;
    public Transaction coinbase;
    public List<Transaction> transactions;
    Hash previous;
    Hash current;

    public Block(int blockNumber, Transaction coinbase, List<Transaction> transactions, Hash previous) {
        this.blockNumber = blockNumber;
        this.coinbase = coinbase;
        this.transactions = transactions;
        this.previous = previous;
    }

    public int mine() throws java.security.NoSuchAlgorithmException, java.io.IOException {
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            this.nonce = i;
            Hash temp = calculateSelfHash();
            if(valid(temp, 2)) {
                return this.nonce;
            }
        }
        return -1;
    }

    private boolean valid(Hash cur, int difficulty){
        for(int i = 0; i < difficulty; i++) {
            if (0x0 != cur.hash[i]) return false;
        }
        return true;
    }

    public Hash calculateSelfHash() throws java.security.NoSuchAlgorithmException, java.io.IOException {
        StringBuilder selfString = new StringBuilder();
        selfString.append(blockNumber);
        selfString.append(nonce);
        selfString.append(coinbase.toString());
        for(Transaction transaction: transactions) {
            selfString.append(transaction.toString());
        }
        selfString.append(previous);
        Hash hash = new Hash(selfString.toString());
        this.current = hash;
        return hash;
    }
}
