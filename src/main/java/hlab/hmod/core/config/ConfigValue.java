package hlab.hmod.core.config;

public class ConfigValue<T> {
  private T value;
  private Class<T> valueType;

  ConfigValue(T value, Class<T> valueType) {
    this.value = value;
    this.valueType = valueType;
  }

  public T getValue() {
    return value;
  }

  public Class<T> getValueType() {
    return this.valueType;
  }

  public void setValue(T newValue) {
    value = newValue;
  }
}
