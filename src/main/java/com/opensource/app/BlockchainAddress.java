package com.opensource.app;

/**
 * Created by himanshu on 5/5/17.
 */
public class BlockchainAddress {
    //todo (himanshuo): actual ip address
    //todo (himanshuo): more durable client identification technique?

    //todo (himanshuo): do you add something else to blockchain address?
    String ipaddress;
    public BlockchainAddress(String ip) {
        this.ipaddress = ip;
    }

    public boolean equals(BlockchainAddress other) {
        if(this == other) return true;
        return this.ipaddress.equals(other.ipaddress);
    }

    public BlockchainAddress clone(){
        return new BlockchainAddress(ipaddress);
    }
}

