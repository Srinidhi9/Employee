package Controller;

import java.io.IOException;

import Bean.EmployeeData;
import Dao.Dao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Form submitted on GET");

        // Fetching data from request parameters
        String employeeId = request.getParameter("EmployeeId");
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String dob = request.getParameter("DOB");
        String email = request.getParameter("Email");
        String phone = request.getParameter("Phone");
        String gender = request.getParameter("Gender");
        String employeeType = request.getParameter("EmployeeType");
        String education = request.getParameter("Education");
        String skills = request.getParameter("Skills");
        String experience = request.getParameter("Experience");

        // Creating an instance of EmployeeData and setting values
        EmployeeData employee = new EmployeeData();
        employee.setEmployeeId(employeeId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDOB(dob);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setGender(gender);
        employee.setEmployeeType(employeeType);
        employee.setEducation(education);
        employee.setSkills(skills);

        // DAO object to insert data
        Dao dao = new Dao();
        int result = dao.insertDataWithpreparedStatement(employee);

        // Setting employee object in session
        HttpSession session = request.getSession();
        session.setAttribute("EmployeeObject", employee);

        // Forwarding request based on result
        RequestDispatcher success = request.getRequestDispatcher("Success.html");
        RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
        if (result > 0) {
            success.forward(request, response);
        } else {
            failure.forward(request, response);
	}
        
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("Form submitted on POST");

        // Fetching data from request parameters
        String employeeId = request.getParameter("EmployeeId");

        // Creating an instance of EmployeeData
        EmployeeData employee = new EmployeeData();
        employee.setEmployeeId(employeeId);

        // DAO object to delete data
        Dao dao = new Dao();
        int result = dao.deleteDataWithpreparedStatement(employee);

        // Forwarding request based on result
        RequestDispatcher success = request.getRequestDispatcher("Success.html");
        RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
        if (result > 0) {
            success.forward(request, response);
        } else {
            failure.forward(request, response);
        }
	}

}
