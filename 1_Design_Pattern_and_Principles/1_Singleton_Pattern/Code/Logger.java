
public class Logger {
    private static Logger instance;
    private Logger() {
        System.out.println("Logger is initialized."); //Even if we create multiple objects , we get to see this message only once 
    }

    public static Logger stInstance() {
        if (instance == null) {
            instance = new Logger(); 
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message +": "+ System.identityHashCode(this));
    }
}

class Main {
    public static void main(String[] args) {
        Logger l1 = Logger.stInstance();
        Logger l2 = Logger.stInstance();
        Logger l3 = Logger.stInstance();

        l1.log("Logging from l1");
        l2.log("Logging from l2");          
        l3.log("Logging from l3");
        
        System.out.println("Are all logger instances same? " + (l1 == l2 && l2 == l3));
    }

    
}

