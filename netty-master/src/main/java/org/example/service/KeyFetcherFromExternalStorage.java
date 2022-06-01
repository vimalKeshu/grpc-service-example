package org.example.service;

import java.util.Random;

public class KeyFetcherFromExternalStorage {
    private static Random random = new Random();
    public static long get(){
        return random.nextLong();
    }
}
