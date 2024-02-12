import java.io.*;
import java.net.*;
import java.util.*;

class Client 
{

    Socket socket;
    BufferedReader br;
    PrintWriter out;
    public Client()
    {
         try
         {
            System.out.println("Sending request to server.");
             //socket=new Socket("169.254.115.222/16",7777);
             socket=new Socket("192.168.56.1",7777);
             System.out.println("Connection done.");

             br=new BufferedReader(new InputStreamReader(socket.getInputStream()));

             out=new PrintWriter(socket.getOutputStream());

             startReading();
             startWriting();

         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
    }

    public void startReading()
    {

        //thread will read the data;
        Runnable r1=()->{
            System.out.println("Reader started.");
            try{
            while(true)
            {
               
                String msg=br.readLine();

                if(msg.equals("exit"))
                {
                    System.out.println("Server terminated the chat");
                    socket.close();
                    break;
                }

                System.out.println("Server: "+msg);

                }
            }  
                catch(Exception e)
                {
                    //e.printStackTrace();
                    System.out.println("Connection closed.");
                }
            
        };
        new Thread(r1).start();
    }

    public void startWriting()
    {

        //thread will wright th data;
        Runnable r2=()->{
            System.out.println("Writer started..");
            
            try
            {
            while(!socket.isClosed())
            {
            
                
                    BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                    
                    String content=br1.readLine();
                    out.println(content);
                    out.flush();

                    if(content.equals("exit"))
                    {
                        socket.close();
                        break;
                    }
                }

                 //System.out.println("Connection closed.");
            }
           
        
                catch(Exception e)
                {
                    //e.printStackTrace();
                     System.out.println("Connection closed.");
                }
            

        };
        new Thread(r2).start();
    }


    public static void main(String[] args)
    {
        System.out.println("This is client..going to start client");
        new Client();
    }
}
