package com.opensource.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by himanshu on 5/4/17.
 */
public class Ledger {
    public List<Block> blocks;

    public Ledger() {
        blocks = new ArrayList<Block>();
    }

    public boolean equals(Ledger other){
        return blocks.equals(other.blocks);
    }

    public boolean add(Block block) throws IllegalArgumentException {
        if(this.blocks.contains(block)) throw new IllegalArgumentException();
        this.blocks.add(block);
        return true;
    }

    protected Ledger clone() throws CloneNotSupportedException {
        Ledger ledgerClone = new Ledger();
        for(Block block: blocks) {
            Block blockClone = block.clone();
            ledgerClone.add(blockClone);
        }
        return ledgerClone;
    }

}
