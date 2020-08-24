package com.contrastsecurity;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class JerseyEndpointAdapter extends AdviceAdapter {
    JerseyEndpointAdapter(final MethodVisitor methodVisitor,
                          final int access,
                          final String name,
                          final String descriptor) {
        super(ASM8, methodVisitor, access, name, descriptor);
    }

    @Override
    protected void onMethodEnter() {
        // pass instance to ASM and load to stack
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        // loading and is put on stack (this is print stream)
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        // push string "" onto stack
        push("ping message");
        // invoke method
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream",
                "println", "(Ljava/lang/String;)V", false);
    }

}
