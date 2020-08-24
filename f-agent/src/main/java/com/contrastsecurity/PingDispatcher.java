package com.contrastsecurity;

import java.util.concurrent.atomic.AtomicInteger;

public class PingDispatcher {
    final static AtomicInteger count = new AtomicInteger();
    public static void dispatch() {
        System.out.println(count.incrementAndGet());
    }
}