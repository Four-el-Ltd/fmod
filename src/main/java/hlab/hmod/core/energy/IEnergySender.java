package hlab.hmod.core.energy;

public interface IEnergySender extends IEnergyBaseNode {
  void sendEnergy(float energy, IEnergyBase receiver);
}
