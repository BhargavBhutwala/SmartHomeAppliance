public class Fan implements Appliance{

    public int speed;

    @Override
    public void turnOn() {
        speed = 1;
        System.out.println("Fan is turned on");
    }

    @Override
    public void turnOff() {
        speed = 0;
        System.out.println("Fan is turned off");
    }

}
