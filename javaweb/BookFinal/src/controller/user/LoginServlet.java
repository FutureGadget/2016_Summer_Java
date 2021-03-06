package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.user.UserEntity;
import service.user.UserService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// 1.한글처리
		// post 방식인 경우에만 사용할 수 있어요!
		request.setCharacterEncoding("UTF8");
		// 2. 사용자로부터 넘어온 데이터를 받아요
		String id = request.getParameter("inputId");
		String pw = request.getParameter("inputPassword");
		// 3. 로직처리
		UserService service = new UserService();
		// user 에 대한 Entity를 만들어서 인자로 이용.
		UserEntity entity = new UserEntity();
		entity.setUid(id);
		entity.setUpw(pw);
		boolean result = service.login(entity);
		// 4. 결과 처리 (View 처리)
		RequestDispatcher rd = request.getRequestDispatcher("loginResult.jsp");
		if (result) {
			// 로그인에 성공했으니까 해당 클라이어트에게 session 객체를 할당해요.
			HttpSession session = request.getSession(true);
			// 만약 이전에 사용하던 세션 객체가 존재하면 만들지 말고 그거 들고와.
			session.setAttribute("USERID",  id);
			
			request.setAttribute("MSG", id+" 님 환영합니다!");
			request.setAttribute("flag", true); // 로그인 성공시의 flag 값을 넘겨줌으로써 JSP 뷰에서 로그인 성공시의 처리를 용이하게 함
			rd.forward(request, response);
		} else {
			request.setAttribute("MSG", "<p>로그인에 실패했습니다.</p><p>다시 로그인해주세요.</p>");
			request.setAttribute("flag", false);
			rd.forward(request, response);
		}
	}

}
