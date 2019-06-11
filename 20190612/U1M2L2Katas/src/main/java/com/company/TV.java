package com.company;

public class TV {
    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    public TV(String manufacturerIn, String modelIn, int screenSizeIn, String channelIn, int volumeIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.screenSize = screenSizeIn;
        this.channel = channelIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public void togglePower() {
        powered = !powered;
    }
}
