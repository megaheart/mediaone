package com.shopkeeper.lam.models;

public enum jobOfPerson {
   SINGER("singer",1),ACTOR("actor",2);

   private String name;
   private int number;
   jobOfPerson(String name,int number){
      this.name=name;
      this.number=number;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }
}
