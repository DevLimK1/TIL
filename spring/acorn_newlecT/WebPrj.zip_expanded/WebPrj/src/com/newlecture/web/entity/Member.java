package com.newlecture.web.entity;

import java.util.Date;

public class Member {
   private int id;
   private String uid;
   private String name;
   private String pwd;
   private Date regDate;
   private String gender;
   private String birthday;
   private String phone;
   private String email;
   private int age;

   public Member() {
      // TODO Auto-generated constructor stub
   }

   public Member(int id, String uid, String name, String pwd, Date regDate, String gender, String birthday, String phone,
         String email, int age) {
      this.id = id;
      this.uid = uid;
      this.name = name;
      this.pwd = pwd;
      this.regDate = regDate;
      this.gender = gender;
      this.birthday = birthday;
      this.phone = phone;
      this.email = email;
      this.age = age;
   }
   
   public Member(String uid, String name, String pwd, String gender, String birthday, String phone,
         String email, int age) {      
      this.uid = uid;
      this.name = name;
      this.pwd = pwd;
      this.gender = gender;
      this.birthday = birthday;
      this.phone = phone;
      this.email = email;
      this.age = age;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUid() {
      return uid;
   }

   public void setUid(String uid) {
      this.uid = uid;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPwd() {
      return pwd;
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   public Date getRegDate() {
      return regDate;
   }

   public void setRegDate(Date regDate) {
      this.regDate = regDate;
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

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   @Override
   public String toString() {
      return "Member [id=" + id + ", uid=" + uid + ", name=" + name + ", pwd=" + pwd + ", regDate=" + regDate
            + ", birthday=" + birthday + ", phone=" + phone + ", email=" + email + ", age=" + age + "]";
   }
   
}