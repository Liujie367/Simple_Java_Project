package com.pro3.junit;

import com.pro3.domain.Employee;
import com.pro3.service.NameListService;
import com.pro3.service.TeamException;
import org.junit.Test;

/**
 * ClassName:NameListServiceTest
 * Package:com.pro3.junit
 * Date 2023/4/25 - 21:04
 * author:Jim367
 * Description:
 */

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();

        for(int i = 0;i < employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        try {
            NameListService nameListService = new NameListService();
            int id = 3;

            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
