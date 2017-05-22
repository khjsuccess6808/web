package file.upload.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageUploadServlet_bak extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		String imageDir = ctx.getRealPath("/up_images"); // /부터는 application
															// root부터 접근하는것.;

		// C:\Java\apache-tomcat-8.0.43\webapps\Fileupload\ up_images 리턴 ==>
		// /up_images의 실제 파일경로(c:\xxxx)를 리턴
		// ==> 업로드된 파일(이미지)를 저장할 디렉토리
		// System.out.println(imageDir);

		String temDir = ctx.getInitParameter("tempdir");// 업로드 된 파일을 저장할 임시 디렉토리
		// 초기파람은 Context로 부터 받아오는다.

		// 1.DiskFileItemFactory 객체를 생성- 임시저장소 정보 설정
		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 1024, new File(temDir)); // import할때
																								
		// maven저장소에 등록된거 dependency등록//강사님이 주신 것에는 이미 등록되있음.

		// 2. ServletFileUpload 객체 생성-DiskFIleItemFactory객체를 전달.
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 3.요청파라미터 조회작업
		// - 여기서부터는 try-catch블럭안으로 들어가야한다.

		try {
			List<FileItem> list = upload.parseRequest(request);// 넘어온게 파일 객체가 3개
			for (FileItem item : list) {

				String reqName = item.getFieldName();// 요청파라미터 이름 조회

				if (item.isFormField()) {// 일반 요청 파라미터(String)
					String reqValue = item.getString("UTF-8"); // 한글이 있을경우
																// "UTF-8"이라고
																// 지정해야한다.

					request.setAttribute(reqName, reqValue);
				} else {// 파일 요청파라미터(input type="file")
					String fileName = item.getName();// 업로드된 파일명 조회
					// 업로드된 파일이 있는지 체크
					if (item.getSize() != 0) { // getSize():long- 업로드된 파일의
												// 크기(byte)// null은 절대로 안넘어온다.
												// 일단 이름으로된것은 넘어오는것.
						// 1.임시경로의 파일을 최종경로로 이동
						item.write(new File(imageDir, fileName));// 매개변수로 받은 파일로
																	
						// 2.임시경로의 파일을 삭제
						item.delete();
						request.setAttribute(reqName, fileName);
					}
				}

			}//end of for문
			
			//응답처리
			request.getRequestDispatcher("/upload_result.jsp").forward(request, response);

		} catch (Exception e) {
			// 에러 처리 페이지로 이동.
			e.printStackTrace();
			throw new ServletException(e);// 예외처리를 톰켓에게 맡긴다.
		}
                 //작성한 이클립스 작업을 톰켓으로 밀어넣는다.소스를 바꾸면 webContent에있는up_image에 있는게 날라가므로 없는게 당연하다.
	}
}
