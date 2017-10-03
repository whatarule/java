
import java.io.*;
import javax.servlet.http.*;

public class ShowBBS extends HttpServlet {

  private final String excapeHtml(String src) {
    return src
      .replace("&", "&amp;")
      .replace("<", "&lt;")
      .replace(">", "&gt;")
      .replace("\"", "&quot;")
      .replace("", "&#39;")
      ;
  }

//@Override
  public final void doGet(HttpServletResponse response)
      throws IOException {
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<div>");

    Message.messageList.forEach(
      message -> out.println(
        "<p>" + message.title + "</p>"
      )
    );

    out.println("</div>");
  }
}

