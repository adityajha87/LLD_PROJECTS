package HLD;
import java.util.List;
import java.util.ArrayList;
public class LSPErrorCode {
    //
}


class Vehicle{
    public Integer getnumberofwheels(){
        return 4;
    }
    public Boolean hasengine(){
        return true;
    }
}

class motorcycle extends Vehicle{
    public String getspecifications() {
        return "motorcycle has " + this.getnumberofwheels() + "wheels and has engine :"
        + this.hasengine();
    }
}

class car extends Vehicle{
     public Integer getnumberofwheels(){
        return 4;
    }
    public String getspecifications() {
        return "motorcycle has " + this.getnumberofwheels() + "wheels and has engine :"
        + this.hasengine();
    }

}

class bicycle extends Vehicle {
    public Boolean hasengine(){
        return null;
    }
}

// usage example - violation of liskov substitution principle 

class demo{
    // add bicycle - violation of LSP 
    public static void main(String[] args){
    List<Vehicle> vehicleList =new ArrayList<>();
    vehicleList.add(new motorcycle());
    vehicleList.add(new car());
    vehicleList.add(new bicycle());
    for(Vehicle vehicle : vehicleList){
        System.out.println(vehicle.hasengine().toString()); // throws NPE
        // client code will break for bicycle 
    }
}
}


