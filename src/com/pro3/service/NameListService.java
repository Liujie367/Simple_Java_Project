package com.pro3.service;

import com.pro3.domain.*;

import static com.pro3.service.Data.*;
/**
 * ClassName:NameListService
 * Package:com.pro3.service
 * Date 2023/4/25 - 21:00
 * author:Jim367
 * Description:负责将Data中的数据封装到Employee[] 数组中 同时提供相关操作Employee[]的方法
 */

public class NameListService {
    private Employee[] employees;

    public NameListService(){

        employees = new Employee[Data.EMPLOYEES.length];
        for(int i = 0;i < employees.length;i++){

            int type = Integer.parseInt(EMPLOYEES[i][0]);//员工类型

            //获取通用的属性
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;

            //根据Data类中的数据构建不同的对象 并存入数组中
            switch (type){
                case EMPLOYEE:

                    employees[i] = new Employee(id,name,age,salary);
                    break;

                case PROGRAMMER:

                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;

                case DESIGNER:

                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;

                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }

        }
    }


    private Equipment createEquipment(int index){
        int equipmentType = Integer.parseInt(EQUIPMENTS[index][0]);

        String modelOrName = EQUIPMENTS[index][1];
        String displayOrPriceOrType = EQUIPMENTS[index][2];
        switch(equipmentType){

            case PC:

                return new PC(modelOrName,displayOrPriceOrType);
            case NOTEBOOK:

                double price = Double.parseDouble(displayOrPriceOrType);
                return new NoteBook(modelOrName,price);
            case PRINTER:

                return new Printer(modelOrName,displayOrPriceOrType);

        }

        return null;
    }


    /**
     * 查找所有员工信息
     * @return
     */
    public Employee[] getAllEmployees(){
        return employees;
    }

    /**
     * 获取指定id对应的员工
     * @param id 待查找员工的id
     * @return 员工信息
     */
    public Employee getEmployee(int id) throws TeamException{

        for(int i = 0;i < employees.length;i++){
            if(id == employees[i].getId()){
                return employees[i];
            }
        }

        //如果执行到此位置 意味着没有找到此员工
        throw new TeamException("找不到指定员工");
    }
}
