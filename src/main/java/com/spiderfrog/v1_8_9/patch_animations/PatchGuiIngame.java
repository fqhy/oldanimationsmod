package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchGuiIngame
        extends ClassVisitor
        implements Opcodes {
    public PatchGuiIngame(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngame/showCrosshair")) && desc.equals("()Z")) {
            return (MethodVisitor) new ShowCrosshair(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngame/renderBossHealth")) && desc.equals("()V")) {
            return (MethodVisitor) new RenderBossHealth(mv, access, name, desc);
        }
        return mv;
    }

    public static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
        Methods.getInstance().drawTexturedModalRect(x, y, textureX, textureY, width, height);
    }


    public void visitEnd() {
        MethodVisitor mv = this.cv.visitMethod(1, "drawTexturedModalRectOAM", "(IIIIII)V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(35, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "NOBOSSBAR", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOtherAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        Label l1 = new Label();
        mv.visitJumpInsn(154, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(36, l2);
        mv.visitVarInsn(21, 1);
        mv.visitVarInsn(21, 2);
        mv.visitVarInsn(21, 3);
        mv.visitVarInsn(21, 4);
        mv.visitVarInsn(21, 5);
        mv.visitVarInsn(21, 6);
        mv.visitMethodInsn(184, VersionTranslation.getPath(PatchGuiIngame.class), "drawTexturedModalRect", "(IIIIII)V", false);
        mv.visitLabel(l1);
        mv.visitLineNumber(38, l1);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(177);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getPath(PatchGuiIngame.class) + ";", null, l0, l3, 0);
        mv.visitLocalVariable("x", "I", null, l0, l3, 1);
        mv.visitLocalVariable("y", "I", null, l0, l3, 2);
        mv.visitLocalVariable("textureX", "I", null, l0, l3, 3);
        mv.visitLocalVariable("textureY", "I", null, l0, l3, 4);
        mv.visitLocalVariable("width", "I", null, l0, l3, 5);
        mv.visitLocalVariable("height", "I", null, l0, l3, 6);
        mv.visitMaxs(6, 7);
        mv.visitEnd();
        super.visitEnd();
    }

    public class ShowCrosshair
            extends GeneratorAdapter {
        boolean patchedDebug;

        public ShowCrosshair(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitInsn(int opcode) {
            if (opcode == 172 && !this.patchedDebug) {
                this.patchedDebug = true;
                Label l2 = new Label();
                this.mv.visitLabel(l2);
                this.mv.visitLineNumber(433, l2);
                this.mv.visitFieldInsn(178, "com/spiderfrog/oldanimations/animations/EnumAnimation", "OLDDEBUG", "Lcom/spiderfrog/oldanimations/animations/EnumAnimation;");
                this.mv.visitMethodInsn(184, "com/spiderfrog/oldanimations/animations/AnimationManager", "getOldAnimationState", "(Lcom/spiderfrog/oldanimations/animations/EnumAnimation;)Z", false);
                Label l3 = new Label();
                this.mv.visitJumpInsn(153, l3);
                Label l4 = new Label();
                this.mv.visitLabel(l4);
                this.mv.visitLineNumber(434, l4);
                this.mv.visitInsn(4);
                this.mv.visitInsn(172);
                this.mv.visitLabel(l3);
            }
            super.visitInsn(opcode);
        }
    }

    public class RenderBossHealth
            extends GeneratorAdapter {
        public RenderBossHealth(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            if (opcode == 182 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngame")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawTexturedModalRect")) && desc.equals("(IIIIII)V")) {
                super.visitMethodInsn(opcode, owner, "drawTexturedModalRectOAM", desc);
            } else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }
}


