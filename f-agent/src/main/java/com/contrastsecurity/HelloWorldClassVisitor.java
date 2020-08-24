package com.contrastsecurity;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM8;

public final class HelloWorldClassVisitor extends ClassVisitor {

    HelloWorldClassVisitor(final ClassVisitor classVisitor) {
        super(ASM8, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(
            final int access,
            final String name,
            final String descriptor,
            final String signature,
            final String[] exceptions) {

        final MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);

        if ("png".equals(name)) {
            return new PingAdapter(mv, access, name, descriptor);
        } else {
            return new HelloWorldMethodVisitor(mv);
        }
    }
}
