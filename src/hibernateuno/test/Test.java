package hibernateuno.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import hibernateuno.domain.Libro;
import hibernateuno.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		
		Libro libro = new Libro("Aventuras de Sherlock Holmes", "Arthur Conan Doyle", "Porrúa", new Timestamp(date.getTime()));
		
		System.out.println(libro);
		session.save(libro);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
