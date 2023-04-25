package com.pro1;

/**
 * ClassName:GuLiAccount
 * Package:com.pro1
 * Date 2023/4/25 - 11:41
 * author:Jim367
 * Description:项目一 谷粒记账软件
 */

public class GuLiAccount {
    public static void main(String[] args) {

        //循环控制变量
        boolean isFlag = true;
        //初始金额
        int balance = 10000;
        //收支说明
        String info = "";

        while (isFlag) {
            System.out.println("-------------谷粒记账软件-------------\n");
            System.out.println("             1  收支明细 ");
            System.out.println("             2  登记收入 ");
            System.out.println("             3  登记支出 ");
            System.out.println("             4  退出 \n");
            System.out.print("             请选择(1-4):");


            char c = Utility.readMenuSelection();//获取用户输入

            switch (c) {
                case '1':
                    //System.out.println("收支明细");
                    System.out.println("-------------当前收支明细-------------");
                    System.out.println("收支\t账户金额\t收支金额\t说明\t");
                    System.out.println(info);
                    System.out.println("-------------------------------------");

                    break;
                case '2':
                    //System.out.println("登记收入");
                    System.out.print("本次收支金额：");
                    int income = Utility.readNumber();
                    if(income > 0) {
                        balance += income;
                    }

                    System.out.print("本次收支说明：");
                    String addDesc = Utility.readString();
                    info += "收入\t" + balance + "\t\t" + income + "\t\t\t" + addDesc + "\n";
                    System.out.println("-------------登记完成-------------");

                    break;
                case '3':
                    //System.out.println("登记支出");
                    System.out.print("本次支出金额：");
                    int expenditure = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String minusDesc = Utility.readString();

                    if(expenditure > 0 && expenditure <= balance){
                        balance -= expenditure;
                    }
                    info += "支出\t" + balance + "\t\t" + expenditure + "\t\t\t" + minusDesc + "\n";
                    System.out.println("-------------登记完成-------------");


                    break;
                case '4':
                    System.out.print("\n确认是否退出(Y/N):");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        }

    }
}
