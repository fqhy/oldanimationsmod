package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import net.minecraft.client.gui.Gui;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchGuiIngameForge
        extends ClassVisitor
        implements Opcodes {
    public PatchGuiIngameForge(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals("renderHUDText") && desc.equals("(II)V")) {
            return new RenderDebugInfoLeft(mv, access, name, desc);
        }

        if (name.equals("renderHealth") && desc.equals("(II)V")) {
            return (MethodVisitor) new RenderHealth(mv, access, name, desc);
        }
        return mv;
    }


    public void visitEnd() {
        FieldVisitor fv = this.cv.visitField(4, "hightlight", "J", null, null);
        fv.visitEnd();

        MethodVisitor mv = this.cv.visitMethod(9, "drawRectDebug", "(IIIII)V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(45, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDDEBUG", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        Label l1 = new Label();
        mv.visitJumpInsn(154, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(46, l2);
        mv.visitVarInsn(21, 0);
        mv.visitVarInsn(21, 1);
        mv.visitVarInsn(21, 2);
        mv.visitVarInsn(21, 3);
        mv.visitVarInsn(21, 4);
        mv.visitMethodInsn(184, "net/minecraftforge/client/GuiIngameForge", VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawRect"), "(IIIII)V", false);
        mv.visitLabel(l1);
        mv.visitLineNumber(48, l1);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(177);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLocalVariable("left", "I", null, l0, l3, 0);
        mv.visitLocalVariable("top", "I", null, l0, l3, 1);
        mv.visitLocalVariable("right", "I", null, l0, l3, 2);
        mv.visitLocalVariable("bottom", "I", null, l0, l3, 3);
        mv.visitLocalVariable("color", "I", null, l0, l3, 4);
        mv.visitMaxs(5, 5);
        mv.visitEnd();

        oldHighlight();

        super.visitEnd();
    }

    private void oldHighlight() {
        MethodVisitor mv = this.cv.visitMethod(2, "drawTexturedModalRectOAM", "(IIIIII)V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(272, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDHEARTS", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        Label l1 = new Label();
        mv.visitJumpInsn(154, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(273, l2);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(21, 1);
        mv.visitVarInsn(21, 2);
        mv.visitVarInsn(21, 3);
        mv.visitVarInsn(21, 4);
        mv.visitVarInsn(21, 5);
        mv.visitVarInsn(21, 6);
        mv.visitMethodInsn(182, "net/minecraftforge/client/GuiIngameForge", VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawTexturedModalRect"), "(IIIIII)V", false);
        mv.visitLabel(l1);
        mv.visitLineNumber(275, l1);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(177);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLocalVariable("this", "Lnet/minecraftforge/client/GuiIngameForge;", null, l0, l3, 0);
        mv.visitLocalVariable("x", "I", null, l0, l3, 1);
        mv.visitLocalVariable("y", "I", null, l0, l3, 2);
        mv.visitLocalVariable("textureX", "I", null, l0, l3, 3);
        mv.visitLocalVariable("textureY", "I", null, l0, l3, 4);
        mv.visitLocalVariable("width", "I", null, l0, l3, 5);
        mv.visitLocalVariable("height", "I", null, l0, l3, 6);
        mv.visitMaxs(7, 7);
        mv.visitEnd();
    }

    public class RenderDebugInfoLeft
            extends MethodVisitor implements Opcodes {
        public RenderDebugInfoLeft(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv);
        }


        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            if (opcode == 184 && owner.equals("net/minecraftforge/client/GuiIngameForge") && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawRect")) && desc.equals("(IIIII)V")) {
                super.visitMethodInsn(opcode, owner, "drawRectDebug", desc);
            } else if (opcode == 182 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/FontRenderer/drawString")) && desc.equals("(Ljava/lang/String;III)I")) {
                super.visitMethodInsn(opcode, owner, "drawStringDebug", desc);
            } else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }

    public static void drawRectDebug(int left, int top, int right, int bottom, int color) {
        if (!AnimationManager.getOldAnimationState(EnumAnimation.OLDDEBUG))
            Gui.drawRect(left, top, right, bottom, color);
    }

    public class RenderHealth
            extends GeneratorAdapter implements Opcodes {
        int time;

        public RenderHealth(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
            if (owner.equals("net/minecraftforge/client/GuiIngameForge") && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/Gui/drawTexturedModalRect")) && desc.equals("(IIIIII)V")) {
                this.time++;
                if (this.time == 2 || this.time == 3) {
                    super.visitMethodInsn(183, "net/minecraftforge/client/GuiIngameForge", "drawTexturedModalRectOAM", desc, itf);
                } else {
                    super.visitMethodInsn(opcode, owner, name, desc, itf);
                }
            } else {
                super.visitMethodInsn(opcode, owner, name, desc, itf);
            }
        }
    }
}


