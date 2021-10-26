package com.project.Models;

public class Bandwidth {
    private String server;
    private String interfaceName;
    private float bandwidth;

    public Bandwidth(String server, String interfaceName, float bandwidth) {
        this.server = server;
        this.interfaceName = interfaceName;
        this.bandwidth = bandwidth;
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

    public float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(float bandwidth) {
        this.bandwidth = bandwidth;
    }

    @Override
    public String toString() {
        return "Bandwidth{" +
                "server='" + server + '\'' +
                ", interfaceName='" + interfaceName + '\'' +
                ", bandwidth=" + bandwidth +
                '}';
    }
}
