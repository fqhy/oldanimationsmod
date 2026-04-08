package com.spiderfrog.gadgets.utils.config;

import java.io.File;

public interface ConfigFile {
    File configFile();

    void init();

    void createConfigFile();

    void loadConfigFile();

    void saveConfigFile();
}