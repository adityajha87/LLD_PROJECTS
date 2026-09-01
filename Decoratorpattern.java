public class Decoratorpattern {
    //
}
// define component interface 
interface basepizza{
    String getdescription();
    double cost();
}
// define concrete component 
class plainpizza implements basepizza{
    public String getdescription(){
        return "plain pizza";
    }

    public double cost(){
        return 100.0;
    }
}

class farmhouse implements basepizza{
    public String getdescription(){
        return "farmhouse";
    }
    public double cost(){
        return 200.00;
    }
}

// define abstract class decorator 
    abstract class toppingdecorator implements basepizza{
        basepizza pizza;

        public toppingdecorator(basepizza pizza){
            this.pizza=pizza;
        }
    }

    // define the concrete decorator 

    class extracheesetopping extends toppingdecorator{

        public extracheesetopping(basepizza pizza){
            super(pizza);
        }

        public String getdescription(){
            return pizza.getdescription() +"+ extra cheese ";
        }

        public double cost(){
            return pizza.cost() + 20;
        }
    }

    class veggiestopping extends toppingdecorator{
         public veggiestopping(basepizza pizza){
                super(pizza);
        }

        public String getdescription(){
            return  pizza.getdescription() + "+ veggies topping";
        }

        public double cost(){
            return pizza.cost() + 30;
        }
    }

    // client demonstration
    class pizzashop{
        public static void main(String[]args){
            System.out.println("=== Decorator pattern ===");
            // create a plain pizza 
            basepizza pizza1 =new plainpizza();
            System.out.println("Order1 :" +pizza1.getdescription() + "= $" + pizza1.cost());
        }

        // add toppings to it - extra cheese only
        basepizza pizza2 = new extracheesetopping( new plainpizza());
         System.out.println("order2 :"+ pizza2.getdecription() + "=$"+pizza2.cost());

         //add toppings -cheese +veggies 
         basepizza pizza3 =new veggiestopping( new extracheesetopping (new plainpizza()));
           System.out.println("Order3 :" +pizza3.getdescription() + "= $" + pizza3.cost());
        
    }