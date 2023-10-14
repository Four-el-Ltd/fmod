package hlab.hmod.core.config;

public class ConfigValue<T> {
  private T value;

  public T getValue() {
    return value;
  }

  public void setValue(T newValue) {
    value = newValue;
  }
}
