/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspserver;

import java.net.*; 
import java.io.*; 


public class WSPServer {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(9090);
        
        System.out.println("Server Online");
        
        while (true) {
            Socket s = null;
            
            try
            {
                // socket object to receive incoming client requests 
                s = server.accept(); 
                  
                System.out.println("A new client is connected : " + s); 
                  
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assigning new thread for this client"); 
  
                // create a new thread object 
                Thread t = new ClientHandler(s, dis, dos); 
  
                // Invoking the start() method 
                t.start();
            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
    
}


    
/*    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(9090);
        
        System.out.println("Server Online");
        
        while (true) {
                Socket client = server.accept();
                System.out.println("Client Connected");
                
                InputStreamReader in = new InputStreamReader(client.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                
                String str = bf.readLine();
                System.out.println("client: "+ str);
        }

    }
    
}
*/