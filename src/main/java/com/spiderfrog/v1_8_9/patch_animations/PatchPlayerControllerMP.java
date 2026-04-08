package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchPlayerControllerMP
        extends ClassVisitor
        implements Opcodes {
    public PatchPlayerControllerMP(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/multiplayer/PlayerControllerMP/func_181040_m")) && desc.equals("()Z")) {
            return (MethodVisitor) new getIsHittingBlock(mv, access, name, desc, signature, exceptions);
        }
        return mv;
    }

    public class getIsHittingBlock
            extends GeneratorAdapter
            implements Opcodes {
        boolean patched = false;

        getIsHittingBlock(MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
            super(262144, mv, access, name, desc);
        }


        public void visitVarInsn(int opcode, int var) {
            if (!this.patched) {
                this.patched = true;
                Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(622, l0);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDBLOCKBUILD", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                Label l1 = new Label();
                this.mv.visitJumpInsn(153, l1);
                this.mv.visitInsn(3);
                this.mv.visitInsn(172);
                this.mv.visitLabel(l1);
                this.mv.visitLineNumber(623, l1);
                this.mv.visitFrame(3, 0, null, 0, null);
            }
            super.visitVarInsn(opcode, var);
        }
    }
}


