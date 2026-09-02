public class factorypattern {
    //
}
// define the product interface
interface shape {
    void computearea();
    void draw();
}

//concrete product classes
class square implements shape{
    public void computearea(){
        System.out.println("inside square:: computearea() method");
    }

    public void draw(){
        System.out.println("inside square :: draw() method ");
    }
}

class circle implements shape{
    public void computearea(){
        System.out.println("inside circle:: computearea() method");
    }
     public void draw(){
        System.out.println("inside circle :: draw() method ");
    }

}

// abstract creator class 
abstract class shapefactory {
    public abstract shape createshape();
}

// create creator classes
class circlecreator extends shapefactory{

    public shape getshapeinstance(){
        return new circle();
    }
}


class squarecreator extends shapefactory{

    public shape getshapeinstance(){
        return new square();
    }
}

//client code implementation

class factorymethoddemo{
    public static void main(String[] args){
        System.out.println("factory method design pattern");

        shapeType shapetype = shapetype.square ;

        shape Shape  =getshapeinstance(shapetype);

        Shape.draw();
        Shape.computearea();
    }

    private static shape getshapeinstance(shapeType shapetype){
        shape Shape = null;
        if(shapetype ==null){
            return null;
        }
        switch(shapetype){
            case circle:
                shapefactory circlecreator =new circlecreator();
                Shape =circlecreator.createshape();
                break;
            
            case square :
                shapefactory squarecreator =new squarecreator();
                Shape =squarecreator.createshape();
                break;
            
            default :
                throw new IllegalStateException("shapetype doesnt exist");

        }
        return Shape;

    }
}


