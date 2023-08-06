package hlab.hmod.core.energy;

public interface IEnergyBase {
  float getMaxEnergy();

  void addEnergy(float energy);

  void removeEnergy(float energy);

  void setEnergy(float energy);

}
