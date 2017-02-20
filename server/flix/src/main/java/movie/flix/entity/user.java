package movie.flix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
@NamedQuery(name = "user.authUser", query = "SELECT u from user u  where u.userName=:puserName and u.password = :ppassword"),
@NamedQuery(name = "user.findAll", query = "SELECT u FROM user u"),
@NamedQuery(name = "user.findByEmail", query = "SELECT u FROM user u WHERE u.emailId=:pEmail")
})
public class user {

		@Id
		private String userId;
		@Column(unique=true)
		private String userName;
		private String firstName;
		private String lastName;
		private String userRole;
		private String password;
		@Column(unique=true)
		private String emailId;
		private String city;
		private String state;

		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUserRole() {
			return userRole;
		}
		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		
		public user() {
			this.userId = UUID.randomUUID().toString();
		}

		
	    @Override
	    public String toString() {
	        return "user [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userEmail=" + emailId
	                + ", userRole=" + userRole + ", firstname=" + firstName + ", lastname=" + lastName +"]";
	    }
		

}
