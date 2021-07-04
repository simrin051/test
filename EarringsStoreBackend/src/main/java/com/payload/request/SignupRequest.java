package com.payload.request;
import java.math.BigInteger;

import javax.validation.constraints.*;
public class SignupRequest {
		
	
		private Long Id;
	    private String username;
		 
	    private String email;
	    
	   
	    private String password;
	    

	    private String cpassword;
	    
	    private BigInteger telephone;
	  
	    public SignupRequest( Long  Id, String username,String email,  String password,String cpassword, BigInteger telephone) {
			super();
			this.Id=Id;
			this.username = username;
			this.email = email;
			this.password = password;
			this.cpassword = cpassword;
			this.telephone = telephone;
		}

		 
	
		public Long getId() {
			return Id;
		}



		public void setId(Long id) {
			Id = id;
		}
	    
	  
	    
	    public String getCpassword() {
			return cpassword;
		}

		public void setCpassword(String cpassword) {
			this.cpassword = cpassword;
		}

		public BigInteger getTelephone() {
			return telephone;
		}

		public void setTelephone(BigInteger telephone) {
			this.telephone = telephone;
		}

		 public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String username) {
	        this.username = username;
	    }
	 
	    public String getEmail() {
	        return email;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
}
