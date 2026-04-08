package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchEntityPlayer
        extends ClassVisitor
        implements Opcodes {
    public PatchEntityPlayer(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/getEyeHeight")) && desc.equals("()F")) {
            return (MethodVisitor) new GetEyeHeight(mv, access, name, desc);
        }
        return mv;
    }


    public void visitEnd() {
        FieldVisitor fv = this.cv.visitField(0, "sneak", "J", null, null);
        fv.visitEnd();

        FieldVisitor fv1 = this.cv.visitField(0, "sneaking", "Z", null, null);
        fv1.visitEnd();

        appendgetOldEyeHeight();

        super.visitEnd();
    }

    private void appendgetOldEyeHeight() {
        MethodVisitor mv = this.cv.visitMethod(1, "getOldEyeHeight", "()F", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(1582, l0);
        mv.visitLdcInsn(new Float("1.62"));
        mv.visitVarInsn(56, 1);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLineNumber(1583, l1);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneaking", "Z");
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/Entity/isSneaking"), "()Z", false);
        Label l2 = new Label();
        mv.visitJumpInsn(160, l2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneak", "J");
        mv.visitInsn(9);
        mv.visitInsn(148);
        Label l3 = new Label();
        mv.visitJumpInsn(157, l3);
        mv.visitLabel(l2);
        mv.visitLineNumber(1584, l2);
        mv.visitFrame(1, 1, new Object[]{Opcodes.FLOAT}, 0, null);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneak", "J");
        mv.visitLabel(l3);
        mv.visitLineNumber(1586, l3);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/Entity/isSneaking"), "()Z", false);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneaking", "Z");
        Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLineNumber(1587, l4);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/getMinecraft"), "()L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";", false);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/gameSettings"), "L" + VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings"), VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings/thirdPersonView"), "I");
        Label l5 = new Label();
        mv.visitJumpInsn(154, l5);
        Label l6 = new Label();
        mv.visitLabel(l6);
        mv.visitLineNumber(1588, l6);
        mv.visitLdcInsn(new Float("1.62"));
        mv.visitVarInsn(56, 1);
        Label l7 = new Label();
        mv.visitLabel(l7);
        mv.visitLineNumber(1589, l7);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/Entity/isSneaking"), "()Z", false);
        Label l8 = new Label();
        mv.visitJumpInsn(153, l8);
        Label l9 = new Label();
        mv.visitLabel(l9);
        mv.visitLineNumber(1590, l9);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneak", "J");
        mv.visitLdcInsn(new Long(8L));
        mv.visitInsn(97);
        mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitInsn(101);
        mv.visitInsn(136);
        mv.visitVarInsn(54, 2);
        Label l10 = new Label();
        mv.visitLabel(l10);
        mv.visitLineNumber(1591, l10);
        mv.visitVarInsn(21, 2);
        mv.visitIntInsn(16, -50);
        Label l11 = new Label();
        mv.visitJumpInsn(164, l11);
        Label l12 = new Label();
        mv.visitLabel(l12);
        mv.visitLineNumber(1592, l12);
        mv.visitVarInsn(23, 1);
        mv.visitVarInsn(21, 2);
        mv.visitInsn(135);
        mv.visitLdcInsn(new Double("0.0017"));
        mv.visitInsn(107);
        mv.visitInsn(144);
        mv.visitInsn(98);
        mv.visitVarInsn(56, 1);
        Label l13 = new Label();
        mv.visitLabel(l13);
        mv.visitLineNumber(1593, l13);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(11);
        mv.visitInsn(150);
        Label l14 = new Label();
        mv.visitJumpInsn(155, l14);
        mv.visitVarInsn(23, 1);
        mv.visitLdcInsn(new Float("10.0"));
        mv.visitInsn(149);
        Label l15 = new Label();
        mv.visitJumpInsn(158, l15);
        mv.visitLabel(l14);
        mv.visitLineNumber(1594, l14);
        mv.visitFrame(1, 1, new Object[]{Opcodes.INTEGER}, 0, null);
        mv.visitLdcInsn(new Float("1.54"));
        mv.visitVarInsn(56, 1);
        Label l16 = new Label();
        mv.visitLabel(l16);
        mv.visitLineNumber(1596, l16);
        mv.visitJumpInsn(167, l15);
        mv.visitLabel(l11);
        mv.visitLineNumber(1598, l11);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(141);
        mv.visitLdcInsn(new Double("0.08"));
        mv.visitInsn(103);
        mv.visitInsn(144);
        mv.visitVarInsn(56, 1);
        Label l17 = new Label();
        mv.visitLabel(l17);
        mv.visitLineNumber(1600, l17);
        mv.visitJumpInsn(167, l15);
        mv.visitLabel(l8);
        mv.visitLineNumber(1603, l8);
        mv.visitFrame(2, 1, null, 0, null);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "sneak", "J");
        mv.visitLdcInsn(new Long(8L));
        mv.visitInsn(97);
        mv.visitMethodInsn(184, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitInsn(101);
        mv.visitInsn(136);
        mv.visitVarInsn(54, 2);
        Label l18 = new Label();
        mv.visitLabel(l18);
        mv.visitLineNumber(1604, l18);
        mv.visitVarInsn(21, 2);
        mv.visitIntInsn(16, -50);
        Label l19 = new Label();
        mv.visitJumpInsn(164, l19);
        Label l20 = new Label();
        mv.visitLabel(l20);
        mv.visitLineNumber(1605, l20);
        mv.visitVarInsn(23, 1);
        mv.visitVarInsn(21, 2);
        mv.visitInsn(135);
        mv.visitLdcInsn(new Double("0.0017"));
        mv.visitInsn(107);
        mv.visitInsn(144);
        mv.visitInsn(102);
        mv.visitVarInsn(56, 1);
        Label l21 = new Label();
        mv.visitLabel(l21);
        mv.visitLineNumber(1606, l21);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(141);
        mv.visitLdcInsn(new Double("0.08"));
        mv.visitInsn(103);
        mv.visitInsn(144);
        mv.visitVarInsn(56, 1);
        Label l22 = new Label();
        mv.visitLabel(l22);
        mv.visitLineNumber(1607, l22);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(11);
        mv.visitInsn(150);
        mv.visitJumpInsn(156, l15);
        Label l23 = new Label();
        mv.visitLabel(l23);
        mv.visitLineNumber(1608, l23);
        mv.visitLdcInsn(new Float("1.62"));
        mv.visitVarInsn(56, 1);
        Label l24 = new Label();
        mv.visitLabel(l24);
        mv.visitLineNumber(1611, l24);
        mv.visitJumpInsn(167, l15);
        mv.visitLabel(l19);
        mv.visitLineNumber(1613, l19);
        mv.visitFrame(1, 1, new Object[]{Opcodes.INTEGER}, 0, null);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(11);
        mv.visitInsn(102);
        mv.visitVarInsn(56, 1);
        Label l25 = new Label();
        mv.visitLabel(l25);
        mv.visitLineNumber(1616, l25);
        mv.visitJumpInsn(167, l15);
        mv.visitLabel(l5);
        mv.visitFrame(2, 1, null, 0, null);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/Entity/isSneaking"), "()Z", false);
        mv.visitJumpInsn(153, l15);
        Label l26 = new Label();
        mv.visitLabel(l26);
        mv.visitLineNumber(1618, l26);
        mv.visitVarInsn(23, 1);
        mv.visitLdcInsn(new Float("0.08"));
        mv.visitInsn(102);
        mv.visitVarInsn(56, 1);
        mv.visitLabel(l15);
        mv.visitLineNumber(1620, l15);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/isPlayerSleeping"), "()Z", false);
        Label l27 = new Label();
        mv.visitJumpInsn(153, l27);
        Label l28 = new Label();
        mv.visitLabel(l28);
        mv.visitLineNumber(1621, l28);
        mv.visitLdcInsn(new Float("0.2"));
        mv.visitVarInsn(56, 1);
        mv.visitLabel(l27);
        mv.visitLineNumber(1623, l27);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitVarInsn(23, 1);
        mv.visitInsn(174);
        Label l29 = new Label();
        mv.visitLabel(l29);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer") + ";", null, l0, l29, 0);
        mv.visitLocalVariable("f", "F", null, l1, l29, 1);
        mv.visitLocalVariable("a", "I", null, l10, l17, 2);
        mv.visitLocalVariable("a", "I", null, l18, l25, 2);
        mv.visitMaxs(5, 3);
        mv.visitEnd();
    }

    public class GetEyeHeight
            extends GeneratorAdapter {
        int timer;
        boolean patched;

        public GetEyeHeight(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, desc, desc);
        }


        public void visitVarInsn(int opcode, int var) {
            super.visitVarInsn(opcode, var);
            if (opcode == 56 && var == 1) {
                this.timer++;
                if (!this.patched && this.timer == 1) {
                    this.patched = true;
                    Label l1 = new Label();
                    this.mv.visitLabel(l1);
                    this.mv.visitLineNumber(1623, l1);
                    this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDSNEAK", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                    this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                    Label l2 = new Label();
                    this.mv.visitJumpInsn(153, l2);
                    Label l3 = new Label();
                    this.mv.visitLabel(l3);
                    this.mv.visitLineNumber(1624, l3);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer"), "getOldEyeHeight", "()F", false);
                    this.mv.visitInsn(174);
                    this.mv.visitLabel(l2);
                    this.mv.visitLineNumber(1627, l2);
                    this.mv.visitFrame(1, 1, new Object[]{Opcodes.FLOAT}, 0, null);
                }
            }
        }
    }
}


