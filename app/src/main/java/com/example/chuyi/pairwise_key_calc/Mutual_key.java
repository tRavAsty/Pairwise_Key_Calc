package com.example.chuyi.pairwise_key_calc;

import java.math.BigInteger;

/**
 * Created by chuyi on 2018-01-18.
 */

public class Mutual_key {
    BigInteger[] ss1;
    BigInteger[] ss2;
    BigInteger N = new BigInteger("1651014017234078219306489679224697566781389948766447359041102566541304081297844984355280457082850533196815765198041036324788484206021796692047526937865268027145875500237163433253608490495477414595123235269795249781913474790889144327664892239531627026748319346481708098222208337645466635304462615126722457457");
    public Mutual_key(String ss1, String ss2){
        String[] str_ss1 = ss1.split(" ");
        String[] str_ss2 = ss2.split(" ");
        this.ss1 = new BigInteger[str_ss1.length];
        this.ss2 = new BigInteger[str_ss2.length];

        for (int i = 0; i < this.ss1.length; i++) {
            this.ss1[i] = new BigInteger(str_ss1[i]);
            this.ss2[i] = new BigInteger(str_ss2[i]);
        }
    }
    public String keys_eval(int size){
        BigInteger x,y;
        long start = System.currentTimeMillis();
        for (int i = 1; i < size+1; i++) {
            y = Polynomial.eval(ss1,BigInteger.valueOf(i)).multiply(Polynomial.eval(ss2,BigInteger.valueOf(i))).mod(N);
        }
        long stop = System.currentTimeMillis();
        return "("+size+", "+(float)(stop-start)/1000+" ) s";
    }

}
