package ex01.basic.entity;

import java.util.Date;

//데이터를 담을 수 있음
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String birthday;
	private String phone;
	private String email;
	private Date regdate;
	
	public Member() {
		
	}

	public Member(String id, String pwd, String name, String gender, String birthday, String phone, String email,
			Date regdate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", phone=" + phone + ", email=" + email + ", regdate=" + regdate + "]";
	}
	
	
}
