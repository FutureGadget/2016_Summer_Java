package controller.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.book.BookEntity;
import service.book.BookService;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF8"); // 응답 인코딩 UTF8로 변경, Mysql DB에 들어있는 책 정보가 UTF8을 쓰므로 DB에서 불러온 데이터도 UTF8로 디코딩해줘야 한다.
		String[] isbns = (String[])request.getParameterValues("check");// 체크박스의 name 어트리뷰트가 check
		BookService service = new BookService();
		ArrayList<BookEntity> queryResult = service.getBookListByISBNs(isbns);
		HttpSession session = request.getSession(true);
		session.setAttribute("CART", queryResult);
		response.sendRedirect("CartOk.html");
	}

}
