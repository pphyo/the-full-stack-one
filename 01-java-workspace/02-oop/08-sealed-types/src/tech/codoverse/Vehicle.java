package tech.codoverse;

public sealed class Vehicle permits MotorCycle, Train, Car {

}

non-sealed class Train extends Vehicle {
}

final class Car extends Vehicle {
}