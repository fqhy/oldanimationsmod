package com.spiderfrog.oldanimations;

import com.spiderfrog.gadgets.utils.config.ConfigFile;
import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;

import java.io.File;


public class Settings
        implements ConfigFile {
    public File configFile() {
        return new File("OldAnimationsMod.json");
    }

    public void init() {
        createConfigFile();
        loadConfigFile();
    }


    public void loadConfigFile() {
        try {
            for (EnumAnimation animation : EnumAnimation.values()) {
                switch (animation.getType()) {
                    case OLD:
                        AnimationManager.loadOldAnimationState(animation);
                        break;
                    case OTHER:
                        AnimationManager.loadOtherAnimationState(animation);
                        break;
                }
            }
        } catch (Exception e) {
            configFile().delete();
            createConfigFile();
            e.printStackTrace();
        }
    }


    public void saveConfigFile() {
        for (EnumAnimation animation : EnumAnimation.values()) {
            switch (animation.getType()) {
                case OLD:
                    AnimationManager.saveOldAnimationState(animation);
                    break;
                case OTHER:
                    AnimationManager.saveOtherAnimationState(animation);
                    break;
            }
        }
    }


    public void createConfigFile() {
        for (EnumAnimation animation : EnumAnimation.values()) {
            switch (animation.getType()) {
                case OLD:
                    AnimationManager.createOldAnimationState(animation);
                    break;
                case OTHER:
                    AnimationManager.createOtherAnimationState(animation);
                    break;
            }
        }
    }
}


