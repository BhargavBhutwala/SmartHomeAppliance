public class AirConditioner implements Appliance{

    public String mode;

    @Override
    public void turnOn() {
        mode = "cool";
        System.out.println("AirConditioner is turned on");
    }

    @Override
    public void turnOff() {
        mode = "off";
        System.out.println("AirConditioner is turned off");
    }

}
