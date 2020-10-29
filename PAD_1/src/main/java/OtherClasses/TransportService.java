package OtherClasses;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.*;


public class TransportService implements IOperation{
    Socket transport;
    public TransportService(Socket transport) {
        this.transport = transport;
    }
    @Override
    public String readAsync() {
        ExecutorService executor = Executors.newSingleThreadExecutor(); //  Thread Executor
        Callable<String> task = () -> {
            InputStream istream = null;
            String partlyTransData;
            StringBuffer result = new StringBuffer();
            try {
                istream = transport.getInputStream();
                BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
                if (!(partlyTransData = receiveRead.readLine()).isEmpty())
                    result.append(partlyTransData.trim());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result.toString();
        };
        Future<String> future = executor.submit(task);
        String message="";
        while(!future.isDone());
        try{
            message=future.get();
        } catch (InterruptedException ie) {
            ie.printStackTrace(System.err);
        } catch (ExecutionException ee) {
            ee.printStackTrace(System.err);
        }
        executor.shutdown();
        return message;
    }
    @Override
    public void writeAsync(String message) {
        Thread thread =new Thread(() -> {
            OutputStream ostream = null;
            try {
                ostream = transport.getOutputStream();
                PrintWriter pwrite = new PrintWriter(ostream, true);
                pwrite.println(message);    // sending to server
                pwrite.flush();             // flush the data
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}

