import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SmartHomeController {

    private List<Appliance> appliances;

    public SmartHomeController(){
        appliances = new ArrayList<>();
    }

    public void addAppliance(Appliance appliance){
        appliances.add(appliance);
    }

    public void turnOffAllAppliances(){
        for(Appliance appliance : appliances){
            appliance.turnOff();
        }
        System.out.println("All Appliances have been turned off");
    }

    public void scheduleSystemUpdate(){
        ScheduledExecutorService service  = Executors.newScheduledThreadPool(1);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextUpdate = LocalDateTime.of(now.getYear(), Month.JANUARY, 1, 1 , 0, 0);

        if(now.isAfter(nextUpdate)){
            nextUpdate = nextUpdate.plusYears(1);
        }

        long initialDelay = java.time.Duration.between(now, nextUpdate).getSeconds();
        long period = TimeUnit.DAYS.toSeconds(365);

        service.scheduleAtFixedRate(this::turnOffAllAppliances, initialDelay, period, TimeUnit.SECONDS);
        System.out.println("System update scheduled for " + nextUpdate);
    }
}
