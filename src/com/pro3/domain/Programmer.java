package com.pro3.domain;

import com.pro3.service.Status;
/**
 * ClassName:Programmer
 * Package:com.pro3.domain
 * Date 2023/4/25 - 20:43
 * author:Jim367
 * Description:
 */

public class Programmer extends Employee{

    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription() ;
    }


    public String getBasicDetailsForTeam(){
        return memberId + "\t" + getId() + "\t" + getName() + "\t"
                + getAge() + "\t" + getSalary() + "\t";
    }

    public String getDetailsForTeam(){
        return getBasicDetailsForTeam() + "程序员";
    }


}
