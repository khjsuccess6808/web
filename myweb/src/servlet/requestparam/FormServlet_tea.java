package servlet.requestparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet_tea extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
         doPost(request,response);
	}	//원래는 이런경우에는 doPost로 하는것이 정상이다. 그러나 URL로 들어와서 get방식으로 들어와서 Post와 처리방식이 같을떄는 함수만 부른다.
	
	//POST 요청 처리 메소드.
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
																	throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//요청파라미터들 조회
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String acceptMail = request.getParameter("acceptMail");
		String [] langs = request.getParameterValues("language");//다중선택
		String command = request.getParameter("command");
		String tel1 = request.getParameter("tel1");
		String category = request.getParameter("category");
		String intro = request.getParameter("intro");
		//null 값이 넘어올때는 아예 값이 없을때,
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		out.print("<!doctype html>");
		out.println("<html><body>");
		out.println("<h1>등록하신 정보입니다.</h1>");
		
		out.printf("이름 : %s<br>", name);
		if(name.trim().isEmpty()){
			out.print("이름이 입력되지 않았습니다.<br>");
		}else{
			out.printf("이름:%s<br>",name);
		}
		//패스워드는 6글자 이상이어야한다.
		if(password.length()<6){
			out.print("패스워드는 6글자이상 입력해야한다.");
		}else{
			out.printf("패스워드:%s<br>",password);
		}
		out.printf("패스워드 : %s<br>", password);
		out.printf("주소 : %s<br>", address);
		out.printf("성별 : %s<br>", gender);
		out.printf("메일 수신 여부 : %s<br>", acceptMail==null?"수신안함":"수신함");
		out.print("관심 언어<ul>");
		if(langs!=null){
			out.print("<ul>");
		for(String lang : langs){
			out.printf("<li>%s</li>", lang);
		}
		}else{
			out.print("<br>관심언어가 없습니다.<br>");
		}
		out.print("</ul>");
		out.printf("hidden값 - command : %s<br>", command);
		out.printf("핸드폰 번호 앞자리 : %s<br>", tel1);
		out.printf("선택 카테고리 : %s<br>", category);
		out.printf("자기소개<br>%s", intro);
		out.println("</body></html>");
	}
}







