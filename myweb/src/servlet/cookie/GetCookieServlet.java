package servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 조회
 *
 */
public class GetCookieServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		//요청한 웹 브라우저에서 전송한 쿠키정보 조회
		
		Cookie[] cookies=req.getCookies(); //전송된 쿠키가 없으면  null
		
		String cookieValues="";
		if(cookies==null){
			cookieValues="전송된 쿠키 값이 없습니다.";
		}else{
			for(Cookie cookie:cookies){
				
				String name=cookie.getName();
				String value=cookie.getValue();
				cookieValues+=String.format("%s:%s<br>",name,value);
			}
			
		}
		
		//cookie/response.jsp 에서 응답 -> 즉 호출해야한다. ,cookieValues 전달 
		req.setAttribute("message",cookieValues);
		req.getRequestDispatcher("/cookie/response.jsp").forward(req, resp);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
