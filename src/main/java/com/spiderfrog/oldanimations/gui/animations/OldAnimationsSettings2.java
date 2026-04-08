package com.spiderfrog.oldanimations.gui.animations;

import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.oldanimations.gui.utils.AnimationButton;
import net.minecraft.client.gui.GuiButton;

import java.io.IOException;


public class OldAnimationsSettings2
        extends OldAnimationsSettingsBase {
    public void initGui() {
        super.initGui();

        this.nextPage.enabled = false;

        this.buttonList.add(new AnimationButton(1, this.width / 2 - 100, this.height / 4, EnumAnimation.OLDSWORD));
        this.buttonList.add(new AnimationButton(2, this.width / 2 + 2, this.height / 4, EnumAnimation.OLDITEMHELD));
        this.buttonList.add(new AnimationButton(3, this.width / 2 - 100, this.height / 4 + 24, EnumAnimation.OLDHITBOX));
        this.buttonList.add(new AnimationButton(4, this.width / 2 + 2, this.height / 4 + 24, EnumAnimation.OLDSWING));
        this.buttonList.add(new AnimationButton(5, this.width / 2 - 100, this.height / 4 + 48, EnumAnimation.OLDITEMUPDATE));
        this.buttonList.add(new AnimationButton(6, this.width / 2 + 2, this.height / 4 + 48, EnumAnimation.OLDFASTITEMS));
        this.buttonList.add(new AnimationButton(7, this.width / 2 - 100, this.height / 4 + 72, EnumAnimation.OLDCROSSHAIR));
        this.buttonList.add(new AnimationButton(8, this.width / 2 + 2, this.height / 4 + 72, EnumAnimation.OLDENCHGLINT));
    }


    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        if (button.enabled) {
            switch (button.id) {
                case 1:
                    processAnimationsButton(EnumAnimation.OLDSWORD, this);
                    break;
                case 2:
                    processAnimationsButton(EnumAnimation.OLDITEMHELD, this);
                    break;
                case 3:
                    processAnimationsButton(EnumAnimation.OLDHITBOX, this);
                    break;
                case 4:
                    processAnimationsButton(EnumAnimation.OLDSWING, this);
                    break;
                case 5:
                    processAnimationsButton(EnumAnimation.OLDITEMUPDATE, this);
                    break;
                case 6:
                    processAnimationsButton(EnumAnimation.OLDFASTITEMS, this);
                    break;
                case 7:
                    processAnimationsButton(EnumAnimation.OLDCROSSHAIR, this);
                    break;
                case 8:
                    processAnimationsButton(EnumAnimation.OLDENCHGLINT, this);
                    break;
            }
        }
    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
