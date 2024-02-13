package com.jobhub.model;

import com.jobhub.controller.ExecutorController;

public class Executor {
   private String name;
   private String lastname;
   private int experience;
   private double rating;

   public Executor(String name, String lastname, int experience){

   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
