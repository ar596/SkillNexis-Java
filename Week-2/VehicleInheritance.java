
class Vehicle {

    void start() {
        System.out.println("Vehicle is starting");
    }

    void stop() {
        System.out.println("Vehicle is stopping");
    }

    void displayInfo() {
        System.out.println("This is a vehicle");
    }
}


class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts using a key");
    }

    @Override
    void displayInfo() {
        System.out.println("This is a Car");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {
        System.out.println("Bike starts using a self-start button");
    }

    @Override
    void displayInfo() {
        System.out.println("This is a Bike");
    }
}


public class VehicleInheritance {

    public static void main(String[] args) {

        Car car = new Car();

        System.out.println("Car Details:");
        car.displayInfo();
        car.start();
        car.stop();

        System.out.println();

        
        Bike bike = new Bike();

        System.out.println("Bike Details:");
        bike.displayInfo();
        bike.start();
        bike.stop();
    }
}
