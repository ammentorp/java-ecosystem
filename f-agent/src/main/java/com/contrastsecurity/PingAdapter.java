package com.contrastsecurity;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;

public class PingAdapter extends AdviceAdapter {
    public PingAdapter(MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(ASM8, methodVisitor, access, name, descriptor);

    }

    @Override
    public void onMethodEnter() {
        final Method method = Method.getMethod("void dispatch()");
        invokeStatic(Type.getType(PingDispatcher.class), method);
    }
}
