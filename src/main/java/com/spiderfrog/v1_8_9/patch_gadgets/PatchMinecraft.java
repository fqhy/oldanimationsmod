package com.spiderfrog.v1_8_9.patch_gadgets;

import com.spiderfrog.gadgets.main.ClassTransformer;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchMinecraft
        extends ClassVisitor
        implements Opcodes {
    public PatchMinecraft(int api, ClassVisitor cv) {
        super(api, cv);
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/Minecraft/startGame")) && desc.equals("()V")) {
            ClassTransformer.logger.info("Found Minecraft Start Method");
            return (MethodVisitor) new StartGame(mv, access, name, desc);
        }
        return mv;
    }

    public class StartGame
            extends GeneratorAdapter {
        protected StartGame(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }

        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            super.visitMethodInsn(opcode, owner, name, desc);
            if (opcode == 182 && owner.equals("net/minecraftforge/fml/client/FMLClientHandler") && name.equals("onInitializationComplete") && desc.equals("()V")) {
                ClassTransformer.logger.info("Tweak OldAnimationsMod init Method into Minecraft");
                Label l111 = new Label();
                this.mv.visitLabel(l111);
                this.mv.visitLineNumber(598, l111);
                this.mv.visitMethodInsn(184, "com/spiderfrog/oldanimations/OldAnimationsMod", "getInstance", "()Lcom/spiderfrog/oldanimations/OldAnimationsMod;", false);
                this.mv.visitMethodInsn(182, "com/spiderfrog/oldanimations/OldAnimationsMod", "initTweak", "()V", false);
            }
        }
    }
}
