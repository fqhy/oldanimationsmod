package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchRenderFish
        extends ClassVisitor
        implements Opcodes {
    private boolean patched;

    public PatchRenderFish(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderFish/doRender")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/entity/projectile/EntityFishHook") + ";DDDFF)V")) {
            return (MethodVisitor) new Render(mv, access, name, desc);
        }
        return mv;
    }

    public class Render
            extends GeneratorAdapter {
        public Render(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitVarInsn(int opcode, int var) {
            if (opcode == 25 && var == 23 && !PatchRenderFish.this.patched) {
                PatchRenderFish.this.patched = true;
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDROD", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                Label l33 = new Label();
                this.mv.visitJumpInsn(153, l33);
                Label l34 = new Label();
                this.mv.visitLabel(l34);
                this.mv.visitLineNumber(62, l34);
                this.mv.visitTypeInsn(187, VersionTranslation.getDeobf("net/minecraft/util/Vec3"));
                this.mv.visitInsn(89);
                this.mv.visitLdcInsn(new Double("-0.5"));
                this.mv.visitLdcInsn(new Double("0.03"));
                this.mv.visitLdcInsn(new Double("0.8"));
                this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/util/Vec3"), "<init>", "(DDD)V", false);
                this.mv.visitVarInsn(58, 23);
                this.mv.visitLabel(l33);
                this.mv.visitLineNumber(64, l33);
                this.mv.visitFrame(0, 21, new Object[]{VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderFish"), VersionTranslation.getDeobf("net/minecraft/entity/projectile/EntityFishHook"), Opcodes.DOUBLE, Opcodes.DOUBLE, Opcodes.DOUBLE, Opcodes.FLOAT, Opcodes.FLOAT, VersionTranslation.getDeobf("net/minecraft/client/renderer/Tessellator"), VersionTranslation.getDeobf("net/minecraft/client/renderer/WorldRenderer"), Opcodes.INTEGER, Opcodes.INTEGER, Opcodes.FLOAT, Opcodes.FLOAT, Opcodes.FLOAT, Opcodes.FLOAT, Opcodes.FLOAT, Opcodes.FLOAT, Opcodes.FLOAT, Opcodes.FLOAT, Opcodes.FLOAT, VersionTranslation.getDeobf("net/minecraft/util/Vec3")}, 0, new Object[0]);
            }

            super.visitVarInsn(opcode, var);
        }
    }
}


