public class SmartHomeAppliance {

    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner airConditioner = new AirConditioner();

        controller.addAppliance(light);
        controller.addAppliance(fan);
        controller.addAppliance(airConditioner);

        light.turnOn();
        fan.turnOn();
        airConditioner.turnOn();

        controller.scheduleSystemUpdate();
    }
}
