package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;


public class PatchFontRenderer
        extends ClassVisitor {
    public PatchFontRenderer(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public void visitEnd() {
        MethodVisitor mv = this.cv.visitMethod(1, "drawStringDebug", "(Ljava/lang/String;III)I", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(273, l0);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 1);
        mv.visitVarInsn(21, 2);
        mv.visitInsn(134);
        mv.visitVarInsn(21, 3);
        mv.visitInsn(134);
        mv.visitVarInsn(21, 4);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDDEBUG", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer"), VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer/drawString"), "(Ljava/lang/String;FFIZ)I", false);
        mv.visitInsn(172);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer") + ";", null, l0, l1, 0);
        mv.visitLocalVariable("text", "Ljava/lang/String;", null, l0, l1, 1);
        mv.visitLocalVariable("x", "I", null, l0, l1, 2);
        mv.visitLocalVariable("y", "I", null, l0, l1, 3);
        mv.visitLocalVariable("color", "I", null, l0, l1, 4);
        mv.visitMaxs(6, 5);
        mv.visitEnd();
        super.visitEnd();
    }
}


