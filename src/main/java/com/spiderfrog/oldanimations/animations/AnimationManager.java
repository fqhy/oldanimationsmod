package com.spiderfrog.oldanimations.animations;

import com.spiderfrog.gadgets.utils.config.JsonConfig;
import com.spiderfrog.oldanimations.OldAnimationsMod;

import java.util.HashMap;


public class AnimationManager {
    private static HashMap<EnumAnimation, Boolean> oldAnimations = new HashMap<EnumAnimation, Boolean>();
    private static HashMap<EnumAnimation, Boolean> otherAnimations = new HashMap<EnumAnimation, Boolean>();

    public void initAnimations() {
        oldAnimations.clear();
        for (EnumAnimation animation : EnumAnimation.values()) {
            switch (animation.getType()) {
                case OLD:
                    oldAnimations.put(animation, Boolean.valueOf(true));
                    break;
                case OTHER:
                    otherAnimations.put(animation, Boolean.valueOf(false));
                    break;
            }
        }
    }

    public static void toggleOldAnimation(EnumAnimation animation) {
        boolean value = ((Boolean) oldAnimations.get(animation)).booleanValue();
        value = !value;
        oldAnimations.replace(animation, Boolean.valueOf(value));
    }

    public static void toggleOtherAnimation(EnumAnimation animation) {
        boolean value = ((Boolean) otherAnimations.get(animation)).booleanValue();
        value = !value;
        otherAnimations.replace(animation, Boolean.valueOf(value));
    }

    public static boolean getOldAnimationState(EnumAnimation animation) {
        return ((Boolean) oldAnimations.get(animation)).booleanValue();
    }

    public static boolean getOtherAnimationState(EnumAnimation animation) {
        return ((Boolean) otherAnimations.get(animation)).booleanValue();
    }

    public static void loadOldAnimationState(EnumAnimation animation) throws Exception {
        boolean state = JsonConfig.getInstance().updatePropertyBoolean((OldAnimationsMod.getInstance()).settings.configFile(), animation.getVarName());
        oldAnimations.replace(animation, Boolean.valueOf(state));
    }

    public static void loadOtherAnimationState(EnumAnimation animation) throws Exception {
        boolean state = JsonConfig.getInstance().updatePropertyBoolean((OldAnimationsMod.getInstance()).settings.configFile(), animation.getVarName());
        otherAnimations.replace(animation, Boolean.valueOf(state));
    }

    public static void saveOldAnimationState(EnumAnimation animation) {
        JsonConfig.getInstance().saveProperty((OldAnimationsMod.getInstance()).settings.configFile(), animation.getVarName(), getOldAnimationState(animation));
    }

    public static void saveOtherAnimationState(EnumAnimation animation) {
        JsonConfig.getInstance().saveProperty((OldAnimationsMod.getInstance()).settings.configFile(), animation.getVarName(), getOtherAnimationState(animation));
    }

    public static void createOldAnimationState(EnumAnimation animation) {
        JsonConfig.getInstance().addProperty((OldAnimationsMod.getInstance()).settings.configFile(), animation.getVarName(), getOldAnimationState(animation));
    }

    public static void createOtherAnimationState(EnumAnimation animation) {
        JsonConfig.getInstance().addProperty((OldAnimationsMod.getInstance()).settings.configFile(), animation.getVarName(), getOtherAnimationState(animation));
    }
}


