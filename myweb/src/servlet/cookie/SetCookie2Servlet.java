package servlet.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 변경
 *
 */
public class SetCookie2Servlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1.요청 파라미터 조회
		req.setCharacterEncoding("utf-8");

		String id = req.getParameter("id");
		String keyword = req.getParameter("keyword");

		resp.setContentType("text/html;charset=utf-8");
		// 2.id=값, keyword=값=> 쿠키로 전송 (값: 한글X)
		// 쿠키객체 생성
		// 쿠키 이름이 id인것이 있으면(웹브라우저가 전송했으면) id쿠키는 변경 하지 않는다.
		// 1.쿠키 조회
		Cookie[] cookies = req.getCookies();
		boolean flag = false;
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("id")) {
					flag = true;
					break;// 계속 비교할 필요없으므로 break; 하고 빠져나온다.
				}
			}
		}
		if(!flag){
		  Cookie c1=new Cookie("id",id);
		  resp.addCookie(c1);
		}
		Cookie cookie = new Cookie("id", id); // 문자열밖에 저장이 안되기때문에 String으로 바꿔야 // 한다.
		resp.addCookie(cookie); // 응답하는 시점에 쿠키가 넘어간다.
		Cookie cookie2 = new Cookie("keyword", keyword);
		resp.addCookie(cookie2);

		// 3. 응답: request.jsp로 이동

		RequestDispatcher rdp = req.getRequestDispatcher("/cookie/request.jsp");
		rdp.forward(req, resp);

	}
}
