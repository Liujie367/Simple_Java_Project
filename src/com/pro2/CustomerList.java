package com.pro2;

/**
 * @author Jim367
 * @date 2023/4/14 - 14:54
 * CustomerList为Customer对象的管理模块 内部使用数组管理一组Customer对象
 */
public class CustomerList {

    private Customer[] customers;//用来保存客户对象的数组
    private int total;//记录已保存客户对象的数量

    /**
     * 构造器 初始化customers 数组
     * @param totalCustomer 指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 将参数customer添加到数组中记录的最后一个客户对象之后
     * @param customer 待添加的客户对象
     * @return true表示添加成功 false表示数组已满 添加失败
     */
    public boolean addCustomer(Customer customer){
        if(total < customers.length){
            customers[total] = customer;
            total++;
            return true;
        }

        return false;
    }

    /**
     * 用参数cust替换数组中下标index指定的对象
     * @param index 指定所替换对象在数组中的位置 从0开始
     * @param cust 指定替换的新客户对象
     * @return true 替换成功 false 索引无效 替换失败
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index >= 0 && index < total){
            customers[index] = cust;
            return true;
        }

        return false;
    }

    /**
     * 从数组中删除参数index指定索引位置的客户对象记录
     * @param index 指定所删除对象在数组中的索引位置 从0开始
     * @return true 表示删除成功 false 索引无效 无法删除
     */
    public boolean deleteCustomer(int index){
        if(index >= 0 && index < total){
            //循环删除
            //因为 total当前索引指向下一个客户添加的位置
            for(int i = index; i < total - 1; i++){
                customers[i] = customers[i+1];
            }

            customers[total - 1] = null;
            total--;

            return true;
        }

        return false;
    }

    /**
     * 返回数组中记录的所有客户对象
     * @return 数组中包含所有客户对象 长度与客户对象个数相同
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for(int i = 0;i < total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 返回参数index指定索引位置的客户对象记录
     * @param index 指定所有获取的客户在数组中的索引位置 从0开始
     * @return 封装客户信息的Customer对象
     */
    public Customer getCustomer(int index){
        Customer cust = null;
        if(index >= 0 && index < total){
            cust = customers[index];
        }
        return cust;
    }

    /**
     * 获取客户列表中的客户的数量
     * @return total
     */
    public int getTotal(){
        return total;
    }
}
