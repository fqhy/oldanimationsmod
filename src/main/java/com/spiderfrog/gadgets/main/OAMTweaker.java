package com.spiderfrog.gadgets.main;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraftforge.fml.relauncher.FMLInjectionData;

import java.io.File;
import java.util.List;


public class OAMTweaker
        implements ITweaker {
    public static boolean RUNTIME_DEOBF = false;

    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
    }

    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        if (FMLInjectionData.data()[4].equals("1.8.9")) {
            classLoader.registerTransformer("com.spiderfrog.gadgets.main.ClassTransformer");
        } else {
            ClassTransformer.logger.error("Wrong Minecraft (" + FMLInjectionData.data()[4] + ") Version, could't tweak OAM " + "2.7.1" + " for Minecraft " + "1.8.9");
        }
    }


    public String getLaunchTarget() {
        return null;
    }


    public String[] getLaunchArguments() {
        return new String[0];
    }
}