package com.opensource.app;

import java.util.logging.Logger;

/**
 * Created by himanshu on 5/5/17.
 */
public class Miner {
    private static final Logger LOGGER = Logger.getLogger(Miner.class.getName());

    public BlockchainAddress blockchainAddress;
    public Ledger ledger;
    BlockchainAddress addr;

    public Miner(){
        Internet.register(this);
    }

}
