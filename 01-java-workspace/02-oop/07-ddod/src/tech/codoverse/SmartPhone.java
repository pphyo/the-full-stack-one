package tech.codoverse;

public class SmartPhone implements PhoneDevice, CameraDevice {

    @Override
    public void unlock() {
        CameraDevice.super.unlock();
    }

}
