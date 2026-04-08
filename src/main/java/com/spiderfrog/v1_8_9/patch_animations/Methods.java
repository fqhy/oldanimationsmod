package com.spiderfrog.v1_8_9.patch_animations;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class Methods {
    static Methods instance;

    public static Methods getInstance() {
        if (instance == null) {
            return instance = new Methods();
        }
        return instance;
    }


    public void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {
        float f = (startColor >> 24 & 0xFF) / 255.0F;
        float f1 = (startColor >> 16 & 0xFF) / 255.0F;
        float f2 = (startColor >> 8 & 0xFF) / 255.0F;
        float f3 = (startColor & 0xFF) / 255.0F;
        float f4 = (endColor >> 24 & 0xFF) / 255.0F;
        float f5 = (endColor >> 16 & 0xFF) / 255.0F;
        float f6 = (endColor >> 8 & 0xFF) / 255.0F;
        float f7 = (endColor & 0xFF) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(right, top, 0.0D).color(f1, f2, f3, f).endVertex();
        worldrenderer.pos(left, top, 0.0D).color(f1, f2, f3, f).endVertex();
        worldrenderer.pos(left, bottom, 0.0D).color(f5, f6, f7, f4).endVertex();
        worldrenderer.pos(right, bottom, 0.0D).color(f5, f6, f7, f4).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }


    public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height, float zLevel) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((x + 0), (y + height), zLevel).tex(((textureX + 0) * f), ((textureY + height) * f1)).endVertex();
        worldrenderer.pos((x + width), (y + height), zLevel).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
        worldrenderer.pos((x + width), (y + 0), zLevel).tex(((textureX + width) * f), ((textureY + 0) * f1)).endVertex();
        worldrenderer.pos((x + 0), (y + 0), zLevel).tex(((textureX + 0) * f), ((textureY + 0) * f1)).endVertex();
        tessellator.draw();
    }


    public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((x + 0), (y + height), 0.0D).tex(((textureX + 0) * f), ((textureY + height) * f1)).endVertex();
        worldrenderer.pos((x + width), (y + height), 0.0D).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
        worldrenderer.pos((x + width), (y + 0), 0.0D).tex(((textureX + width) * f), ((textureY + 0) * f1)).endVertex();
        worldrenderer.pos((x + 0), (y + 0), 0.0D).tex(((textureX + 0) * f), ((textureY + 0) * f1)).endVertex();
        tessellator.draw();
    }
}


