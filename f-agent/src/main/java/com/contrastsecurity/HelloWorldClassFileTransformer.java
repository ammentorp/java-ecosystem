package com.contrastsecurity;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/*  An agent provides an implementation of this interface in order to
    transform class files. The transformation occurs before the class is
    defined by the JVM.
*/
final class HelloWorldClassFileTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer)
            throws IllegalClassFormatException {

        if("com/contrastsecurity/JerseyEndpoint".equals(className)
                || "com/contrastsecurity/HelloWorld".equals(className)) {
            final ClassReader reader;

            try {
                reader = new ClassReader(new ByteArrayInputStream(classfileBuffer));
            } catch (IOException e) {
                throw new IllegalArgumentException("fail to read class" + className, e);
            }

            final int flags = ClassWriter.COMPUTE_MAXS;
            final ClassWriter writer = new ClassWriter(flags);

            final ClassVisitor visitor = new HelloWorldClassVisitor(writer);

            reader.accept(visitor, 0);
            return writer.toByteArray();
        }

        return classfileBuffer;

    }
}
