package com.spiderfrog.oldanimations.gui.animations;

import com.spiderfrog.oldanimations.OldAnimationsMod;
import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

import java.io.IOException;


public class OtherAnimationsSettingsBase
        extends GuiScreen {
    GuiScreen parentScreen;

    public OtherAnimationsSettingsBase(GuiScreen parent) {
        this.parentScreen = parent;
    }


    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "Save"));

        super.initGui();
    }


    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.enabled) {
            switch (button.id) {
                case 0:
                    (OldAnimationsMod.getInstance()).settings.saveConfigFile();
                    this.mc.displayGuiScreen(this.parentScreen);
                    break;
            }
        }
        super.actionPerformed(button);
    }


    public void onGuiClosed() {
        (OldAnimationsMod.getInstance()).settings.saveConfigFile();
    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        int scale = 3;
        String oldanimations = "Other";
        GL11.glScaled(scale, scale, scale);
        drawString(this.fontRendererObj, oldanimations, this.width / 2 / scale - this.fontRendererObj.getStringWidth(oldanimations) / 2, this.height / 11 / scale, 4648180);
        GL11.glScaled((1.0F / scale), (1.0F / scale), (1.0F / scale));

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void processAnimationsButton(EnumAnimation animation, GuiScreen gui) {
        OldAnimationsMod.getInstance().sendMessage(animation.getLangCode() + " Toggled!");
        AnimationManager.toggleOtherAnimation(animation);
        this.mc.displayGuiScreen(gui);
    }

    public static String animationButton(EnumAnimation animation) {
        return animation.getLangCode() + ": " + (AnimationManager.getOtherAnimationState(animation) ? (EnumChatFormatting.GREEN + "On") : (EnumChatFormatting.RED + "Off"));
    }
}


