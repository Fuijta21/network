package com.example.classes;

import com.example.element.ClassElement;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class StpSetting extends ClassElement {
    @JsonIgnore
    private int bridgePriority = -1;
    @JsonIgnore
    private int vlan = -1;

    public int getBridgePriority() {
        return bridgePriority;
    }

    public void setBridgePriority(int bridgePriority) {
        this.bridgePriority = bridgePriority;
    }

    public int getVlan() {
        return vlan;
    }

    public void setVlan(int vlan) {
        this.vlan = vlan;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        if (this.config != null) {
            setNodeFalseInstances(this.config);
            setNodeFalseInstances(config);
            setNodeFalseInstances(this);
            setmultiplicityErrorStatement("エラー:[" + getName() + "]と[" + config.getClassName() + "のインスタンス]の関連において、最大多重度を超えました。2個以上のオブジェクトを関連付けることはできません。");
        }
        this.config = config;
    }
    @JsonIgnore
    private String mode;
    @JsonIgnore
    private String macAddress;
    @JsonIgnore
    private Config config;

}
