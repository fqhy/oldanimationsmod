package com.spiderfrog.gadgets.main;

import com.spiderfrog.v1_8_9.patch_animations.*;
import com.spiderfrog.v1_8_9.patch_gadgets.PatchGuiIngameMenu;
import com.spiderfrog.v1_8_9.patch_gadgets.PatchMinecraft;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;


public class ClassTransformer
        implements IClassTransformer {
    public static Logger logger = LogManager.getLogger("OAM");

    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (transformedName.equals("net.minecraft.client.Minecraft") && !name.equals("net.minecraft.client.Minecraft")) {
            OAMTweaker.RUNTIME_DEOBF = true;
        }
        if (transformedName.equals("net.minecraft.client.Minecraft")) {
            logger.info("Found Minecraft Class to inject");
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchMinecraft(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.GuiIngameMenu")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchGuiIngameMenu(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.ItemRenderer")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchItemRenderer(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.GuiPlayerTabOverlay")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchGuiPlayerTabOverlay(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.entity.player.EntityPlayer")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchEntityPlayer(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RenderItem")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchRenderItem(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.EntityRenderer")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchEntityRenderer(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.layers.LayerBipedArmor")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchLayerBipedArmor(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.GuiIngame")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchGuiIngame(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraftforge.client.GuiIngameForge")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchGuiIngameForge(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.FontRenderer")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchFontRenderer(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.layers.LayerHeldItem")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchLayerHeldItem(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.model.ModelBiped")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchModelBiped(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RenderManager")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchRenderManager(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RenderEntityItem")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchRenderEntityItem(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.GlStateManager")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchGlStateManager(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.InventoryEffectRenderer")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchInventoryEffectRenderer(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.gui.inventory.GuiContainer")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchGuiContainer(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.multiplayer.PlayerControllerMP")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchPlayerControllerMP(262144, cw), 8);
            return cw.toByteArray();
        }
        if (transformedName.equals("net.minecraft.client.renderer.entity.RenderFish")) {
            ClassReader classReader = new ClassReader(bytes);
            ClassWriter cw = new ClassWriter(classReader, 3);
            classReader.accept((ClassVisitor) new PatchRenderFish(262144, cw), 8);
            return cw.toByteArray();
        }
        return bytes;
    }
}
