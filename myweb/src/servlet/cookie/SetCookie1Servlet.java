package servlet.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 쿠키값 설정
 *
 */
public class SetCookie1Servlet extends HttpServlet  {

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		
		
		//현재 실행 시점의 시간을 쿠키로 설정
		//현재 시간
		Date date=new Date();
		String currentTime=new SimpleDateFormat("HH:mm:ss").format(date); // date의 시간을 H, date의 분을 mm에, date의 초를 ss에 
		//쿠키객체 생성
		Cookie cookie=new Cookie("currentTime",currentTime);  //문자열밖에 저장이 안되기때문에 String으로 바꿔야 한다.
	     
		resp.addCookie(cookie);  //응답하는 시점에 쿠키가 넘어간다.
		//request.jsp로 이동
		RequestDispatcher rdp=req.getRequestDispatcher("/cookie/request.jsp");
		rdp.forward(req, resp);
		
		
		
	}
}
