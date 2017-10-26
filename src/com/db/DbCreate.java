/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.db;

import com.main.employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VI391762
 */
public class DbCreate {
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void create()
    {
        //Creating Db
        jdbcTemplate.execute("create table employee(eno number(6),ename varchar(20))");
        System.out.println("Table created");
    }
    public void insert(int id,String name)
    {
        //Inserting records into db
        int[] types={Types.INTEGER,Types.VARCHAR};
        Object[] params={id,name};
        
        jdbcTemplate.update("insert into employee values(?,?)",params,types);
        System.out.print("Record Inserted");
    }
        public void display()
        {
            //Display record using list
            List list=jdbcTemplate.queryForList("select * from employee");
            Iterator it=list.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
              }
        }
        public void displaymap()
        {
            //Displaying records with the help of map i.e Collection
            List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from employee");
            for(Map<String,Object> map:list)
            {
                Iterator<Map.Entry<String,Object>> i=map.entrySet().iterator();
                while(i.hasNext())
                {
                    Map.Entry<String,Object> e=i.next();
                    System.out.print(e.getKey()+":"+e.getValue()+"  ");
                }
                System.out.println();
            }
        }
        public void dispSingleRecord(int eno)
        { 
            //Displaying record with the help of external class i.e EmpRowMapper 
            employee emp=(employee)jdbcTemplate.queryForObject("select * from employee where eno=?",new Object[]{eno},new EmpRowMapper());
            System.out.println(emp.getEmpid()+" "+emp.getEname());
        }
        public void dispsinglerec(int eno)
        {
            //Displaying record with the help of internal RowMapper 
            employee emp=(employee)jdbcTemplate.queryForObject("select * from employee where eno=?",new Object[]{eno},new RowMapper<employee>()
           { 
           @Override
           public employee mapRow(ResultSet rs, int i) throws SQLException {
           employee emp=new employee();
           emp.setEmpid(rs.getInt(1));
           emp.setEname(rs.getString(2));
           return emp;
    }});
            System.out.println(emp.getEmpid()+" "+emp.getEname());
        }
        
}
class EmpRowMapper implements RowMapper{
//this class is used by dispSingleRecord i.e External Row Mapper
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
       
        employee emp=new employee();
        emp.setEmpid(rs.getInt(1));
        emp.setEname(rs.getString(2));
        return emp;
        
    }
}
