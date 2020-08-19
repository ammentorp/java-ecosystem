package com.contrastsecurity;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;

public final class HelloWorldClassVisitor extends ClassVisitor {

    HelloWorldClassVisitor(final ClassVisitor classVisitor) {
        super(ASM5, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(
            final int access,
            final String name,
            final String descriptor,
            final String signature,
            final String[] exceptions) {

        final MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);

        return new HelloWorldMethodVisitor(mv);

    }

}
