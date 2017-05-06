package com.opensource.app;

import java.util.List;

/**
 * Created by himanshu on 5/4/17.
 */
public class Client extends Miner {

    int coins;

    public Client(int coins) {
        //todo: coinbase for this
        this.coins = coins;
    }

    public boolean send(Client other, int amount) {
        this.coins -= amount;
        other.coins += amount;
        return true;
    }

}
