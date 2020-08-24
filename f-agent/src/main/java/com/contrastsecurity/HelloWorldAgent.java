package com.contrastsecurity;

import java.lang.instrument.Instrumentation;

public final class HelloWorldAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("STARTED");
        instrumentation.addTransformer(new HelloWorldClassFileTransformer());
    }
}
