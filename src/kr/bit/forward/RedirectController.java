package kr.bit.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardController
 */
@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = "lee";
		int age = 45;
		String email = "dho0647@naver.com";
		
		// View page(result.jsp)로 data 전달하여 View page에서 출력
		// Controller에서 View로 페이지를 전환하는 방법
		
		// 1. redirect
		// 요청을 서버가 view/result.jsp로 돌려버려 클라이언트가 다시 result.jsp 요청 -> jsp가 응답
		// sendRedirect는 요청을 끊어버리고, 새로운 요청을 하기 때문에 클라이언트는 서버와 처음부터 새롭게 연결되기 때문에 기존의 Servlet request는 연결이 끊어지고 새로운 request가 만들어진다. -> 값 공유가 불가능
		// 값을 넘길때 쿼리스트링 사용
		// 단점: 여러개의 정보를 넘길때 어렵다.
		response.sendRedirect("view/result.jsp?name="+name+"&age="+age+"&email="+email);
	}

}
