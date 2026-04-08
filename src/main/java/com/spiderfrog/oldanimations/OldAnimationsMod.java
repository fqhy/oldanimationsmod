package com.spiderfrog.oldanimations;

import com.spiderfrog.oldanimations.animations.AnimationManager;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OldAnimationsMod {
    private boolean loaded;
    private static OldAnimationsMod instance;
    private Logger logger;
    public Minecraft mc;
    public AnimationManager animationManager;
    public Settings settings;

    public void initTweak() {
        runMod();
    }

    public void runMod() {
        if (this.loaded) {
            return;
        }
        this.loaded = true;
        (new Thread("OldAnimationsMod thread") {
            public void run() {
                OldAnimationsMod.this.logger = LogManager.getLogger("OAM");
                OldAnimationsMod.this.logger.info("[OldAnimationsMod] Start initialize OldAnimationsMod");
                OldAnimationsMod.instance = OldAnimationsMod.this;
                OldAnimationsMod.this.mc = Minecraft.getMinecraft();
                OldAnimationsMod.this.animationManager = new AnimationManager();
                OldAnimationsMod.this.settings = new Settings();

                OldAnimationsMod.this.animationManager.initAnimations();
                OldAnimationsMod.this.settings.init();
                OldAnimationsMod.this.logger.info("[OldAnimationsMod] Successfully initialized OldAnimationsMod");
            }
        }).start();
    }

    public static OldAnimationsMod getInstance() {
        if (instance == null) {
            instance = new OldAnimationsMod();
        }
        return instance;
    }

    public void sendMessage(String message) {
        this.logger.info("[OldAnimationsMod] " + message);
    }
}


