package hlab.hmod.core.energy;

import java.math.BigInteger;
import java.util.List;

public interface IPowerNet {
  public void joinNetworks(IPowerNet network);

  public void subscribe(IEnergyConnector connector);

  public void unsubscribe(IEnergyConnector connector);

  public boolean isSubscribed(IEnergyConnector connector);

  public List<IEnergyConductor> getLinks();

  public List<IEnergyConnector> getSubscribers();

  public IPowerNet joinLink(IEnergyConductor conductor);

  public void leaveLink(IEnergyConductor conductor);

  public void destroy();

  // public void reevaluate();

  public long transferPower(long power);
}
