package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;


public class PatchLayerBipedArmor
        extends ClassVisitor {
    public PatchLayerBipedArmor(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public void visitEnd() {
        MethodVisitor mv = this.cv.visitMethod(1, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/layers/LayerArmorBase/shouldCombineTextures"), "()Z", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(61, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDDMG", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        mv.visitInsn(172);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/layers/LayerBipedArmor") + ";", null, l0, l1, 0);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
    }
}


