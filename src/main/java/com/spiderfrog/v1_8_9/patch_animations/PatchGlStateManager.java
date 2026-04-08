package com.spiderfrog.v1_8_9.patch_animations;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PatchGlStateManager
        extends ClassVisitor implements Opcodes {
    public PatchGlStateManager(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public void visitEnd() {
        MethodVisitor mv = this.cv.visitMethod(9, "translateClear", "(FFF)V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(430, l0);
        mv.visitInsn(177);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLocalVariable("x", "F", null, l0, l1, 0);
        mv.visitLocalVariable("y", "F", null, l0, l1, 1);
        mv.visitLocalVariable("z", "F", null, l0, l1, 2);
        mv.visitMaxs(0, 3);
        mv.visitEnd();
        super.visitEnd();
    }
}


