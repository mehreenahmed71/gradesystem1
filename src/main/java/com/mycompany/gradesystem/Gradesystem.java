
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gradesystem;
import java.util.ArrayList;
   class student{
      String name;
      String rollno;
      int grade;
      student(String n,String m,int l){
        this.name=n;
        this.rollno=m;
        this.grade=l;
      }
        public String info() {
            return   name + " ( " + rollno + " )   grade :" + grade;
          
        }
  }
 
    

/**
 *
 * @author PC
 */
public class Gradesystem {
ArrayList<student> students=new ArrayList<>();

   
    

     public void addstudent(String name, String rollno, int grade){
         students.add( new student(name,rollno,grade));
 }
     public double avg(){
     int sum=0;
         for(student s: students){
             sum=sum+s.grade;
         }
         return sum/students.size();
     }
     public student highest(){
    student highest = students.get(0);
         for(student s: students)
         {
             if(s.grade>highest.grade)
               highest=s;}
         return highest;
     }
     
     public student lowest(){
         student lowest=students.get(0);
         for(student s: students){
             if(s.grade<lowest.grade)
                 lowest=s;
         }
         return lowest; 
     }
     public String summary(){
         
        String report=(" ......The summary of class is..... \n");
        
         for(int i=0;i<students.size();i++){
             student s=students.get(i);
             report +=s.info() + "\n";
         }
         report +="total student" + students.size() + '\n';
         
            
             report +="Average of class is: " + avg() + "\n";
             report += "Highest grade is: " + highest().info()+ " \n";
              report +=  "Lowest grade is: " + lowest().info()+ " \n";
    return report;
         }
     

     
    
     
    public static void main(String[] args) {
 
 
        System.out.println("Hello World!");
    }
}
