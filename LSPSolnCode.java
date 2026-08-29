package HLD;
import java.util.List;
import java.util.ArrayList;
public class LSPSolnCode {
    //
}

class Vehicle{
    public Integer getnumberofwheels(){
        return 2;
    }
}

class bicycle extends Vehicle{

}
class EngineVehicle extends Vehicle {
    public Boolean hasengine(){
        return true ;
    }
}

class motorcycle extends EngineVehicle{

}
class car extends EngineVehicle{
    public Integer getnumberofwheels(){
        return 4;
    }
}


class solndemo{
    
    public static void main(String[] args){
    List<Vehicle> vehicleList =new ArrayList<>();
    vehicleList.add(new motorcycle());
    vehicleList.add(new car());
    vehicleList.add(new bicycle());
    for(Vehicle vehicle : vehicleList){
        System.out.println(vehicle.getnumberofwheels().toString()); 
    
    }
    List<EngineVehicle> vehicleList2 =new ArrayList<>();
    vehicleList2.add(new car());
    vehicleList2.add(new motorcycle());
    //vehicleList2.add(new Bicycle());//cannot add bicycle
    
}
}


