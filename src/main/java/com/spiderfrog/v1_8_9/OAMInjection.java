package com.spiderfrog.v1_8_9;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.spiderfrog.oldanimations.animations.AnimationManager;
import com.spiderfrog.oldanimations.animations.EnumAnimation;
import com.spiderfrog.oldanimations.gui.animations.OldAnimationsSettings1;
import com.spiderfrog.v1_8_9.patch_animations.Methods;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.scoreboard.*;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldSettings;
import net.minecraftforge.fml.common.Loader;

import java.util.Comparator;
import java.util.List;


public class OAMInjection {
    public static void addOAMButton(List<GuiButton> buttonList) {
        buttonList.add(new GuiButton(21, 3, 3 + (Loader.isModLoaded("labymod") ? 25 : 0), 90, 20, "Animations"));
    }

    public static void performOAMButton(GuiButton button) {
        if (button.enabled && button.id == 21) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen) new OldAnimationsSettings1());
        }
    }


    private static Minecraft mc = Minecraft.getMinecraft();


    public static void blockbuild() {
        try {
            if (AnimationManager.getOldAnimationState(EnumAnimation.OLDBLOCKBUILD) && mc.thePlayer.getItemInUseCount() != 0 &&
                    mc.gameSettings.keyBindAttack.isKeyDown() && mc.gameSettings.keyBindUseItem.isKeyDown() &&
                    mc.objectMouseOver != null && mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                swingItem((EntityLivingBase) mc.thePlayer);

            }
        } catch (Exception exception) {
        }
    }


    private static void swingItem(EntityLivingBase e) {
        if (!e.isSwingInProgress || e.swingProgressInt >= getArmSwingAnimationEnd(e) / 2 || e.swingProgressInt < 0) {

            e.swingProgressInt = -1;
            e.isSwingInProgress = true;
        }
    }

    private static int getArmSwingAnimationEnd(EntityLivingBase e) {
        return e.isPotionActive(Potion.digSpeed) ? (6 - (1 + e.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1) : (e.isPotionActive(Potion.digSlowdown) ? (6 + (1 + e.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2) : 6);
    }


    public static void transformHeldItem(EntityLivingBase entitylivingbaseIn, RendererLivingEntity livingEntityRenderer) {
        if (entitylivingbaseIn instanceof EntityPlayer) {
            if (AnimationManager.getOldAnimationState(EnumAnimation.OLDSWORD)) {
                if (((EntityPlayer) entitylivingbaseIn).isBlocking()) {
                    if (entitylivingbaseIn.isSneaking()) {
                        ((ModelBiped) livingEntityRenderer.getMainModel()).postRenderArm(0.0325F);
                        GlStateManager.scale(1.05F, 1.05F, 1.05F);
                        GlStateManager.translate(-0.58F, 0.32F, -0.07F);
                        GlStateManager.rotate(-24405.0F, 137290.0F, -2009900.0F, -2654900.0F);
                    } else {
                        ((ModelBiped) livingEntityRenderer.getMainModel()).postRenderArm(0.0325F);
                        GlStateManager.scale(1.05F, 1.05F, 1.05F);
                        GlStateManager.translate(-0.45F, 0.25F, -0.07F);
                        GlStateManager.rotate(-24405.0F, 137290.0F, -2009900.0F, -2654900.0F);
                    }
                } else {
                    ((ModelBiped) livingEntityRenderer.getMainModel()).postRenderArm(0.0625F);
                }
            } else {
                ((ModelBiped) livingEntityRenderer.getMainModel()).postRenderArm(0.0625F);
            }

            if (!AnimationManager.getOldAnimationState(EnumAnimation.OLDITEMHELD)) {

                GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            } else if (!((EntityPlayer) entitylivingbaseIn).isBlocking() && AnimationManager.getOldAnimationState(EnumAnimation.OLDITEMHELD) && !entitylivingbaseIn.isSneaking()) {

                GlStateManager.translate(-0.0855F, 0.4775F, 0.1585F);
                GlStateManager.rotate(-19.0F, 20.0F, 0.0F, -6.0F);
            } else if (entitylivingbaseIn.isSneaking() && !((EntityPlayer) entitylivingbaseIn).isBlocking() && AnimationManager.getOldAnimationState(EnumAnimation.OLDITEMHELD)) {

                GlStateManager.translate(-0.0525F, 0.5375F, 0.0725F);
                GlStateManager.rotate(16.0F, -8.0F, 0.0F, 5.0F);
                GlStateManager.translate(0.0F, 0.1F, 0.09523F);
            } else if (((EntityPlayer) entitylivingbaseIn).isBlocking()) {

                GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
            }
        } else {
            ((ModelBiped) livingEntityRenderer.getMainModel()).postRenderArm(0.0625F);
            GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
        }
    }


    public static void performOldAnimations(Minecraft mc, ItemStack itemToRender, float swingProgress) {
        if (itemToRender != null) {
            if (AnimationManager.getOldAnimationState(EnumAnimation.OLDROD) && itemToRender.getItem() instanceof net.minecraft.item.ItemCarrotOnAStick) {
                GlStateManager.translate(0.08F, -0.027F, -0.33F);
                GlStateManager.scale(0.93F, 1.0F, 1.0F);
            }
            if (AnimationManager.getOldAnimationState(EnumAnimation.OLDROD) && itemToRender.getItem() instanceof net.minecraft.item.ItemFishingRod) {
                GlStateManager.translate(0.08F, -0.027F, -0.33F);
                GlStateManager.scale(0.93F, 1.0F, 1.0F);
            }
            try {
                if (AnimationManager.getOldAnimationState(EnumAnimation.OLDBOW) && mc.thePlayer.getItemInUse().getItem() instanceof net.minecraft.item.ItemBow) {
                    GlStateManager.translate(-0.01F, 0.05F, -0.06F);
                }
            } catch (Exception exception) {
            }
        }


        if (AnimationManager.getOldAnimationState(EnumAnimation.OLDSWING) && swingProgress != 0.0F && !mc.thePlayer.isBlocking() && !mc.thePlayer.isEating() && !mc.thePlayer.isUsingItem()) {
            GlStateManager.scale(0.85F, 0.85F, 0.85F);
            GlStateManager.translate(-0.06F, 0.003F, 0.05F);
        }
    }


    private static final Ordering field_175252_a = Ordering.from(new PlayerComparator(null));
    public static final ResourceLocation icons = new ResourceLocation("textures/gui/icons.png");

    protected static float zLevel;


    public static void renderPlayerlistOld(int width, Scoreboard scoreboardIn, ScoreObjective scoreObjectiveIn) {
        try {
            NetHandlerPlayClient var4 = mc.thePlayer.sendQueue;
            List<NetworkPlayerInfo> var42 = field_175252_a.sortedCopy(var4.getPlayerInfoMap());
            int var15 = mc.thePlayer.sendQueue.currentServerMaxPlayers;
            int var16 = var15;
            ScaledResolution var5 = new ScaledResolution(mc);
            int var17 = 0;
            int var6 = var5.getScaledWidth();
            int var21 = 0;
            int var22 = 0;
            int var23 = 0;
            for (var17 = 1; var16 > 20; var16 = (var15 + var17 - 1) / var17) {
                var17++;
            }
            int var46 = 300 / var17;
            if (var46 > 150) {
                var46 = 150;
            }
            int var19 = (var6 - var17 * var46) / 2;
            byte var47 = 10;
            Gui.drawRect(var19 - 1, var47 - 1, var19 + var46 * var17, var47 + 9 * var16, -2147483648);
            for (var21 = 0; var21 < var15; var21++) {

                var22 = var19 + var21 % var17 * var46;
                var23 = var47 + var21 / var17 * 9;
                Gui.drawRect(var22, var23, var22 + var46 - 1, var23 + 8, 553648127);
                GlStateManager.enableAlpha();
                if (var21 < var42.size()) {

                    NetworkPlayerInfo var48 = var42.get(var21);
                    String name = var48.getGameProfile().getName();
                    ScorePlayerTeam var49 = mc.theWorld.getScoreboard().getPlayersTeam(name);
                    String var50 = getPlayerName(var48);
                    GlStateManager.color(1.0F, 1.0F, 1.0F);
                    mc.fontRendererObj.drawStringWithShadow(var50, var22, var23, -1);
                    if (scoreObjectiveIn != null) {

                        int var27 = var22 + mc.fontRendererObj.getStringWidth(var50) + 5;
                        int var28 = var22 + var46 - 12 - 5;
                        if (var28 - var27 > 5) {

                            Score var29 = scoreboardIn.getValueFromObjective(name, scoreObjectiveIn);
                            String var30 = EnumChatFormatting.YELLOW + "" + var29.getScorePoints();
                            mc.fontRendererObj.drawStringWithShadow(var30, (var28 - mc.fontRendererObj.getStringWidth(var30)), var23, 16777215);
                        }
                    }
                    drawPing(50, var22 + var46 - 52, var23, var48);
                }
            }
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableLighting();
            GlStateManager.enableAlpha();
        } catch (Exception exception) {
        }
    }


    private static String getPlayerName(NetworkPlayerInfo p_175243_1_) {
        return (p_175243_1_.getDisplayName() != null) ? p_175243_1_.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName((Team) p_175243_1_.getPlayerTeam(), p_175243_1_.getGameProfile().getName());
    }

    protected static void drawPing(int p_175245_1_, int p_175245_2_, int p_175245_3_, NetworkPlayerInfo p_175245_4_) {
        byte b1;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(icons);
        byte b0 = 0;
        boolean flag = false;


        if (p_175245_4_.getResponseTime() < 0) {

            b1 = 5;
        } else if (p_175245_4_.getResponseTime() < 150) {

            b1 = 0;
        } else if (p_175245_4_.getResponseTime() < 300) {

            b1 = 1;
        } else if (p_175245_4_.getResponseTime() < 600) {

            b1 = 2;
        } else if (p_175245_4_.getResponseTime() < 1000) {

            b1 = 3;
        } else {

            b1 = 4;
        }

        zLevel += 100.0F;
        drawTexturedModalRect(p_175245_2_ + p_175245_1_ - 11, p_175245_3_, 0 + b0 * 10, 176 + b1 * 8, 10, 8, zLevel);
        zLevel -= 100.0F;
    }

    static class PlayerComparator
            implements Comparator {
        private static final String __OBFID = "CL_00001941";

        private PlayerComparator() {
        }

        public int func_178952_a(NetworkPlayerInfo p_178952_1_, NetworkPlayerInfo p_178952_2_) {
            ScorePlayerTeam scoreplayerteam = p_178952_1_.getPlayerTeam();
            ScorePlayerTeam scoreplayerteam1 = p_178952_2_.getPlayerTeam();
            return ComparisonChain.start().compareTrueFirst((p_178952_1_.getGameType() != WorldSettings.GameType.SPECTATOR), (p_178952_2_.getGameType() != WorldSettings.GameType.SPECTATOR)).compare((scoreplayerteam != null) ? scoreplayerteam.getRegisteredName() : "", (scoreplayerteam1 != null) ? scoreplayerteam1.getRegisteredName() : "").compare(p_178952_1_.getGameProfile().getName(), p_178952_2_.getGameProfile().getName()).result();
        }


        public int compare(Object p_compare_1_, Object p_compare_2_) {
            return func_178952_a((NetworkPlayerInfo) p_compare_1_, (NetworkPlayerInfo) p_compare_2_);
        }


        PlayerComparator(Object p_i45528_1_) {
            this();
        }
    }


    public static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height, float zLevel) {
        Methods.getInstance().drawTexturedModalRect(x, y, textureX, textureY, width, height, zLevel);
    }
}


