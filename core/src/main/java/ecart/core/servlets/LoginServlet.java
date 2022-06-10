package ecart.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import ecart.core.service.LoginService;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Login Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths="+ "/bin/formValue"
       
})


public class LoginServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUid = 1L;
	
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		java.util.logging.Logger.getLogger(getServletName()+"LoginServlet");
		
		// TODO Auto-generated method stub
		
		String uname;
		String password;
		
		try {
			uname=request.getParameter("uname");
			password=request.getParameter("pass");
			
			
			JSONObject obj=new JSONObject();
			LoginService loginService=new LoginService();
			if (loginService.login(uname, password)) {
				obj.put("status",200);
				 obj.put("uname",uname);
			   
				
			}else{
				obj.put("status",404);
			}
			
	       
	    	 String jsonData = obj.toString();
	    	 response.setCharacterEncoding("UTF-8");
	    	 response.setContentType("application/json");
	    	 
	    	//Return the JSON formatted data
	    	 response.getWriter().write(jsonData);
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		
	}

}
