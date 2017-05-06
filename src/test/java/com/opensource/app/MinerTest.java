package com.opensource.app;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 5/5/17.
 */
public class MinerTest {

    @Test
    public void constructorRegistersMiner() {
        Miner m = new Miner();
        assertNotNull(m.blockchainAddress);
        assertNotNull(m.ledger);
    }

}