package com.neoteric.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   private SimpleJdbcCall jdbcCall;
   
  
   /**
    * 
    */
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
      this.jdbcCall = new SimpleJdbcCall(dataSource);
   }
   

   /**
    * 
    */
   public void create(Integer id,String name, Integer age) {
      String strSql = "insert into Student (id,name, age) values (?, ?,?)";
      
      jdbcTemplateObject.update( strSql, id,name, age);
      
      System.out.println("Created Record Name = " + name + " Age = " + age);
      return;
   }

   /**
    * 
    */
   public Student getStudent(Integer id) {
      String SQL = "select * from Student where id = ?";
      Student student = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new StudentMapper());
      return student;
   }
   
   
   /*
    * /(non-Javadoc) - Proceedure Call
    * @see com.neoteric.jdbc.StudentDAO#getStudentRecord(java.lang.Integer)
    */
   public Student getStudentRecord(Integer id) {
	   
	   	  SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
	   	  Map<String,Object> out = jdbcCall.withProcedureName("GET_STUDENTS_RECORD").execute(in);
	      Student student = new Student();
	      student.setId(id);
	      student.setName((String) out.get("out_name"));
	      student.setAge((Integer) out.get("out_age"));

	      return student;
	   }

   /**
    *  Using jdbcTemplate and Row Mapper to get Student Object List
    */
   public List<Student> listStudents() {
      String SQL = "select * from Student";
      List <Student> students = jdbcTemplateObject.query(SQL, 
                                new StudentMapper());
      return students;
   }

   
   /**
    *  Implementation of Prepared Statement 
    */
   public void delete(Integer id){
      String SQL = "delete from Student where id = ?";
      // For Single Input
      jdbcTemplateObject.update(SQL, id);
      // FOr multiple Inputs
      jdbcTemplateObject.update(SQL, new Object[id]);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public void update(Integer id, Integer age,String strName){
      String SQL = "update Student set age = ? ,name = ? where id = ?";
      // For multiple Updates can send multiple parameters
      
      jdbcTemplateObject.update(SQL, age, strName, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }

}