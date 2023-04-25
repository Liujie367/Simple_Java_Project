package com.pro2;

/**
 * @author Jim367
 * @date 2023/4/14 - 15:23
 * CustomerView 是主模块 负责菜单的显示和用户处理操作
 */
public class CustomerView {

    CustomerList customerList = new CustomerList(10);

    /**
     * 进入主界面
     */
    public void enterMainMenu(){

        boolean isFlag = true;

        while(isFlag){
            System.out.println("--------拼电商客户管理系统--------\n");
            System.out.println("        1 添加客户");
            System.out.println("        2 修改客户");
            System.out.println("        3 删除客户");
            System.out.println("        4 客户列表");
            System.out.println("        5 退出\n");
            System.out.print("          请选择(1-5):");

            char key = CMUtility.readMenuSelection();

            switch(key){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':

                    System.out.print("确认是否退出(Y/N):");

                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }

                    break;
            }
        }


    }

    private void addNewCustomer(){
        System.out.println("--------添加客户--------");
        System.out.print("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(15);

        Customer customer = new Customer(name,gender,age,phone,email);

        boolean flag = customerList.addCustomer(customer);

        if(flag){
            System.out.println("--------添加成功--------");
        }else{
            System.out.println("--------记录已满 无法添加--------");
        }
    }

    private void modifyCustomer(){
        System.out.println("--------修改客户--------");

        int index = 0;
        Customer customer = null;
        for(;;){
            System.out.print("请选择待修改客户的编号(-1:退出):");
            index = CMUtility.readInt();

            if(index == -1){
                return;
            }

            customer = customerList.getCustomer(index - 1);

            if(customer == null){
                System.out.println("--------无法找到指定客户--------");
            }else{
                break;
            }
        }

        //获取修改信息
        System.out.print("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(4,customer.getName());

        System.out.print("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());

        System.out.print("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());

        System.out.print("电话(" + customer.getPhone() + ")：");
        String phone = CMUtility.readString(15,customer.getPhone());

        System.out.print("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(15,customer.getEmail());

        //覆盖原始customer信息
        customer = new Customer(name,gender,age,phone,email);
        //进行替换
        boolean flag = customerList.replaceCustomer(index-1, customer);
        if(flag){
            System.out.println("--------修改完成--------");
        }else{
            System.out.println("--------无法找到指定客户 修改失败--------");
        }

    }

    private void deleteCustomer(){
        System.out.println("--------删除客户--------");

        int index = 0;
        Customer customer = null;
        //无限循环 找到待修改的客户编号
        for(;;){
            System.out.print("请选择待删除客户编号(-1:退出)：");
            index = CMUtility.readInt();

            if(index == -1){
                return;
            }
            customer = customerList.getCustomer(index - 1);

            if(customer == null){
                System.out.println("--------无法找到指定客户--------");
            }else{
                break;
            }
        }
        System.out.print("确认是否删除(Y/N):");
        char yn = CMUtility.readChar();
        if(yn == 'N'){
            return;
        }

        boolean flag = customerList.deleteCustomer(index - 1);
        if(flag){
            System.out.println("--------删除完成--------");
        }else{
            System.out.println("--------无法找到指定客户 删除失败--------");
        }


    }

    private void listAllCustomer(){
        System.out.println("--------客户列表--------");

        //获取当前客户列表
        Customer[] custs = customerList.getAllCustomers();

        if(custs.length == 0){
            System.out.println("--------没有客户记录--------");
        }else{
            System.out.println("编号" + "\t" + "姓名" + "\t" +
                    "性别" + "\t" + "年龄"+ "\t" + "电话"+ "\t\t\t" + "邮箱");
            for(int i = 0;i < custs.length;i++){
                System.out.println((i+1) + "\t\t" + custs[i].getDesc());
            }
            System.out.println("--------客户列表完成--------");
        }


    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
