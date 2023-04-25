package com.pro3.service;

import com.pro3.domain.Architect;
import com.pro3.domain.Designer;
import com.pro3.domain.Employee;
import com.pro3.domain.Programmer;

/**
 * ClassName:TeamService
 * Package:com.pro3.service
 * Date 2023/4/25 - 21:00
 * author:Jim367
 * Description:关于开发团队成员的管理 添加 删除等
 */

public class TeamService {
    //给memberId进行自动赋值的计数
    private static int counter = 1;
    //开发团队最大的成员数
    private final static int MAX_MEMBER = 5;
    //创建开发团队的数组
    private Programmer[] team = new Programmer[MAX_MEMBER];
    //记录开发团队的人数
    private int total;

    /**
     * 返回当前团队的所有对象
     * @return 包含所有成员对象的数组 数组大小与成员人数一致
     */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i = 0;i < total;i++){
            team[i] = this.team[i];
        }

        return team;
    }


    /**
     * 向团队中添加成员
     * @param e 待添加的对象
     * @throws TeamException 添加失败 TeamException 中包含失败原因
     */
    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满 无法添加");
        }

        //该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员 无法添加");
        }

        Programmer p = (Programmer) e;
        Status status = p.getStatus();
        switch (status) {
            case BUSY:
                //该员工已是某团队成员
                throw new TeamException("该员工已是某员工团队");
            case VOCATION:
                //该员工正在休假，无法添加
                throw new TeamException("该员工正在休假 无法添加");
        }

        //该员工已在本开发团队中
        boolean isExist = isExist(p);
        if (isExist) {
            throw new TeamException("该员工已在本开发团队中");
        }

        //团队中至多只能有一名架构师
        //团队中至多只能有两名设计师
        //团队中至多只能有三名程序员
        int proNum = 0, desNum = 0, arcNum = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                arcNum++;
            } else if (team[i] instanceof Designer) {
                desNum++;
            } else {
                proNum++;
            }
        }

        if (p instanceof Architect) {
            if (arcNum >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (desNum >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else {
            if (proNum >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }


        // 当前位置 p可以正常添加
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
        team[total++] = p;

    }

    /**
     * 判断p是否存在于当前的团队中
     * @param p 员工信息
     * @return true 已存在于当前团队 false 不存在
     */
    private boolean isExist(Programmer p){
        for(int i = 0;i < total;i++){
            if(p.getId() == team[i].getId()){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param memberId 待删除员工的memberID
     * @throws TeamException 找不到指定memberId的员工 删除失败
     */
    public void removeMember(int memberId) throws TeamException{
        int i = 0;
        for(;i < total;i++){
            if(team[i].getMemberId() == memberId){
                //找到这个员工 需要调整相关状态
                team[i].setStatus(Status.FREE);
                //员工的 memberId 可以不进行修改
                break;
            }
        }

        //没找到这个memberId
        if(i == total){
            throw  new TeamException("找不到指定memberId的员工 删除失败");
        }

        //调整数组
        for(int j = i;j < total - 1;j++){
            team[j] = team[j+1];
        }

        team[--total] = null;

    }
}
