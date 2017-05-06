package com.opensource.app;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by himanshu on 5/5/17.
 */
public class ClientTest {
    @Test
    public void testBasicSend() {
        Client a = new Client(8);
        Client b = new Client(2);

        a.send(b, 4);

        assertEquals(4, a.coins);
        assertEquals(6, b.coins);
        assertEquals(a.ledger, b.ledger);
    }
}