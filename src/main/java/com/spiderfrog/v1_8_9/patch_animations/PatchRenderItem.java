package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchRenderItem
        extends ClassVisitor
        implements Opcodes {
    public PatchRenderItem(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/renderItem")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/item/ItemStack") + ";L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)V")) {
            return (MethodVisitor) new RenderItem(mv, access, name, desc);
        }
        return mv;
    }

    public class RenderItem
            extends GeneratorAdapter {
        public RenderItem(MethodVisitor mv, int access, String name, String desc) {
            super(262144, mv, access, name, desc);
        }


        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/renderEffect")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)V")) {
                super.visitMethodInsn(opcode, owner, "renderEffectOld", desc);
            } else {
                super.visitMethodInsn(opcode, owner, name, desc);
            }
        }
    }


    public void visitEnd() {
        MethodVisitor mv = this.cv.visitMethod(1, "renderEffectOld", "(L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)V", null, null);
        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(233, l0);
        mv.visitFieldInsn(178, "com/spiderfrog/oldanimations/animations/EnumAnimation", "OLDENCHGLINT", "Lcom/spiderfrog/oldanimations/animations/EnumAnimation;");
        mv.visitMethodInsn(184, "com/spiderfrog/oldanimations/animations/AnimationManager", "getOldAnimationState", "(Lcom/spiderfrog/oldanimations/animations/EnumAnimation;)Z", false);
        Label l1 = new Label();
        mv.visitJumpInsn(154, l1);
        Label l2 = new Label();
        mv.visitLabel(l2);
        mv.visitLineNumber(234, l2);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 1);
        mv.visitMethodInsn(183, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/renderEffect"), "(L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)V", false);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(235, l3);
        mv.visitInsn(177);
        mv.visitLabel(l1);
        mv.visitLineNumber(237, l1);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitInsn(3);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthMask"), "(Z)V", false);
        Label l4 = new Label();
        mv.visitLabel(l4);
        mv.visitLineNumber(238, l4);
        mv.visitIntInsn(17, 514);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthFunc"), "(I)V", false);
        Label l5 = new Label();
        mv.visitLabel(l5);
        mv.visitLineNumber(239, l5);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/disableLighting"), "()V", false);
        Label l6 = new Label();
        mv.visitLabel(l6);
        mv.visitLineNumber(240, l6);
        mv.visitIntInsn(17, 768);
        mv.visitInsn(4);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/blendFunc"), "(II)V", false);
        Label l7 = new Label();
        mv.visitLabel(l7);
        mv.visitLineNumber(241, l7);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/textureManager"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager") + ";");
        mv.visitFieldInsn(178, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/RES_ITEM_GLINT"), "L" + VersionTranslation.getDeobf("net/minecraft/util/ResourceLocation") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager/bindTexture"), "(L" + VersionTranslation.getDeobf("net/minecraft/util/ResourceLocation") + ";)V", false);
        Label l8 = new Label();
        mv.visitLabel(l8);
        mv.visitLineNumber(243, l8);
        mv.visitIntInsn(17, 5890);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/matrixMode"), "(I)V", false);
        Label l9 = new Label();
        mv.visitLabel(l9);
        mv.visitLineNumber(244, l9);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/pushMatrix"), "()V", false);
        Label l10 = new Label();
        mv.visitLabel(l10);
        mv.visitLineNumber(245, l10);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/enableAlpha"), "()V", false);
        Label l11 = new Label();
        mv.visitLabel(l11);
        mv.visitLineNumber(246, l11);
        mv.visitLdcInsn(new Float("6.0"));
        mv.visitLdcInsn(new Float("6.0"));
        mv.visitLdcInsn(new Float("6.0"));
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
        Label l12 = new Label();
        mv.visitLabel(l12);
        mv.visitLineNumber(247, l12);
        mv.visitInsn(3);
        mv.visitVarInsn(54, 2);
        Label l13 = new Label();
        mv.visitLabel(l13);
        Label l14 = new Label();
        mv.visitJumpInsn(167, l14);
        Label l15 = new Label();
        mv.visitLabel(l15);
        mv.visitLineNumber(248, l15);
        mv.visitFrame(1, 1, new Object[]{Opcodes.INTEGER}, 0, null);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/Minecraft"), VersionTranslation.getDeobf("net/minecraft/client/Minecraft/getSystemTime"), "()J", false);
        mv.visitIntInsn(17, 3000);
        mv.visitVarInsn(21, 2);
        mv.visitIntInsn(17, 1873);
        mv.visitInsn(104);
        mv.visitInsn(96);
        mv.visitInsn(133);
        mv.visitInsn(113);
        mv.visitInsn(137);
        mv.visitLdcInsn(new Float("2000.0"));
        mv.visitVarInsn(21, 2);
        mv.visitIntInsn(17, 1873);
        mv.visitInsn(104);
        mv.visitInsn(134);
        mv.visitInsn(98);
        mv.visitInsn(110);
        mv.visitLdcInsn(new Float("8.0"));
        mv.visitInsn(110);
        mv.visitVarInsn(56, 3);
        Label l16 = new Label();
        mv.visitLabel(l16);
        mv.visitLineNumber(249, l16);
        mv.visitVarInsn(23, 3);
        mv.visitInsn(118);
        mv.visitInsn(11);
        mv.visitInsn(11);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/translate"), "(FFF)V", false);
        Label l17 = new Label();
        mv.visitLabel(l17);
        mv.visitLineNumber(250, l17);
        mv.visitLdcInsn(new Float("40.0"));
        mv.visitInsn(11);
        mv.visitInsn(11);
        mv.visitInsn(12);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/rotate"), "(FFFF)V", false);
        Label l18 = new Label();
        mv.visitLabel(l18);
        mv.visitLineNumber(251, l18);
        mv.visitVarInsn(25, 0);
        mv.visitVarInsn(25, 1);
        mv.visitLdcInsn(new Integer(-8372020));
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/renderModel"), "(L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";I)V", false);
        Label l19 = new Label();
        mv.visitLabel(l19);
        mv.visitLineNumber(252, l19);
        mv.visitLdcInsn(new Float("-1.0"));
        mv.visitInsn(12);
        mv.visitInsn(12);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
        Label l20 = new Label();
        mv.visitLabel(l20);
        mv.visitLineNumber(247, l20);
        mv.visitIincInsn(2, 1);
        mv.visitLabel(l14);
        mv.visitFrame(3, 0, null, 0, null);
        mv.visitVarInsn(21, 2);
        mv.visitInsn(5);
        mv.visitJumpInsn(161, l15);
        Label l21 = new Label();
        mv.visitLabel(l21);
        mv.visitLineNumber(254, l21);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/popMatrix"), "()V", false);
        Label l22 = new Label();
        mv.visitLabel(l22);
        mv.visitLineNumber(255, l22);
        mv.visitIntInsn(17, 5888);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/matrixMode"), "(I)V", false);
        Label l23 = new Label();
        mv.visitLabel(l23);
        mv.visitLineNumber(256, l23);
        mv.visitIntInsn(17, 770);
        mv.visitIntInsn(17, 771);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/blendFunc"), "(II)V", false);
        Label l24 = new Label();
        mv.visitLabel(l24);
        mv.visitLineNumber(257, l24);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/enableLighting"), "()V", false);
        Label l25 = new Label();
        mv.visitLabel(l25);
        mv.visitLineNumber(258, l25);
        mv.visitIntInsn(17, 515);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthFunc"), "(I)V", false);
        Label l26 = new Label();
        mv.visitLabel(l26);
        mv.visitLineNumber(259, l26);
        mv.visitInsn(4);
        mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/depthMask"), "(Z)V", false);
        Label l27 = new Label();
        mv.visitLabel(l27);
        mv.visitLineNumber(260, l27);
        mv.visitVarInsn(25, 0);
        mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem/textureManager"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager") + ";");
        mv.visitFieldInsn(178, VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureMap"), VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureMap/locationBlocksTexture"), "L" + VersionTranslation.getDeobf("net/minecraft/util/ResourceLocation") + ";");
        mv.visitMethodInsn(182, VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/texture/TextureManager/bindTexture"), "(L" + VersionTranslation.getDeobf("net/minecraft/util/ResourceLocation") + ";)V", false);
        Label l28 = new Label();
        mv.visitLabel(l28);
        mv.visitLineNumber(261, l28);
        mv.visitInsn(177);
        Label l29 = new Label();
        mv.visitLabel(l29);
        mv.visitLocalVariable("this", "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderItem") + ";", null, l0, l29, 0);
        mv.visitLocalVariable("model", "L" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";", null, l0, l29, 1);
        mv.visitLocalVariable("var6", "I", null, l13, l21, 2);
        mv.visitLocalVariable("var3", "F", null, l16, l20, 3);
        mv.visitMaxs(5, 4);
        mv.visitEnd();
        super.visitEnd();
    }
}


