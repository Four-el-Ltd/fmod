 package hlab.hmod.core.energy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PowerNet implements IPowerNet {
  private boolean isvalid = true;
  private HashMap<Integer, IEnergyConductor> links = new HashMap();
  private HashMap<Integer, IEnergyConnector> proxies = new HashMap();
  private List<IEnergyConnector> subscribers;

  public void joinNetworks(IPowerNet network) {
    if (network == this) {
      return;
    }

    for (IEnergyConductor conductor : network.getLinks()) {
      this.joinLink(conductor);
    }

    network.getLinks().clear();

    for (IEnergyConnector connector : network.getSubscribers()) {
      this.subscribe(connector);
    }
    network.getSubscribers().clear();
    network.destroy();

  }

  public IPowerNet joinLink(IEnergyConductor conductor) {
    if (conductor.getPowerNet() != null) {
      conductor.getPowerNet().leaveLink(conductor);
    }
    conductor.setPowerNet(this);
    int id = conductor.getId();
    this.links.put(id, conductor);
    return this;
  }

  public void leaveLink(IEnergyConductor conductor) {
    conductor.setPowerNet(null);
    int id = conductor.getId();
    this.links.remove(id);
  }

  public void subscribe(IEnergyConnector connector) {
    this.subscribers.add(connector);
  }

  public void unsubscribe(IEnergyConnector connector) {
    this.subscribers.remove(connector);
  }

  public boolean isSubscribed(IEnergyConnector connector) {
    return this.subscribers.contains(connector);
  }

  public List<IEnergyConductor> getLinks() {
    List<IEnergyConductor> linkslist = new ArrayList();
    linkslist.addAll(this.links.values());
    return linkslist;
  }

  public List<IEnergyConnector> getSubscribers() {
    return this.subscribers;
  }

  public void destroy() {
    this.isvalid = false;
    this.subscribers.clear();
    for (IEnergyConductor link : this.links.values()) {
      link.setPowerNet(null);
    }
    this.links.clear();

  }

  public long transferPower(long power) {
    List<Long> weights = new ArrayList<>();
    long TotalWeight = 0;
    for (IEnergyConnector con : this.subscribers) {
      long weight = con.getTransferWeight();
      weights.add(weight);
      TotalWeight += weight;
    }
    long TotalGiven = 0;
    for (int i = 0; i < this.subscribers.size(); i++) {
      IEnergyConnector con = this.subscribers.get(i);
      long weight = weights.get(i);
      double fraction = (double) weight / (double) TotalWeight;
      long given = (long) Math.floor(power * fraction);
      TotalGiven += (given - con.transferPower(given));

    }
    power -= TotalGiven;

    return power;
  }

}
