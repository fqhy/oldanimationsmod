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

public class PatchItemRenderer
        extends ClassVisitor
        implements Opcodes {
    boolean patchItemScales;

    public PatchItemRenderer(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public void visitEnd() {
        appendUpdateEquippedItemOld();
        appendOldBlockhit();
        appendEatMethod();
        appendClearMethod();
        appendPerformBlockhit();
        super.visitEnd();
    }

    private void appendPerformBlockhit() {
        MethodVisitor mv = this.cv.visitMethod(2, "performBlockhit", "()V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(307, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDBLOCKHIT", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        Label l1 = new Label();
        mv.visitJumpInsn(153, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(308, l2);
        mv.visitLdcInsn(new Float("0.83"));
        mv.visitLdcInsn(new Float("0.88"));
        mv.visitLdcInsn(new Float("0.85"));
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(309, l3);
        mv.visitLdcInsn(new Float("-0.3"));
        mv.visitLdcInsn(new Float("0.1"));
        mv.visitInsn(11);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate"), "(FFF)V", false);
        mv.visitLabel(l1);
        mv.visitLineNumber(311, l1);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(177);
        Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", null, l0, l4, 0);
        mv.visitMaxs(3, 1);
        mv.visitEnd();
    }

    private void appendClearMethod() {
        MethodVisitor mv = this.cv.visitMethod(2, "transformFirstPersonItemClear", "(FF)V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(307, l0);
        mv.visitInsn(177);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", null, l0, l1, 0);
        mv.visitLocalVariable("equipProgress", "F", null, l0, l1, 1);
        mv.visitLocalVariable("swingProgress", "F", null, l0, l1, 2);
        mv.visitMaxs(0, 3);
        mv.visitEnd();
    }

    private void appendEatMethod() {
        MethodVisitor mv = this.cv.visitMethod(2, "transformFirstPersonItemEat", "(FF)V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(307, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDEAT", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        Label l1 = new Label();
        mv.visitJumpInsn(153, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(308, l2);
        mv.visitLdcInsn(new Float("0.8"));
        mv.visitInsn(12);
        mv.visitInsn(12);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(309, l3);
        mv.visitLdcInsn(new Float("-0.2"));
        mv.visitLdcInsn(new Float("-0.1"));
        mv.visitInsn(11);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate"), "(FFF)V", false);
        mv.visitLabel(l1);
        mv.visitLineNumber(311, l1);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(177);
        Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", null, l0, l4, 0);
        mv.visitLocalVariable("equipProgress", "F", null, l0, l4, 1);
        mv.visitLocalVariable("swingProgress", "F", null, l0, l4, 2);
        mv.visitMaxs(3, 3);
        mv.visitEnd();
    }

    private void appendOldBlockhit() {
        MethodVisitor mv = this.cv.visitMethod(2, "oldBlockhit", "(F)F", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(307, l0);
        mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDBLOCKHIT", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
        mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
        Label l1 = new Label();
        mv.visitJumpInsn(153, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(308, l2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/mc"), "L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/thePlayer"), "L" + VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP") + ";");
        mv.visitVarInsn(23, 1);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/EntityLivingBase/getSwingProgress"), "(F)F", false);
        mv.visitInsn(174);
        mv.visitLabel(l1);
        mv.visitLineNumber(310, l1);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(11);
        mv.visitInsn(174);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", null, l0, l3, 0);
        mv.visitLocalVariable("partialTicks", "F", null, l0, l3, 1);
        mv.visitMaxs(2, 2);
        mv.visitEnd();
    }

    private void appendUpdateEquippedItemOld() {
        MethodVisitor mv = this.cv.visitMethod(1, "updateEquippedItemOld", "()V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(519, l0);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/prevEquippedProgress"), "F");
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLineNumber(520, l1);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/mc"), "L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/thePlayer"), "L" + VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP") + ";");
        mv.visitVarInsn(58, 1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(521, l2);
        mv.visitVarInsn(25, 1);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/inventory"), "L" + VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer/getCurrentItem"), "()L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";", false);
        mv.visitVarInsn(58, 2);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(522, l3);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedItemSlot"), "I");
        mv.visitVarInsn(25, 1);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/inventory"), "L" + VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer/currentItem"), "I");
        Label l4 = new Label();
        mv.visitJumpInsn(160, l4);
        mv.visitVarInsn(25, 2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitJumpInsn(166, l4);
        mv.visitInsn(4);
        Label l5 = new Label();
        mv.visitJumpInsn(167, l5);
        mv.visitLabel(l4);
        mv.visitFrame(1, 2, new Object[]{VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack")}, 0, null);
        mv.visitInsn(3);
        mv.visitLabel(l5);
        mv.visitFrame(4, 0, null, 1, new Object[]{Opcodes.INTEGER});
        mv.visitVarInsn(54, 3);
        Label l6 = new Label();
        mv.visitLabel(l6);
        mv.visitLineNumber(523, l6);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        Label l7 = new Label();
        mv.visitJumpInsn(199, l7);
        mv.visitVarInsn(25, 2);
        mv.visitJumpInsn(199, l7);
        Label l8 = new Label();
        mv.visitLabel(l8);
        mv.visitLineNumber(524, l8);
        mv.visitInsn(4);
        mv.visitVarInsn(54, 3);
        mv.visitLabel(l7);
        mv.visitLineNumber(526, l7);
        mv.visitFrame(1, 1, new Object[]{Opcodes.INTEGER}, 0, null);
        mv.visitVarInsn(25, 2);
        Label l9 = new Label();
        mv.visitJumpInsn(198, l9);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitJumpInsn(198, l9);
        mv.visitVarInsn(25, 2);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitJumpInsn(165, l9);
        mv.visitVarInsn(25, 2);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack/getItem"), "()L" + VersionTranslation.getDeobf("net/minecraft/item/Item") + ";", false);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack/getItem"), "()L" + VersionTranslation.getDeobf("net/minecraft/item/Item") + ";", false);
        mv.visitJumpInsn(166, l9);
        mv.visitVarInsn(25, 2);
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack/getItemDamage"), "()I", false);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack/getItemDamage"), "()I", false);
        mv.visitJumpInsn(160, l9);
        Label l10 = new Label();
        mv.visitLabel(l10);
        mv.visitLineNumber(528, l10);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 2);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        Label l11 = new Label();
        mv.visitLabel(l11);
        mv.visitLineNumber(529, l11);
        mv.visitInsn(4);
        mv.visitVarInsn(54, 3);
        mv.visitLabel(l9);
        mv.visitLineNumber(531, l9);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitLdcInsn(new Float("0.4"));
        mv.visitVarInsn(56, 4);
        Label l12 = new Label();
        mv.visitLabel(l12);
        mv.visitLineNumber(532, l12);
        mv.visitVarInsn(21, 3);
        Label l13 = new Label();
        mv.visitJumpInsn(153, l13);
        mv.visitInsn(12);
        Label l14 = new Label();
        mv.visitJumpInsn(167, l14);
        mv.visitLabel(l13);
        mv.visitFrame(1, 1, new Object[]{Opcodes.FLOAT}, 0, null);
        mv.visitInsn(11);
        mv.visitLabel(l14);
        mv.visitFrame(4, 0, null, 1, new Object[]{Opcodes.FLOAT});
        mv.visitVarInsn(56, 5);
        Label l15 = new Label();
        mv.visitLabel(l15);
        mv.visitLineNumber(533, l15);
        mv.visitVarInsn(23, 5);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        mv.visitInsn(102);
        mv.visitVarInsn(56, 6);
        Label l16 = new Label();
        mv.visitLabel(l16);
        mv.visitLineNumber(534, l16);
        mv.visitVarInsn(23, 6);
        mv.visitVarInsn(23, 4);
        mv.visitInsn(118);
        mv.visitInsn(150);
        Label l17 = new Label();
        mv.visitJumpInsn(156, l17);
        Label l18 = new Label();
        mv.visitLabel(l18);
        mv.visitLineNumber(535, l18);
        mv.visitVarInsn(23, 4);
        mv.visitInsn(118);
        mv.visitVarInsn(56, 6);
        mv.visitLabel(l17);
        mv.visitLineNumber(537, l17);
        mv.visitFrame(1, 2, new Object[]{Opcodes.FLOAT, Opcodes.FLOAT}, 0, null);
        mv.visitVarInsn(23, 6);
        mv.visitVarInsn(23, 4);
        mv.visitInsn(149);
        Label l19 = new Label();
        mv.visitJumpInsn(158, l19);
        Label l20 = new Label();
        mv.visitLabel(l20);
        mv.visitLineNumber(538, l20);
        mv.visitVarInsn(23, 4);
        mv.visitVarInsn(56, 6);
        mv.visitLabel(l19);
        mv.visitLineNumber(540, l19);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitVarInsn(25, 0);
        mv.visitInsn(89);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        mv.visitVarInsn(23, 6);
        mv.visitInsn(98);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        Label l21 = new Label();
        mv.visitLabel(l21);
        mv.visitLineNumber(541, l21);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedProgress"), "F");
        mv.visitLdcInsn(new Float("0.1"));
        mv.visitInsn(150);
        Label l22 = new Label();
        mv.visitJumpInsn(156, l22);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 2);
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
        Label l26 = new Label();
        mv.visitLabel(l26);
        mv.visitLineNumber(548, l26);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 1);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP"), VersionTranslation.getDeobf("net/minecraft/entity/player/EntityPlayer/inventory"), "L" + VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer") + ";");
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer"), VersionTranslation.getDeobf("net/minecraft/entity/player/InventoryPlayer/currentItem"), "I");
        mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/equippedItemSlot"), "I");
        mv.visitLabel(l22);
        mv.visitLineNumber(550, l22);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(177);
        Label l27 = new Label();
        mv.visitLabel(l27);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer") + ";", null, l0, l27, 0);
        mv.visitLocalVariable("var1", "L" + VersionTranslation.getDeobf("net/minecraft/client/entity/EntityPlayerSP") + ";", null, l2, l27, 1);
        mv.visitLocalVariable("var2", "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";", null, l3, l27, 2);
        mv.visitLocalVariable("var3", "Z", null, l6, l27, 3);
        mv.visitLocalVariable("var4", "F", null, l12, l27, 4);
        mv.visitLocalVariable("var5", "F", null, l15, l27, 5);
        mv.visitLocalVariable("var6", "F", null, l16, l27, 6);
        mv.visitMaxs(3, 7);
        mv.visitEnd();
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem")) && desc.equals("(FF)V")) {
            return (MethodVisitor) new TransformFirstPersonItem(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/updateEquippedItem")) && desc.equals("()V")) {
            return (MethodVisitor) new UpdateEquippedItem(mv, access, name, desc);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/renderItemInFirstPerson")) && desc.equals("(F)V")) {
            return (MethodVisitor) new RenderItemInFirstPerson(mv, access, name, desc);
        }
        return mv;
    }

    public class UpdateEquippedItem extends GeneratorAdapter implements Opcodes {
        boolean patched;

        public UpdateEquippedItem(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitVarInsn(int opcode, int var) {
            super.visitVarInsn(opcode, var);
            if (!this.patched) {
                this.patched = true;
                Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(501, l0);
                this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDITEMUPDATE", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                Label l1 = new Label();
                this.mv.visitJumpInsn(153, l1);
                Label l2 = new Label();
                this.mv.visitLabel(l2);
                this.mv.visitLineNumber(502, l2);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "updateEquippedItemOld", "()V", false);
                Label l3 = new Label();
                this.mv.visitLabel(l3);
                this.mv.visitLineNumber(503, l3);
                this.mv.visitInsn(177);
                this.mv.visitLabel(l1);
                this.mv.visitLineNumber(506, l1);
                this.mv.visitFrame(3, 0, null, 0, null);
            }
        }
    }

    public class TransformFirstPersonItem
            extends GeneratorAdapter implements Opcodes {
        boolean patched;

        TransformFirstPersonItem(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            if (!this.patched && opcode == 184 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate")) && desc.equals("(FFF)V")) {
                this.patched = true;
                Label l0 = new Label();
                this.mv.visitLabel(l0);
                this.mv.visitLineNumber(239, l0);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/mc"), "L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";");
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/itemToRender"), "L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";");
                this.mv.visitVarInsn(23, 2);
                this.mv.visitMethodInsn(184, VersionTranslation.getPath(OAMInjection.class), "performOldAnimations", "(L" + VersionTranslation.getDeobf("net/minecraft/client/Minecraft") + ";L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";F)V", false);
            }
            super.visitMethodInsn(opcode, owner, name, desc);
        }
    }

    public class RenderItemInFirstPerson
            extends GeneratorAdapter
            implements Opcodes {
        boolean patchedresource;
        int transFirstPerItem = 0;

        public RenderItemInFirstPerson(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            if (opcode == 183 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem")) && desc.equals("(FF)V")) {
                this.transFirstPerItem++;
                if (this.transFirstPerItem == 1 || this.transFirstPerItem == 5) {
                    super.visitMethodInsn(opcode, owner, name, desc);
                } else if (this.transFirstPerItem == 2) {
                    super.visitMethodInsn(opcode, owner, "transformFirstPersonItemEat", desc);
                } else if (this.transFirstPerItem == 3) {
                    super.visitMethodInsn(opcode, owner, "transformFirstPersonItemClear", desc);
                    Label l25 = new Label();
                    this.mv.visitLabel(l25);
                    this.mv.visitLineNumber(333, l25);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitVarInsn(23, 2);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitVarInsn(23, 1);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "oldBlockhit", "(F)F", false);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem"), "(FF)V", false);
                } else if (this.transFirstPerItem == 4) {
                    super.visitMethodInsn(opcode, owner, "transformFirstPersonItemClear", desc);
                    Label l25 = new Label();
                    this.mv.visitLabel(l25);
                    this.mv.visitLineNumber(333, l25);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitVarInsn(23, 2);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitVarInsn(23, 1);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "oldBlockhit", "(F)F", false);
                    this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem"), "(FF)V", false);
                }
            } else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
            if (opcode == 183 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/func_178104_a")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/client/entity/AbstractClientPlayer") + ";F)V")) {
                Label l25 = new Label();
                this.mv.visitLabel(l25);
                this.mv.visitLineNumber(333, l25);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitVarInsn(23, 2);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitVarInsn(23, 1);
                this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "oldBlockhit", "(F)F", false);
                this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/transformFirstPersonItem"), "(FF)V", false);
            }
            if (opcode == 183 && owner.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer")) && name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer/func_178103_d")) && desc.equals("()V")) {
                Label l31 = new Label();
                this.mv.visitLabel(l31);
                this.mv.visitLineNumber(362, l31);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/ItemRenderer"), "performBlockhit", "()V", false);
            }
        }
    }
}


