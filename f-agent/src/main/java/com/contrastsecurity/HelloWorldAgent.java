package com.contrastsecurity;

import java.lang.instrument.Instrumentation;

public final class HelloWorldAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        instrumentation.addTransformer(new HelloWorldClassFileTransformer());

    }
}
