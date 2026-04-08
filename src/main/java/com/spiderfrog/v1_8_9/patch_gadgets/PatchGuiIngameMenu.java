package com.spiderfrog.v1_8_9.patch_gadgets;

import com.spiderfrog.v1_8_9.OAMInjection;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchGuiIngameMenu
        extends ClassVisitor
        implements Opcodes {
    public PatchGuiIngameMenu(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngameMenu/initGui")) && desc.equals("()V")) {
            return (MethodVisitor) new InitGui(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngameMenu/actionPerformed")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/client/gui/GuiButton") + ";)V")) {
            return (MethodVisitor) new ActionPerformed(mv, access, name, desc);
        }
        return mv;
    }

    public class InitGui
            extends GeneratorAdapter {
        public InitGui(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
            super.visitFieldInsn(opcode, owner, name, desc);
            if (opcode == 181 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiButton")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/gui/GuiButton/enabled")) && desc.equals("Z")) {
                Label l16 = new Label();
                this.mv.visitLabel(l16);
                this.mv.visitLineNumber(41, l16);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/gui/GuiIngameMenu"), VersionTranslation.getDeobf("net/minecraft/client/gui/GuiScreen/buttonList"), "Ljava/util/List;");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "addOAMButton", "(Ljava/util/List;)V", false);
            }
        }
    }

    public class ActionPerformed
            extends GeneratorAdapter {
        public ActionPerformed(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitCode() {
            super.visitCode();
            Label l0 = new Label();
            this.mv.visitLabel(l0);
            this.mv.visitLineNumber(44, l0);
            this.mv.visitVarInsn(25, 1);
            this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "performOAMButton", "(L" + VersionTranslation.getDeobf("net/minecraft/client/gui/GuiButton") + ";)V", false);
        }
    }
}


