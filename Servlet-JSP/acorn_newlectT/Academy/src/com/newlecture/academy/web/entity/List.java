package com.newlecture.academy.web.entity;

import java.util.Date;

public class List {
   private int id;
   private String title;
   private Date regDate;
   private String regMemberId;
   
   public List() {
      // TODO Auto-generated constructor stub
   }

   public List(int id, String title, Date regDate, String regMemberId) {
      super();
      this.id = id;
      this.title = title;
      this.regDate = regDate;
      this.regMemberId = regMemberId;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Date getRegDate() {
      return regDate;
   }

   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }

   public String getRegMemberId() {
      return regMemberId;
   }

   public void setRegMemberId(String regMemberId) {
      this.regMemberId = regMemberId;
   }

   @Override
   public String toString() {
      return "List [id=" + id + ", title=" + title + ", regDate=" + regDate + ", regMemberId=" + regMemberId + "]";
   }
   
   
}