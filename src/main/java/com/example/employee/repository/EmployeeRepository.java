package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //以下所有的*都代表变量

    //1.查询名字是*的第一个employee
    @Query(value = "select e from Employee e where e.name=:name")
    public Page<Employee> findEmployeeByName(@Param("name") String name, Pageable pageable);
    //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息
    @Query(value = "select e from Employee e where e.name like CONCAT('%',:name,'%') and e.salary > :salary")
    public Page<Employee> findEmployeeByCharacterAndSalary(@Param("name") String name,@Param("salary") int salary,Pageable pageable);
    //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名

    //4.实现对Employee的分页查询，每页两个数据

    //5.查找**的所在的公司的公司名称

    //6.将*的名字改成*,输出这次修改影响的行数

    //7.删除姓名是*的employee
}
