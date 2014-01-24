package myPackage;

import java.io.IOException;
import java.util.logging.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;

import myPackage.dao.ExamResultDAO;
import myPackage.entity.ExamResult;

public class ExamResultsServlet {
	private static final Logger _logger = Logger.getLogger(ExamResultsServlet.class.getName());


	public void doGet(){
		System.out.println("Hello, World");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//extract the input parameters
		String idNumber = req.getParameter("idnumber");
		_logger.info("Received a requst for id number: " + idNumber);
		try{
			if(idNumber == null) throw new Exception("Must provide id number!");
			if(!idNumber.isEmpty()){
				//retrieve the results (currently just chuck back some dummy results)
				ExamResult result = ExamResultDAO.INSTANCE.getExamResult(idNumber);
				req.getSession().setAttribute("result", result);
				resp.sendRedirect("results.jsp");
			}
			else throw new Exception("Must provide id number!");
		}
		catch (Exception e) {
			String logMsg = "Exception in processing request: " + e.getMessage();
			_logger.log(Level.INFO, logMsg);
			throw new IOException(logMsg);
		}
	}

	
	private ExamResult getDummyResult(Key idNumber){
		ExamResult toReturn = new ExamResult();
		toReturn.setIdNumber(idNumber);
		toReturn.setStudentName("Christine Julien");
		toReturn.setExam1Grade("100");
		toReturn.setExam2Grade("99");
		return toReturn;
		}
	





}
