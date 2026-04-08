package com.spiderfrog.v1_8_9;

import com.spiderfrog.gadgets.main.OAMTweaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class VersionTranslation {
    private static boolean initialized;
    private static HashMap<String, String> classTranslations;
    private static HashMap<String, String> srgMethodTranslations;
    private static HashMap<String, String> srgFieldTranslations;
    private static HashMap<String, String> methodTranslations;
    private static HashMap<String, String> fieldTranslations;

    public static String getDeobf(String name) {
        if (!initialized) {
            joined();
        }
        if (classTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? classTranslations.get(name) : name;
        }


        if (srgMethodTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? srgMethodTranslations.get(name) : name.substring(name.lastIndexOf('/') + 1);
        }

        if (srgFieldTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? srgFieldTranslations.get(name) : name.substring(name.lastIndexOf('/') + 1);
        }

        if (methodTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? methodTranslations.get(name) : name.substring(name.lastIndexOf('/') + 1);
        }

        if (fieldTranslations.containsKey(name)) {
            return OAMTweaker.RUNTIME_DEOBF ? fieldTranslations.get(name) : name.substring(name.lastIndexOf('/') + 1);
        }

        System.out.println("[OldAnimationsMod] Unknown Translation: " + name);
        return name;
    }

    public static String getPath(Class clazz) {
        String name = clazz.getName();
        if (name.startsWith("com.spiderfrog")) {
            return name.replace(".", "/");
        }
        return name;
    }

    private static void joined() {
        initialized = true;
        BufferedReader fileReader = null;
        classTranslations = new HashMap<String, String>();
        methodTranslations = new HashMap<String, String>();
        fieldTranslations = new HashMap<String, String>();
        srgFieldTranslations = new HashMap<String, String>();
        srgMethodTranslations = new HashMap<String, String>();


        try {
            fileReader = new BufferedReader(new InputStreamReader(VersionTranslation.class.getResourceAsStream("/assets/minecraft/oldanimations/mappings/" + "1.8.9".replace(".", "_") + "/methods.csv")));

            String line = null;
            while ((line = fileReader.readLine()) != null) {
                methodTranslations.put(line.split(",")[0], line.split(",")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException iOException) {
                }
            }
        }


        try {
            fileReader = new BufferedReader(new InputStreamReader(VersionTranslation.class.getResourceAsStream("/assets/minecraft/oldanimations/mappings/" + "1.8.9".replace(".", "_") + "/fields.csv")));

            String line = null;
            while ((line = fileReader.readLine()) != null) {
                fieldTranslations.put(line.split(",")[0], line.split(",")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException iOException) {
                }
            }
        }


        try {
            fileReader = new BufferedReader(new InputStreamReader(VersionTranslation.class.getResourceAsStream("/assets/minecraft/oldanimations/mappings/" + "1.8.9".replace(".", "_") + "/joined.srg")));

            String line = null;
            while ((line = fileReader.readLine()) != null) {
                if (line.startsWith("CL:")) {
                    classTranslations.put(line.split(" ")[2], line.split(" ")[1]);
                }
                if (line.startsWith("MD:")) {
                    String methoddeobf = line.split(" ")[3];
                    String methodobf = line.split(" ")[1].split("/")[1];
                    srgMethodTranslations.put(methoddeobf, methodobf);
                    String srgName = methoddeobf.substring(methoddeobf.lastIndexOf('/') + 1);
                    if (methodTranslations.containsKey(srgName)) {
                        methodTranslations.put(methoddeobf.replace(srgName, "") + (String) methodTranslations.get(srgName), methodobf);
                    }
                }
                if (line.startsWith("FD:")) {
                    String fielddeobf = line.split(" ")[2];
                    String fieldobf = line.split(" ")[1].split("/")[1];
                    srgFieldTranslations.put(fielddeobf, fieldobf);
                    String srgName = fielddeobf.substring(fielddeobf.lastIndexOf('/') + 1);
                    if (fieldTranslations.containsKey(srgName)) {
                        fieldTranslations.put(fielddeobf.replace(srgName, "") + (String) fieldTranslations.get(srgName), fieldobf);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null)
                try {
                    fileReader.close();
                } catch (IOException iOException) {
                }
        }
    }
}


