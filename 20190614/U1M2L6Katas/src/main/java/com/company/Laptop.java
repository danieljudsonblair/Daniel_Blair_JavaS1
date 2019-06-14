package com.company;

public class Laptop {
    private Processor processor;
    private Memory hardDrive;
    private Memory ram;
    private Screen screen;
    private Odd externalHD;

    public Laptop() {
    }

    public boolean startup(boolean x) {
        return x;
    }

    public boolean shutdown(boolean x) {
        return x;
    }

    public boolean hibernate(boolean x) {
        return x;
    }

    public int adjustVolume(int x) {
        return x;
    }

    public int adjustBrightness(int x) {
        return x;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(Memory hardDrive) {
        this.hardDrive = hardDrive;
    }

    public Memory getRam() {
        return ram;
    }

    public void setRam(Memory ram) {
        this.ram = ram;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Odd getExternalHD() {
        return externalHD;
    }

    public void setExternalHD(Odd externalHD) {
        this.externalHD = externalHD;
    }
}
