
import java.io.Serializable;

import javax.inject.Named;

import com.stids.consciente.models.Policies;

import DataBase.TestDriverMySQL;

import javax.faces.view.ViewScoped;

@Named("helloworld")
@ViewScoped
public class HelloWorldBean implements Serializable {
	
	
	private String companySec;
	private String policy;
	private TestDriverMySQL connect;
	
	

  


   
   public String getCompanySec() {
		return companySec;
	}







	public void setCompanySec(String companySec) {
		this.companySec = companySec;
	}







	public String getPolicy() {
		return policy;
	}







	public void setPolicy(String policy) {
		this.policy = policy;
	}







public void buttonAction() {
	   System.out.println("presionando botton");
	   connect.main(null);
   }





}
