package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchModelBiped
        extends ClassVisitor
        implements Opcodes {
    public PatchModelBiped(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public void visitEnd() {
        MethodVisitor mv = this.cv.visitMethod(2, "performOldSword", "()V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(99, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDSWORD", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        Label l1 = new Label();
        mv.visitJumpInsn(153, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(100, l2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped"), VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped/bipedRightArm"), "L" + VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer") + ";");
        mv.visitInsn(11);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer"), VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer/rotateAngleY"), "F");
        mv.visitLabel(l1);
        mv.visitLineNumber(102, l1);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(177);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped") + ";", null, l0, l3, 0);
        mv.visitMaxs(2, 1);
        mv.visitEnd();

        appendPostRenderArmClear();
        super.visitEnd();
    }

    private void appendPostRenderArmClear() {
        MethodVisitor mv = this.cv.visitMethod(1, "postRenderArmClear", "(F)V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(236, l0);
        mv.visitInsn(177);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped") + ";", null, l0, l1, 0);
        mv.visitLocalVariable("scale", "F", null, l0, l1, 1);
        mv.visitMaxs(0, 2);
        mv.visitEnd();
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped/setRotationAngles")) && desc.equals("(FFFFFFL" + VersionTranslation.getDeobf("net/minecraft/entity/Entity") + ";)V")) {
            return (MethodVisitor) new SetRotationAngles(mv, access, name, desc);
        }
        return mv;
    }

    public class SetRotationAngles extends GeneratorAdapter implements Opcodes {
        int patchi;

        public SetRotationAngles(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
            super.visitFieldInsn(opcode, owner, name, desc);
            if (opcode == 181 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/model/ModelRenderer/rotateAngleY"))) {
                this.patchi++;
                if (this.patchi == 7) {
                    this.patchi++;
                    Label l83 = new Label();
                    this.mv.visitLabel(l83);
                    this.mv.visitLineNumber(206, l83);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/model/ModelBiped"), "performOldSword", "()V", false);
                }
            }
        }
    }
}


