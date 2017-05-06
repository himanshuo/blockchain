package com.opensource.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by himanshu on 5/5/17.
 */
public class Internet {
    private static final Logger LOGGER = Logger.getLogger(Internet.class.getName());

    public static final int REWARD = 5;

    private static ArrayList<Miner> miners = new ArrayList<Miner>();
    private Internet(){}    // prevent anyone from creating an internet

    public static void register(Miner miner){
        try {
            miner.ledger = getLedger(miner);
        } catch (CloneNotSupportedException e) {
            LOGGER.log(Level.INFO, e.toString(), e.fillInStackTrace());
            miner.ledger = new Ledger();
        }

        miner.blockchainAddress = new BlockchainAddress(String.valueOf((int)(Math.random() * 10000)));
        miners.add(miner);
    }

    public static ArrayList<Miner> getMinerList(){
        //shuffling makes it so that the order of retrievals is random
        long seed = System.nanoTime();
        Collections.shuffle(miners, new Random(seed));
        return miners;
    }

    public static void reset(){
        miners.clear();
    }

//    public static boolean verify(Transaction t) {
//        int minRequiredValidations = miners.size()/2+1;
//        int curValidations = 0;
//        ArrayList<Miner> hasNotValidated = new ArrayList<Miner>(miners);
//        Collections.shuffle(hasNotValidated);
//        for(int i = 0; i < hasNotValidated.size(); i++) {
//            boolean isValid = hasNotValidated.get(i).validate(t);
//            if(isValid) {
//                curValidations++;
//                if(curValidations == minRequiredValidations) return true;
//            }
//        }
//        return false;
//    }

    public static Ledger getLedger(Miner miner) throws CloneNotSupportedException {

        if(miners.size() == 0) {
            // todo (himanshuo): Genesis block
            Ledger original = new Ledger();
            Transaction originalTransaction = new Transaction(REWARD, null, miner);
            List<Transaction> originalTransactions = new ArrayList<Transaction>();
            originalTransactions.add(originalTransaction);
            Block genesis = new Block(0,originalTransaction, originalTransactions, null);
            original.add(genesis);
            return original;
        }

        int minerNumber = (int)(Math.random() * (miners.size()-1));
        Miner sampleMiner = miners.get(minerNumber);
        return sampleMiner.ledger.clone();
    }

    public static void broadcast(Transaction t) {
        // todo (himanshuo): can only broadcast if transaction t has been validated
        // for(Miner c: miners){
        //     c.ledger.add(t);
        // }
        return;
    }
}