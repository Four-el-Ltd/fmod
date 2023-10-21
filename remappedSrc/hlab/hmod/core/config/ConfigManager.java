package hlab.hmod.core.config;

import java.util.HashMap;

public class ConfigManager {
  static HashMap<String, ConfigValue<?>> configs = new HashMap<String, ConfigValue<?>>();

  public static ConfigValue<?> readValue(String name) {
    return configs.get(name);
  }
}
