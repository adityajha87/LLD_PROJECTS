package HLD;

public class Strategypattern {
    //
}
    // SHOPPING CART PAYMENT METHODS
    // without strategy design 
class paymentprocessor{
    public void processpayment(String type, double amount) {
        switch(type) {
            case " credit card"->{
                // x lines of credit card logic 
                System.out.println("paid $"+amount +"using credit card");
            }
             case " paypal"->{
                // x lines of paypal logic 
                System.out.println("paid $"+amount +"using paypal");
            }
              case " bank transfer"->{
                // x lines of bank transfer logic 
                System.out.println("paid $"+amount +"using bank transfer");
            }
            default -> throw new IllegalStateException("unexpected value" +type);

        }
        // add new payment method means to modify the class 
        // this keeps growing with each new payment methods
        // bad design
    }
}

class demo{
    public static void main(String[] args){
        System.out.println("payment processor : problem demo");
        paymentprocessor processor  =new paymentprocessor();
        processor.processpayment("creditcard",100);
        processor.processpayment("paypal",100);
        processor.processpayment("banktransfer",100);
        

    }
}


// with strategy design pattern 

// strategy interface 
interface paymentstrategy{
    void pay(double amount);
}

// concrete strategy- for credit card payment 
class creditcardpayment implements paymentstrategy{
    private String cardnumber;

    public creditcardpayment(String cardnumber){
        this.cardnumber =cardnumber;
    }

    public void pay(double amount){
        System.out.println("pais $" + amount + "using creditcard");
    }


}

// concrete strategy- for paypal payment 
class paypalpayment implements paymentstrategy{
    private String upicode;

    public paypalpayment(String upicode){
        this.upicode =upicode;
    }

    public void pay(double amount){
        System.out.println("pais $" + amount + "using paypal");
    }


}

// concrete strategy- for banktransfer payment 
class banktransfer implements paymentstrategy{
    private String accountno;

    public banktransfer(String accountno){
        this.accountno =accountno;
    }

    public void pay(double amount){
        System.out.println("pais $" + amount + "using bank transfer");
    }


}

// context class - holds reference to a strategy object
class shoppingcart{
    private paymentstrategy payment_strategy;

    public void setpaymentstrategy(paymentstrategy strategy){
        this.payment_strategy=strategy;
    }

    public void checkout(double amount){
        System.out.println(this.payment_strategy.getClass().getSimpleName() + "");
        payment_strategy.pay(amount);
    }


}

// client code to simulate payment processing 

class corrdemo{
    public static void main(String args[]){

        shoppingcart cart = new shoppingcart();

       // CREATE A SHOPPING CART AND SET PAYMENT STRATEGY
         cart.setpaymentstrategy(new creditcardpayment("1234-4567"));

         //CHOOSE PAYMENT BEHAVIOR AT RUNTIME 
        cart.checkout(100);

         cart.setpaymentstrategy(new paypalpayment("129"));

        cart.checkout(120);

         cart.setpaymentstrategy(new banktransfer("A321"));

        cart.checkout(100);

        // adding another payment method is as simple as adding a new strategy class

        // no need to modify existing design 
    }
}
