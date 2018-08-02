package hibernateuno.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import hibernateuno.domain.Libro;
import hibernateuno.util.HibernateUtil;

public class TestRead {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
		Root<Libro> root = cq.from(Libro.class);
		cq.select(root); // select * from
		
		List<Libro> lista = session.createQuery(cq).getResultList();
		System.out.println(lista);
		
		cq.where(cb.equal(root.get("autor"), "Henning Mankell"));
		List<Libro> hm = session.createQuery(cq).getResultList();
		System.out.println(hm);

		cq.where(cb.equal(root.get("id"), 2));
		System.out.println(session.createQuery(cq).getResultList());
		
		cq.where(cb.like(root.get("autor"), "%onan%"));
		System.out.println(session.createQuery(cq).getResultList());

		session.getTransaction().commit();
		session.close();
		
	}

}
