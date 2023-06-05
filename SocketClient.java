import java.io.*;
import java.net.Socket;

public class SocketClient {
  public static void main(String[] args) {
    String server = args[0];
    int port = Integer.parseInt(args[1]);

    try {
      Socket socket = new Socket(server, port);
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      if (args.length == 2) {
        String res = "";
        while (res != null){
          res = br.readLine();
          if (res != null) {
            System.out.println(res);
          }
        }
      } else if (args.length >= 3) {
        String echo = "";
        for (int i = 2; i < args.length; i++) {
          echo += (args[i] + " ");
        }
        System.out.println(echo);
      }
      socket.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}