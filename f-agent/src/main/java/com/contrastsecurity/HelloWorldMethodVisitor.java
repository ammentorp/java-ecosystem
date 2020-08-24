package com.contrastsecurity;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM8;

public final class HelloWorldMethodVisitor extends MethodVisitor {

    HelloWorldMethodVisitor(final MethodVisitor methodVisitor) {
        super(ASM8, methodVisitor);
    }

    @Override
    public void visitLdcInsn(final Object value) {
        final Object newValue =
                "Hello World".equals(value)
                ? ":wave: hello, world!" : value;

//        System.out.println("wtf am i doing");

        // Visits a LDC instruction
        // LDC instr: Load Coprocessor instr, loads mem data from addresses in
        // addr_mode to coprocessor cpname
        super.visitLdcInsn(newValue);
    }
}
