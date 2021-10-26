package com.project.Models;

import java.sql.Timestamp;

public class NetworkBandwidthUtilization {
    private Timestamp timestamp;
    private String server;
    private String interfaceName;
    private float networkRate;

    public NetworkBandwidthUtilization(Timestamp timestamp, String server, String interfaceName, float netBitRate, float bandwidth) {
        this.timestamp = timestamp;
        this.server = server;
        this.interfaceName = interfaceName;
        this.networkRate = netBitRate / bandwidth;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public float getNetworkRate() {
        return networkRate;
    }

    public void setNetworkRate(float networkRate) {
        this.networkRate = networkRate;
    }

    @Override
    public String toString() {
        return this.timestamp  + " " + this.server + " " + this.interfaceName + " " + this.networkRate;
    }
}
