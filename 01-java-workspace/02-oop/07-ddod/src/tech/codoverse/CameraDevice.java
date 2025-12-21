package tech.codoverse;

public interface CameraDevice extends SmartDevice {

    @Override
    default void unlock() {
        IO.println("Camera device unlocks.");
    }

}
