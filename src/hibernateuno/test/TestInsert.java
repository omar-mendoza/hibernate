package hibernateuno.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateuno.domain.Libro;
import hibernateuno.util.HibernateUtil;

public class TestInsert {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Libro> lista = new ArrayList<Libro>();
			Date date = new Date();

			lista.add(new Libro("Aventuras de Sherlock Holmes", "Arthur Conan Doyle", "Porrúa",
					new Timestamp(date.getTime())));
			lista.add(new Libro("Nuevos triunfos de Sherlock Holmes", "Arthur Conan Doyle", "Porrúa",
					new Timestamp(date.getTime())));
			lista.add(new Libro("La fals pista", "Henning Mankell", "Tusquets", new Timestamp(date.getTime())));

			for (Libro libro : lista) {
				session.save(libro);
			}

			tx.commit();

		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			
			e.printStackTrace();
			
		} finally {
			session.close();
		}

	}

}
