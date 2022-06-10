package ecart.core.service;

public class LoginService {
	public boolean login(String uname,String password){
		boolean isSuccess=false;
		if(uname.equals("Barkat") && password.equals("123")){
			isSuccess=true;
		}
		return isSuccess;
	}
}
