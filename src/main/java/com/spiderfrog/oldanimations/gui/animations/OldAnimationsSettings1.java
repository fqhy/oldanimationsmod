package com.spiderfrog.oldanimations.gui.animations;

import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.oldanimations.gui.utils.AnimationButton;
import net.minecraft.client.gui.GuiButton;

import java.io.IOException;


public class OldAnimationsSettings1
        extends OldAnimationsSettingsBase {
    public void initGui() {
        super.initGui();

        this.previousPage.enabled = false;

        this.buttonList.add(new AnimationButton(1, this.width / 2 - 100, this.height / 4, EnumAnimation.OLDBLOCKHIT));
        this.buttonList.add(new AnimationButton(2, this.width / 2 + 2, this.height / 4, EnumAnimation.OLDROD));
        this.buttonList.add(new AnimationButton(3, this.width / 2 - 100, this.height / 4 + 24, EnumAnimation.OLDBOW));
        this.buttonList.add(new AnimationButton(4, this.width / 2 + 2, this.height / 4 + 24, EnumAnimation.OLDDMG));
        this.buttonList.add(new AnimationButton(5, this.width / 2 - 100, this.height / 4 + 48, EnumAnimation.OLDHEARTS));
        this.buttonList.add(new AnimationButton(6, this.width / 2 + 2, this.height / 4 + 48, EnumAnimation.OLDSNEAK));
        this.buttonList.add(new AnimationButton(7, this.width / 2 - 100, this.height / 4 + 72, EnumAnimation.OLDBLOCKBUILD));
        this.buttonList.add(new AnimationButton(8, this.width / 2 + 2, this.height / 4 + 72, EnumAnimation.OLDDEBUG));
        this.buttonList.add(new AnimationButton(9, this.width / 2 - 100, this.height / 4 + 96, EnumAnimation.OLDEAT));
        this.buttonList.add(new AnimationButton(10, this.width / 2 + 2, this.height / 4 + 96, EnumAnimation.OLDPLAYERLIST));
    }


    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        if (button.enabled) {
            switch (button.id) {
                case 1:
                    processAnimationsButton(EnumAnimation.OLDBLOCKHIT, this);
                    break;
                case 2:
                    processAnimationsButton(EnumAnimation.OLDROD, this);
                    break;
                case 3:
                    processAnimationsButton(EnumAnimation.OLDBOW, this);
                    break;
                case 4:
                    processAnimationsButton(EnumAnimation.OLDDMG, this);
                    break;
                case 5:
                    processAnimationsButton(EnumAnimation.OLDHEARTS, this);
                    break;
                case 6:
                    processAnimationsButton(EnumAnimation.OLDSNEAK, this);
                    break;
                case 7:
                    processAnimationsButton(EnumAnimation.OLDBLOCKBUILD, this);
                    break;
                case 8:
                    processAnimationsButton(EnumAnimation.OLDDEBUG, this);
                    break;
                case 9:
                    processAnimationsButton(EnumAnimation.OLDEAT, this);
                    break;
                case 10:
                    processAnimationsButton(EnumAnimation.OLDPLAYERLIST, this);
                    break;
            }
        }
    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}