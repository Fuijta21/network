package com.example.classes;

import com.example.element.ClassElement;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class OspfSetting extends ClassElement {

    private int processId;

    private Config config;
    @JsonIgnore
    private ArrayList<OspfInterfaceSetting> ospfInterfaceSettings;
    @JsonIgnore
    private ArrayList<OspfVirtualLink> ospfVirtualLinks;

    public OspfSetting() {
        ospfInterfaceSettings = new ArrayList<>();
        ospfVirtualLinks = new ArrayList<>();
    }

    public ArrayList<OspfInterfaceSetting> getOspfInterfaceSettings() {
        return ospfInterfaceSettings;
    }

    public void setOspfInterfaceSettings(OspfInterfaceSetting s) {
        ospfInterfaceSettings.add(s);
    }

    public ArrayList<OspfVirtualLink> getOspfVirtualLinks() {
        return ospfVirtualLinks;
    }

    public void setOspfVirtualLinks(OspfVirtualLink o) {
        ospfVirtualLinks.add(o);
    }




    public void setOspfVirtualLink(OspfVirtualLink o) {
        ospfVirtualLinks.add(o);
    }

    private String routerId;

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getRouterId() {
        return routerId;
    }

    public void setRouterId(String routerId) {
        this.routerId = routerId;
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
    private ArrayList<OspfVirtualLink> ospfVirtualLink;

}
