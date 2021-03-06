package ClientServer;

import OtherClasses.BrokerService;
import OtherClasses.IOperation;
import java.io.IOException;

public class Broker {
    public static void main(String[] args) throws IOException {
        System.out.println("Broker is starting...");
        IOperation broker=new BrokerService();
        String msg;
        while(true)
        {
            while(!(msg=broker.readAsync()).isEmpty())
                if(msg.equals("invalid"))
                {
                    System.out.println("--Broker loop--");
                    System.out.println("--INVALID MESSAGE--");
                }
                else
                {
                    System.out.println("--Broker loop--");
                    System.out.println("--VALID MESSAGE--");
                    broker.writeAsync(msg);
                }
        }
    }
}

