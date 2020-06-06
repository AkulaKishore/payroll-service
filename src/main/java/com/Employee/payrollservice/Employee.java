package com.Employee.payrollservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {
    private  @Id @GeneratedValue Long  id;
    private String name;
    private String Position;
    Employee(){}
    Employee(String name, String Position){
        this.name = name;
        this.Position = Position;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return Position;
    }
    public void setPosition(String position) {
        Position = position;
    }
    @Override
    public boolean equals(Object o){
        if(this ==o)
            return true;
        if(!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id,employee.id) && Objects.equals(this.name,employee.name) && Objects.equals(this.Position,employee.Position);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.id,this.name,this.Position);
    }
    @Override
    public String toString(){
        return "Employee{" +"id="+this.id+",name="+this.name+",Postion="+this.Position+"}";
    }
}
