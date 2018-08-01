package hibernateuno.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import javassist.compiler.SyntaxError;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Para Hibernate 5
			// Archivo de conf hibernate.cfg.xml
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
		} catch (Throwable ex) {
			System.err.println("No se pudo crear la conexión a la BD");
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
