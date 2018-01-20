package com.example.chuyi.pairwise_key_calc;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by chuyi on 2018-01-18.
 */

public class Polynomial {
    public static BigInteger eval(BigInteger[] poly, BigInteger i){
        BigInteger result = BigInteger.ZERO;

        for(int j = poly.length-1;j>=1;j--){
            result = result.add(poly[j].multiply(i).add(poly[j-1]));
        }

        return result;
    }

    public static BigInteger[] partial_eval(BigInteger[][] poly, BigInteger i){
        int degree = poly[0].length-1;
        BigInteger[] result = new BigInteger[degree+1];
        for (int j = 0; j < degree+1; j++) {
            result[j] = eval(poly[j],i);
        }
        return result;
    }
    public static BigInteger genRand(BigInteger p){
        Random rand = new Random();
        BigInteger result = new BigInteger(p.bitLength(), rand);
        while( result.compareTo(p) >= 0 ) {
            result = new BigInteger(p.bitLength(), rand);
        }
        return result;
    }

}
