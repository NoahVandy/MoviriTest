package com.project.Models;

import java.sql.Timestamp;

public class NetworkBitrate {

    private Timestamp timestamp;
    private String server;
    private String interfaceName;
    private Float netBitRate;

    public NetworkBitrate(Timestamp timestamp, String server, String interfaceName, Float netBitRate) {
        this.timestamp = timestamp;
        this.server = server;
        this.interfaceName = interfaceName;
        this.netBitRate = netBitRate;
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

    public Float getNetBitRate() {
        return netBitRate;
    }

    public void setNetBitRate(Float netBitRate) {
        this.netBitRate = netBitRate;
    }

    @Override
    public String toString() {
        return "NetworkBitrate{" +
                "timestamp=" + timestamp +
                ", server='" + server + '\'' +
                ", interfaceName='" + interfaceName + '\'' +
                ", netBitRate=" + netBitRate +
                '}';
    }
}
