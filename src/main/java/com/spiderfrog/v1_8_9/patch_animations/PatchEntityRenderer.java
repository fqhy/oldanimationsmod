package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.OAMInjection;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;


public class PatchEntityRenderer
        extends ClassVisitor
        implements Opcodes {
    public PatchEntityRenderer(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/EntityRenderer/renderWorldPass")) && desc.equals("(IFJ)V")) {
            return (MethodVisitor) new RenderWorldPass(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/EntityRenderer/renderWorldDirections")) && desc.equals("(F)V")) {
            return (MethodVisitor) new RenderWorldDirections(mv, access, name, desc);
        }
        return mv;
    }

    public class RenderWorldDirections
            extends GeneratorAdapter {
        boolean patchedDebug;

        public RenderWorldDirections(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitInsn(int opcode) {
            if (!this.patchedDebug) {
                this.patchedDebug = true;
                Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(1134, l0);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDDEBUG", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                Label l1 = new Label();
                this.mv.visitJumpInsn(153, l1);
                Label l2 = new Label();
                this.mv.visitLabel(l2);
                this.mv.visitLineNumber(1135, l2);
                this.mv.visitInsn(177);
                this.mv.visitLabel(l1);
                this.mv.visitLineNumber(1137, l1);
                this.mv.visitFrame(3, 0, null, 0, null);
            }
            super.visitInsn(opcode);
        }
    }

    public class RenderWorldPass
            extends GeneratorAdapter {
        public RenderWorldPass(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitInsn(int opcode) {
            if (opcode == 177) {
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "blockbuild", "()V", false);
                Label l4 = new Label();
                this.mv.visitLabel(l4);
                this.mv.visitLineNumber(69, l4);
            }
            super.visitInsn(opcode);
        }
    }
}


