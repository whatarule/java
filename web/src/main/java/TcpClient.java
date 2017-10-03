
import java.io.*;
import java.net.*;

public class TcpClient {
  public static void main(String [] args) throws Exception {
    try(
      Socket socket = new Socket("localhost", 8000);
      FileInputStream fis = new FileInputStream("txt/client_send.txt");
      FileOutputStream fos = new FileOutputStream("txt/client_recv.txt");
    ) {
      int ch;
      OutputStream output = socket.getOutputStream();
      while ((ch = fis.read()) != -1) {
        output.write(ch);
      }
      output.write(0);

      InputStream input = socket.getInputStream();
      while ((ch = input.read()) != -1) {
        fos.write(ch);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
