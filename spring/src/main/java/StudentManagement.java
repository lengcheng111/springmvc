import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDAOHibernate;
import com.model.Student;

public class StudentManagement {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context.xml");
		StudentDAOHibernate studentDAO = context.getBean("studentDAOHibernate", StudentDAOHibernate.class);
		Student student = new Student("first name", "last name");
		studentDAO.save(student);
	}

}
