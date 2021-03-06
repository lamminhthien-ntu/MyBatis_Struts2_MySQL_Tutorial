package org.apache.struts.helloworld.action;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.dispatcher.Parameter.Request;

import com.opensymphony.xwork2.ActionSupport;

import mybatis.mapper.StudentMapper;
import mybatis.mapper.entity.Student;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String 
 * result.
 * @author Bruce Phillips
 *
 */
public class HelloWorldAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<Student> listStudents;

    public List<Student> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<Student> listStudents) {
		this.listStudents = listStudents;
	}


    public String execute() throws IOException {

        // Đọc file xml để khởi tạo kết nối đến mysql server và cấu hình interface studentmapper
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // Mở Session
        SqlSession session = sqlSessionFactory.openSession();
        
     // Tạo instance cho Interface StudentMapper (Chính là file lưu trữ các code truy vấn sql bằng mybatis annotation)
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        
        // Lấy dữ liệu toàn bộ học sinh
        listStudents = studentMapper.getAll();
        
        //Gửi kết quả truy vấn đến view
        setListStudents(listStudents);
        
        // ngắt kết nối 
        session.close();
        
        return SUCCESS;
    }
}
