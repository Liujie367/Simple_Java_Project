package com.pro3.view;

import com.pro3.domain.Employee;
import com.pro3.domain.Programmer;
import com.pro3.service.NameListService;
import com.pro3.service.TeamException;
import com.pro3.service.TeamService;

/**
 * ClassName:TeamView
 * Package:com.pro3.view
 * Date 2023/4/25 - 21:06
 * author:Jim367
 * Description:
 */

public class TeamView {
    private NameListService listSvc = new NameListService();

    private TeamService teamSvc = new TeamService();

    public void enterMainMenu(){
        boolean loopFlag = true;
        char key = 0;

        do{
            if(key != '1'){
                listAllEmployees();
            }

            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4):");
            key = TSUtility.readMenuSelection();
            System.out.println();
            switch(key){
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N):");
                    char yn = TSUtility.readConfirmSelection();
                    if(yn == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }while(loopFlag);
    }

    private void deleteMember() {
        System.out.println("\n----------删除成员----------\n");
        System.out.print("请输入需要删除的员工TID:");
        int id = TSUtility.readInt();
        System.out.print("请确认是否删除(Y/N):");
        char yn = TSUtility.readConfirmSelection();

        if(yn == 'N'){
            return;
        }


        try {
            teamSvc.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException teamException) {
            System.out.println("添加失败 原因：" + teamException.getMessage());
        }

        //按回车键继续
        TSUtility.readReturn();

    }

    private void addMember() {
        System.out.println("\n----------添加成员----------\n");
        System.out.print("请输入需要添加的员工ID:");
        int id = TSUtility.readInt();

        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException teamException) {
            System.out.println("添加失败 原因：" + teamException.getMessage());
        }

        //按回车键继续
        TSUtility.readReturn();
    }


    /**
     * 显示开发团队成员列表
     */
    private void listTeam() {
        System.out.println("\n----------团队成员列表----------\n");
        Programmer[] team = teamSvc.getTeam();

        if(team.length == 0){
            System.out.println("开发团队目前没有成员");
        }else{
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        }

        for(int i = 0;i < team.length;i++){
            System.out.println(" " + team[i].getDetailsForTeam());
        }

        System.out.println("------------------------------");
    }

    /**
     * 显示所有的员工
     */
    private void listAllEmployees() {
        System.out.println("\n----------优尚开发团队调度系统----------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if(employees.length == 0){
            System.out.println("没有客户记录");
        }else{
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        }

        for(int i = 0;i < employees.length;i++){
            System.out.println(" " + employees[i]);
        }

        System.out.println("------------------------------");

    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
