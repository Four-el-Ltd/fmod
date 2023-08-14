package hlab.hmod.core.energy;

import java.math.BigInteger;
import java.util.List;

public interface IPowerNet {
  public void joinNetwork(IPowerNet network);

  public void subscribe(IEnergyConnector connector);

  public void unsubscribe(IEnergyConnector connector);

  public boolean isSubscribed(IEnergyConnector connector);

  public List<IEnergyConnector> getSubscribers();

  public void reevaluate();

  public long transferPower(long power);

  public BigInteger getTotalTransfered();
}
