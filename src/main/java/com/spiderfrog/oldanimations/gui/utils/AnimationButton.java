package com.spiderfrog.oldanimations.gui.utils;

import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.oldanimations.gui.animations.OldAnimationsSettingsBase;
import com.spiderfrog.oldanimations.gui.animations.OtherAnimationsSettingsBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;


public class AnimationButton
        extends GuiButton {
    protected static final ResourceLocation buttonTextures = new ResourceLocation("textures/gui/widgets.png");

    public AnimationButton(int buttonId, int x, int y, EnumAnimation animation) {
        super(buttonId, x, y, 98, 20, (animation.getType() == EnumAnimation.AnimationType.OLD) ? OldAnimationsSettingsBase.animationButton(animation) : OtherAnimationsSettingsBase.animationButton(animation));
        this.width = 98;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = buttonId;
        this.xPosition = x;
        this.yPosition = y;
        this.displayString = (animation.getType() == EnumAnimation.AnimationType.OLD) ? OldAnimationsSettingsBase.animationButton(animation) : OtherAnimationsSettingsBase.animationButton(animation);
    }


    protected int getHoverState(boolean mouseOver) {
        int i = 1;

        if (!this.enabled) {

            i = 0;
        } else if (mouseOver) {

            i = 2;
        }

        return i;
    }


    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.visible) {

            FontRenderer fontrenderer = (Minecraft.getMinecraft()).fontRendererObj;
            mc.getTextureManager().bindTexture(buttonTextures);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            int i = getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + i * 20, this.width / 2, this.height);
            drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
            mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (!this.enabled) {

                j = 10526880;
            } else if (this.hovered) {

                j = 16777120;
            }

            fontrenderer.drawStringWithShadow(this.displayString, (this.xPosition + this.width / 2 - fontrenderer.getStringWidth(this.displayString) / 2), (this.yPosition + (this.height - 8) / 2), j);
        }
    }


    protected void mouseDragged(Minecraft mc, int mouseX, int mouseY) {
    }


    public void mouseReleased(int mouseX, int mouseY) {
    }


    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        return (this.enabled && this.visible && mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
    }


    public boolean isMouseOver() {
        return this.hovered;
    }


    public void drawButtonForegroundLayer(int mouseX, int mouseY) {
    }


    public void playPressSound(SoundHandler soundHandlerIn) {
        soundHandlerIn.playSound((ISound) PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
    }


    public int getButtonWidth() {
        return this.width;
    }


    public void setWidth(int width) {
        this.width = width;
    }
}
