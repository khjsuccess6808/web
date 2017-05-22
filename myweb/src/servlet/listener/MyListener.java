package servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application이 시작할 때 할 일을 구현할 메소드와 종료할때 할일을 구현할 Event listener 클래스
 * Application 시작/종료시 발생하는 Event: ServletContextEvent
 * 
 * 1. ServletContextListener 인터페이스를 implements ( ServletContextEvent 의 handler메소드를 선언한 Listener Interface)
 * 
 * 2. handler 메소드 Overriding
 * 
 * 3. web.xml에 등록 => Web Container에 등록
 */
public class MyListener implements ServletContextListener {

	
	
	//실행환경(xxxLister)은 event가 발생할떄 메소드를 부를건데 , 구조가 일정해야 하므로 interface를 만든다.
	
	/**
	 * Application이 시작되고 호출 되는 event handler메소드.
	 * 
	 */
	//서블릿context객체는 application이 생성될때 생성 그리고 소멸될때 소멸. servletcontext객체에 공유자원들을 넣는다
	//원래는 상위클래스에서 getservletcontext해서 받아왔지만 여기서는 못함. 그래서 매개변수로 ServletContextEvent를 이용하여 event발생정보를 얻어온다.
	//그에 속성으로 발생한 이벤트의 여러 속성들을 넣어놓는다. 
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
	   //ServletContextEvent로부터 ServletContext객체 조회
		ServletContext context= event.getServletContext();
		//공유자원 객체를 생성.
	   String resource="공유데이터";//여러 web component(servlet/jsp)들이 사용하는 자원(공통자원)//시작할때 공유할작업을 넣는작업들을 한다.
	   //ServletContext의 Attribute 저장소에 resource를 속성으로 binding(등록) 
	   context.setAttribute("resource", resource);//속성 저장 (앞에서도 속성저장할떄도 set메서드 쓰면된다. 단지여기서는 저장소가 servletContext로 변한것뿐
	   
	   System.out.println("MyListener.contextInitialized() 실행");	
	}
	/**
	 * Application이 종료되고 호출되는 event handler메소드.
	 */                                    
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//서버 종료(stop)누르면 아까 등록해놓았기에 알아서 처리해줌.
		System.out.println("MyListener.contextDestroyed() 실행");
	}

	

    
	
}
