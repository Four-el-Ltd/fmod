package hlab.hmod.core.energy;

public class EnergyContract {
  private boolean isProcessed = false;
  private AbstractEnergyReceiver receiver;

  EnergyContract(AbstractEnergyReceiver receiver, IEnergySender sender) {
    this.receiver = receiver;
  }

  public boolean process() {
    if (isProcessed) {
      return false;
    }
    if (receiver.receive(0)) {
      this.isProcessed = true;
      return true;
    } else {
      return false;
    }
  }
}
