package com.spiderfrog.v1_8_9.patch_animations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.v1_8_9.VersionTranslation;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.GeneratorAdapter;

public class PatchRenderEntityItem
        extends ClassVisitor {
    public PatchRenderEntityItem(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public void visitEnd() {
        FieldVisitor fv = visitField(0, "olditems", "Z", null, null);
        fv.visitEnd();
        super.visitEnd();
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem/func_177077_a")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/entity/item/EntityItem") + ";DDDFL" + VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel") + ";)I")) {
            return (MethodVisitor) new func_177077_a(mv, access, name, desc, signature, exceptions);
        }
        if (name.equals(VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem/doRender")) && desc.equals("(L" + VersionTranslation.getDeobf("net/minecraft/entity/item/EntityItem") + ";DDDFF)V")) {
            return (MethodVisitor) new func_177075_a(mv, access, name, desc, signature, exceptions);
        }
        return mv;
    }

    public class func_177077_a
            extends GeneratorAdapter implements Opcodes {
        int returno = 0;

        boolean patched;
        boolean ifnull;

        func_177077_a(MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
            super(262144, mv, access, name, desc);
        }


        public void visitJumpInsn(int opcode, Label label) {
            if (opcode == 198 && !this.ifnull) {
                this.ifnull = true;
                this.mv.visitJumpInsn(198, label);
                this.mv.visitVarInsn(25, 0);
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/Render/renderManager"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager") + ";");
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager/options"), "L" + VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings") + ";");
                this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings"), VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings/fancyGraphics"), "Z");
                this.mv.visitJumpInsn(153, label);
            } else {
                super.visitJumpInsn(opcode, label);
            }
        }


        public void visitInsn(int opcode) {
            if (opcode == 172) {
                this.returno++;
                if (this.returno == 2 && !this.patched) {
                    this.patched = true;
                    Label l18 = new Label();
                    this.mv.visitLabel(l18);
                    this.mv.visitLineNumber(62, l18);
                    this.mv.visitVarInsn(21, 12);
                    Label l19 = new Label();
                    this.mv.visitJumpInsn(154, l19);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/Render/renderManager"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager") + ";");
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager/options"), "L" + VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings") + ";");
                    Label l20 = new Label();
                    this.mv.visitJumpInsn(198, l20);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/Render/renderManager"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager") + ";");
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager/options"), "L" + VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings") + ";");
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings"), VersionTranslation.getDeobf("net/minecraft/client/settings/GameSettings/fancyGraphics"), "Z");
                    this.mv.visitJumpInsn(153, l20);
                    this.mv.visitLabel(l19);
                    this.mv.visitLineNumber(63, l19);
                    this.mv.visitFrame(3, 0, null, 0, null);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitInsn(3);
                    this.mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), "olditems", "Z");
                    Label l21 = new Label();
                    this.mv.visitLabel(l21);
                    this.mv.visitLineNumber(64, l21);
                    Label l22 = new Label();
                    this.mv.visitJumpInsn(167, l22);
                    this.mv.visitLabel(l20);
                    this.mv.visitLineNumber(65, l20);
                    this.mv.visitFrame(3, 0, null, 0, null);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitInsn(4);
                    this.mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), "olditems", "Z");
                    this.mv.visitLabel(l22);
                    this.mv.visitLineNumber(68, l22);
                    this.mv.visitFrame(3, 0, null, 0, null);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitFieldInsn(178, VersionTranslation.getPath(EnumAnimation.class), "OLDFASTITEMS", "L" + VersionTranslation.getPath(EnumAnimation.class) + ";");
                    this.mv.visitMethodInsn(184, VersionTranslation.getPath(AnimationManager.class), "getOldAnimationState", "(L" + VersionTranslation.getPath(EnumAnimation.class) + ";)Z", false);
                    Label l23 = new Label();
                    this.mv.visitJumpInsn(153, l23);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), "olditems", "Z");
                    Label l24 = new Label();
                    this.mv.visitJumpInsn(167, l24);
                    this.mv.visitLabel(l23);
                    this.mv.visitFrame(4, 0, null, 1, new Object[]{VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem")});
                    this.mv.visitInsn(3);
                    this.mv.visitLabel(l24);
                    this.mv.visitFrame(0, 13, new Object[]{VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), VersionTranslation.getDeobf("net/minecraft/entity/item/EntityItem"), Opcodes.DOUBLE, Opcodes.DOUBLE, Opcodes.DOUBLE, Opcodes.FLOAT, VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel"), VersionTranslation.getDeobf("net/minecraft/item/ItemStack"), VersionTranslation.getDeobf("net/minecraft/item/Item"), Opcodes.INTEGER, Opcodes.INTEGER, Opcodes.FLOAT, Opcodes.FLOAT}, 2, new Object[]{VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), Opcodes.INTEGER});
                    this.mv.visitFieldInsn(181, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), "olditems", "Z");
                }
            }
            super.visitInsn(opcode);
        }
    }

    public class func_177075_a
            extends GeneratorAdapter implements Opcodes {
        int iconst_0 = 0;
        boolean patched;

        func_177075_a(MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
            super(262144, mv, access, name, desc);
        }


        public void visitInsn(int opcode) {
            if (opcode == 3) {
                this.iconst_0++;
                if (this.iconst_0 == 5 && !this.patched) {
                    this.patched = true;
                    Label l15 = new Label();
                    this.mv.visitLabel(l15);
                    this.mv.visitLineNumber(109, l15);
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), "olditems", "Z");
                    Label l16 = new Label();
                    this.mv.visitJumpInsn(153, l16);
                    Label l17 = new Label();
                    this.mv.visitLabel(l17);
                    this.mv.visitLineNumber(110, l17);
                    this.mv.visitLdcInsn(new Float("180.0"));
                    this.mv.visitVarInsn(25, 0);
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderEntityItem"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/Render/renderManager"), "L" + VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager") + ";");
                    this.mv.visitFieldInsn(180, VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/entity/RenderManager/playerViewY"), "F");
                    this.mv.visitInsn(102);
                    this.mv.visitInsn(11);
                    this.mv.visitInsn(12);
                    this.mv.visitInsn(11);
                    this.mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/rotate"), "(FFFF)V", false);
                    Label l18 = new Label();
                    this.mv.visitLabel(l18);
                    this.mv.visitLineNumber(111, l18);
                    this.mv.visitInsn(12);
                    this.mv.visitInsn(12);
                    this.mv.visitLdcInsn(new Float("0.001"));
                    this.mv.visitMethodInsn(184, VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager"), VersionTranslation.getDeobf("net/minecraft/client/renderer/GlStateManager/scale"), "(FFF)V", false);
                    this.mv.visitLabel(l16);
                    this.mv.visitLineNumber(114, l16);
                    this.mv.visitFrame(1, 2, new Object[]{VersionTranslation.getDeobf("net/minecraft/client/resources/model/IBakedModel"), Opcodes.INTEGER}, 0, null);
                    this.mv.visitInsn(3);
                    this.mv.visitVarInsn(54, 14);
                }
            }
            super.visitInsn(opcode);
        }
    }
}


