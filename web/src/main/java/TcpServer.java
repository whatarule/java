
import java.io.*;
import java.net.*;

public class TcpServer {
  public static void main(String [] args) throws Exception {
    try(
      ServerSocket server = new ServerSocket(8000);
      FileInputStream fis = new FileInputStream("txt/server_send.txt");
      FileOutputStream fos = new FileOutputStream("txt/server_recv.txt");
    ) {
      System.out.println("waiting...");
      Socket socket = server.accept();
      System.out.println("connected to client");

      int ch;
      InputStream input = socket.getInputStream();
      while ((ch = input.read()) != 0) {
        fos.write(ch);
      }
      OutputStream output = socket.getOutputStream();
      while ((ch = fis.read()) != -1) {
        output.write(ch);
      }
      socket.close();

      System.out.println("completed");

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
