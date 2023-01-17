package kr.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8081/MVC01/memberDelete.do?num=1 -> num=1은 요청정보
		
		// 1. 클라이언트의 요청정보 받기
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 2. 회원 삭제
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);
		if (cnt > 0) {
			response.sendRedirect("/MVC03/memberList.do");
		} else {
			throw new ServletException("could not be deleted");
		}
	}
}