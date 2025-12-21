package tech.codoverse;

public interface PhoneDevice extends SmartDevice {

    @Override
    default void unlock() {
        IO.println("Phone device unlocks.");
    }

}
