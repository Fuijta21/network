package com.example.classes;

import com.example.element.ClassElement;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;


import static java.lang.Integer.parseInt;

public class EthernetSetting extends LinkableElement {

    private int slot = -1;//int型の初期値は-1
    private int mtu = -1;

    public int getMtu() {
        return mtu;
    }

    public void setMtu(int mtu) {
        this.mtu = mtu;
    }

    private ArrayList<Integer> allowedVlans;
    @JsonIgnore
    private ClassElement conectedThing;//接続先のEthernetSettingかCliet 属性ではない
    private EthernetType ethernetType = null;
    private String allowdVlanString;
    private String subnetMask;
    private int port = -1;
    private String ipAddress;

    public String getAllowdVlanString() {
        return allowdVlanString;
    }

    public void setAllowdVlanString(String allowdVlanString) {
        this.allowdVlanString = allowdVlanString;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    public int getAccessVlan() {
        return accessVlan;
    }

    public void setAccessVlan(int accessVlan) {
        this.accessVlan = accessVlan;
    }

    public int getNativeVlan() {
        return nativeVlan;
    }

    public void setNativeVlan(int nativeVlan) {
        this.nativeVlan = nativeVlan;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getAccessListNumber() {
        return accessListNumber;
    }

    public void setAccessListNumber(int accessListNumber) {
        this.accessListNumber = accessListNumber;
    }

    public String getAccessListName() {
        return accessListName;
    }

    public void setAccessListName(String accessListName) {
        this.accessListName = accessListName;
    }

    public String getAccessListInOrOut() {
        return accessListInOrOut;
    }

    public void setAccessListInOrOut(String accessListInOrOut) {
        this.accessListInOrOut = accessListInOrOut;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDuplex() {
        return duplex;
    }

    public void setDuplex(String duplex) {
        this.duplex = duplex;
    }

    public boolean isIpVirtualReassembly() {
        return ipVirtualReassembly;
    }

    public EthernetType getEthernetType() {
        return ethernetType;
    }


    public void setEthernetType(EthernetType ethernetType) {
        this.ethernetType = ethernetType;
    }

    public ArrayList<Integer> getAllowedVlans() {
        return allowedVlans;
    }

    public ClassElement getConectedThing() {
        return conectedThing;
    }

    public void setConectedThing(ClassElement conectedThing) {//接続先のEthernetSettingかClietのセット
        this.conectedThing = conectedThing;
    }

    public void setAllowedVlan() {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> vlanNumbers = new ArrayList<>();
        if (getAllowdVlanString().isEmpty()) {//入力がない時はすべてのvlanを許可する
//            Config config = new Config();
//            config = this.getConfig();
//            if (config != null) {
//                ArrayList<Vlan> vlans = config.getVlan();
//                for (Vlan vlanNumber : vlans) {
//                    if (!vlanNumbers.contains(vlanNumber.getNum())) {
//                        vlanNumbers.add(vlanNumber.getNum());
//                    }
//                }
//                this.allowedVlans = vlanNumbers;
//            }
            if(this.getMode().equals("trunk")) {
                for (int i = 0; i < 4095; i++) {
                    vlanNumbers.add(i);
                }
            }
            this.allowedVlans = vlanNumbers;
        } else {//指定されているものを格納する
            String[] splits = getAllowdVlanString().split(",");
            for (String string : splits) {
                if (string.matches("^[0-9]*$")) {
                    numbers.add(parseInt(string));
                } else if (string.matches("^[0-9]*-[0-9]*$")) {
                    String[] splits2 = string.split("-");
                    for (int i = parseInt(splits2[0]); i < parseInt(splits2[1]) + 1; i++) {
                        numbers.add(i);
                    }
                } else {
                    this.setAttributeErrorStatement(this.getName() + "のallowedVlanの値は無効です。正しい形式で入力してください");
                }
                for(int num : numbers){
                    if(!vlanNumbers.contains(num)){
                        vlanNumbers.add(num);
                    }
                }
                this.allowedVlans = vlanNumbers;
//                Config config = new Config();
//                config = this.getConfig();
//                if (config != null) {
//                    ArrayList<Vlan> vlans = config.getVlan();
//                    for (Vlan vlanNumber : vlans) {
//                        if (numbers.contains(vlanNumber.getNum()) && !vlanNumbers.contains(vlanNumber.getNum())) {
//                            vlanNumbers.add(vlanNumber.getNum());
//                        }
//                        if (numbers.contains(1) && !vlanNumbers.contains(1)) {
//                            vlanNumbers.add(1);
//                        }
//                        this.allowedVlans = vlanNumbers;
//                    }
//                }
            }
        }


//		Pattern listNumber = Pattern.compile("\\[(\\d+(,\\d+)*)?\\]");//数字のリスト　[12,14]
//		Matcher allowedM = listNumber.matcher(allowedVlan);
//		if(!allowedVlan.isEmpty()){
//		if(!allowedM.matches()){
//			setAttributeErrorStatement(this.getName()+"のallowedVlanの値は無効です。正しい形式で入力してください");
//		}}
//		if(allowedVlan.length()>2) {
//			String as =allowedVlan.substring(1, allowedVlan.length() - 1);
//			String[] spritVlan = as.split(",");
//			for (String s : spritVlan) {
//				if (isInt(s)) {
//					int number = Integer.parseInt(s);
//					this.allowedVlans.add(number);
//				}}
//			}
    }


    public void setIpVirtualReassembly(boolean ipVirtualReassembly) {
        this.ipVirtualReassembly = ipVirtualReassembly;
    }


    public boolean isSwitchportTrunkEncapsulation() {
        return switchportTrunkEncapsulation;
    }

    public void setSwitchportTrunkEncapsulation(boolean switchportTrunkEncapsulation) {
        this.switchportTrunkEncapsulation = switchportTrunkEncapsulation;
    }

    public EthernetSetting() {
        allowedVlans = new ArrayList<>();

    }

    public boolean getShutdown() {
        return shutdown;
    }

    public void setShutdown(boolean shutdown) {
        this.shutdown = shutdown;
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

    private int accessVlan = -1;

    private int nativeVlan = -1;

    private String mode;

    private int accessListNumber = -1;

    private String accessListName;


    private String accessListInOrOut;

    private String speed;

    private String duplex;

    private boolean ipVirtualReassembly;

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    private int stack = -1;

    private boolean switchportTrunkEncapsulation;

    private boolean shutdown;
    @JsonIgnore
    private Config config;


}
