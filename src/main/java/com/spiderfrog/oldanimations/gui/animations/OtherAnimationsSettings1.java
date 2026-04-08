package com.spiderfrog.oldanimations.gui.animations;

import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.oldanimations.gui.utils.AnimationButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;


public class OtherAnimationsSettings1
        extends OtherAnimationsSettingsBase {
    public OtherAnimationsSettings1(GuiScreen parent) {
        super(parent);
    }


    public void initGui() {
        super.initGui();

        this.buttonList.add(new AnimationButton(1, this.width / 2 - 100, this.height / 4, EnumAnimation.NOINVBACKGROUND));
        this.buttonList.add(new AnimationButton(2, this.width / 2 + 2, this.height / 4, EnumAnimation.NOINVMOVE));
        this.buttonList.add(new AnimationButton(3, this.width / 2 - 100, this.height / 4 + 24, EnumAnimation.NOBOSSBAR));
    }


    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.enabled) {
            switch (button.id) {
                case 1:
                    processAnimationsButton(EnumAnimation.NOINVBACKGROUND, this);
                    break;
                case 2:
                    processAnimationsButton(EnumAnimation.NOINVMOVE, this);
                    break;
                case 3:
                    processAnimationsButton(EnumAnimation.NOBOSSBAR, this);
                    break;
            }

        }
        super.actionPerformed(button);
    }
}
