package com.spiderfrog.oldanimations.gui.animations;

import com.spiderfrog.oldanimations.OldAnimationsMod;
import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

import java.io.IOException;


public class OldAnimationsSettingsBase
        extends GuiScreen {
    public GuiButton nextPage;
    public GuiButton previousPage;

    public void initGui() {
        this.buttonList.add(new GuiButton(4000, 4, 4, 70, 20, "Others"));

        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "Save"));
        this.buttonList.add(this.nextPage = new GuiButton(1000, this.width / 2 + 110, this.height / 4 + 72 + 48, 40, 20, "->"));
        this.buttonList.add(this.previousPage = new GuiButton(2000, this.width / 2 - 150, this.height / 4 + 72 + 48, 40, 20, "<-"));

        super.initGui();
    }


    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.enabled) {
            switch (button.id) {
                case 4000:
                    this.mc.displayGuiScreen(new OtherAnimationsSettings1(this));
                    break;
                case 1000:
                    this.mc.displayGuiScreen(new OldAnimationsSettings2());
                    break;
                case 2000:
                    this.mc.displayGuiScreen(new OldAnimationsSettings1());
                    break;
                case 0:
                    (OldAnimationsMod.getInstance()).settings.saveConfigFile();
                    this.mc.setIngameFocus();
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
        String oldanimations = "Animations";
        GL11.glScaled(scale, scale, scale);
        this.fontRendererObj.drawStringWithShadow(oldanimations, (this.width / 2 / scale - this.fontRendererObj.getStringWidth(oldanimations) / 2), (this.height / 11 / scale), 4648180);

        GL11.glScaled((1.0F / scale), (1.0F / scale), (1.0F / scale));

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public String animationButton(String name, boolean value) {
        return name + ": " + (value ? (EnumChatFormatting.GREEN + "On") : (EnumChatFormatting.RED + "Off"));
    }

    public static String animationButton(EnumAnimation animation) {
        return animation.getLangCode() + ": " + (AnimationManager.getOldAnimationState(animation) ? (EnumChatFormatting.GREEN + "On") : (EnumChatFormatting.RED + "Off"));
    }

    public void processAnimationsButton(EnumAnimation animation, GuiScreen gui) {
        OldAnimationsMod.getInstance().sendMessage(animation.getLangCode() + " Toggled!");
        AnimationManager.toggleOldAnimation(animation);
        this.mc.displayGuiScreen(gui);
    }
}