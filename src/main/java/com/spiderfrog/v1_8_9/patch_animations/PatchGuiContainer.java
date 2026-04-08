package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import net.minecraft.client.Minecraft;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchGuiContainer
        extends ClassVisitor
        implements Opcodes {
    public PatchGuiContainer(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equalsIgnoreCase(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiScreen/drawScreen")) && desc.equalsIgnoreCase("(IIF)V")) {
            return (MethodVisitor) new DrawScreen(mv, access, name, desc);
        }
        return mv;
    }

    public static void drawBackgroundOAM() {
        if (!AnimationManager.getOtherAnimationState(EnumAnimation.NOINVBACKGROUND)) {
            drawGradientRect(0, 0, (Minecraft.getMinecraft()).currentScreen.width, (Minecraft.getMinecraft()).currentScreen.height, -1072689136, -804253680);
        }
    }

    private static void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {
        Methods.getInstance().drawGradientRect(left, top, right, bottom, startColor, endColor);
    }

    public class DrawScreen
            extends GeneratorAdapter {
        public DrawScreen(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            if (opcode == 182 && owner.equalsIgnoreCase(VersionTranslation.getDeobf("net/minecraft/client/gui/inventory/GuiContainer")) && name.equalsIgnoreCase(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiScreen/drawDefaultBackground")) && desc.equalsIgnoreCase("()V")) {
                super.visitMethodInsn(184, VersionTranslation.getPath(PatchGuiContainer.class), "drawBackgroundOAM", desc);
            } else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }
}


