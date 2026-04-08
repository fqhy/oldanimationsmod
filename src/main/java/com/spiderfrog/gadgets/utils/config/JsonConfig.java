package com.spiderfrog.gadgets.utils.config;

import com.google.gson.*;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class JsonConfig {
    private static JsonConfig instance;

    public final Gson prettyGson = (new GsonBuilder()).setPrettyPrinting().create();
    public final Logger logger = LogManager.getLogger();
    public final File path = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "OldAnimationsMod" + File.separator);

    public static JsonConfig getInstance() {
        if (instance == null) {
            instance = new JsonConfig();
        }
        return instance;
    }


    protected File getTargetFile(File file) {
        return new File(this.path.getAbsolutePath(), file.getName());
    }

    public String getFileContent(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            char[] readerContent = new char[1];
            while (reader.read(readerContent) != -1) {
                sb.append(readerContent[0]);
            }
            reader.close();
        } catch (Exception ex) {
            return null;
        }
        return sb.toString();
    }


    private JsonObject readJsonOrCreate(File targetFile) {
        try {
            if (!targetFile.exists()) {
                this.path.mkdirs();
                targetFile.createNewFile();
                this.logger.info("[OldAnimationsMod] File: " + targetFile.getName() + " Created!");
                return new JsonObject();
            }
            String content = getFileContent(targetFile);
            if (content == null || content.trim().isEmpty()) {
                return new JsonObject();
            }
            return new JsonParser().parse(content).getAsJsonObject();
        } catch (Exception e) {
            this.logger.error("[OldAnimationsMod] Can't parse Config file: " + targetFile.getName());
            targetFile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File.");
            return new JsonObject();
        }
    }

    private void writeJson(File targetFile, JsonObject json) {
        try {
            FileWriter write = new FileWriter(targetFile);
            write.write(this.prettyGson.toJson((JsonElement) json));
            write.close();
        } catch (IOException e) {
            this.logger.error("[OldAnimationsMod] Can't write to Config file: " + targetFile.getName());
            e.printStackTrace();
        }
    }


    private void addPropertyInternal(File file, String valueName, Object value) {
        File targetFile = getTargetFile(file);
        JsonObject json = readJsonOrCreate(targetFile);

        if (json.has(valueName)) return;

        if (value instanceof Boolean) json.addProperty(valueName, (Boolean) value);
        else if (value instanceof Number) json.addProperty(valueName, (Number) value);
        else if (value instanceof String) json.addProperty(valueName, (String) value);

        writeJson(targetFile, json);
    }

    public void addProperty(File file, String valueName, boolean value) {
        addPropertyInternal(file, valueName, value);
    }

    private void savePropertyInternal(File file, String valueName, Object value) {
        File targetFile = getTargetFile(file);
        if (!targetFile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return;
        }

        JsonObject json = readJsonOrCreate(targetFile);
        json.remove(valueName);

        if (value instanceof Boolean) json.addProperty(valueName, (Boolean) value);
        else if (value instanceof Number) json.addProperty(valueName, (Number) value);
        else if (value instanceof String) json.addProperty(valueName, (String) value);

        writeJson(targetFile, json);
    }

    public void saveProperty(File file, String valueName, boolean value) {
        savePropertyInternal(file, valueName, value);
    }

    private JsonElement getPropertyInternal(File file, String valueName) {
        File targetFile = getTargetFile(file);
        if (!targetFile.exists()) {
            this.logger.error("[OldAnimationsMod] Can't find Config file: " + file.getName());
            return null;
        }

        JsonObject json = readJsonOrCreate(targetFile);
        if (json.has(valueName)) {
            return json.get(valueName);
        } else {
            this.logger.error("[OldAnimationsMod] Can't find: " + valueName + " in " + file.getName());
            targetFile.delete();
            this.logger.info("[OldAnimationsMod] Deleted invalid Config File!");
            return null;
        }
    }

    public boolean updatePropertyBoolean(File file, String valueName) {
        JsonElement el = getPropertyInternal(file, valueName);
        return el != null ? el.getAsBoolean() : false;
    }
}