package com.company.company.homework5.HibernateExample.src.net.common;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import net.common.model.Person;

public class PersonTest
{
	                Session     session = null;
	private  final  String[][]  persons = {{"12", "������"}, {"14", "�������"}};
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * ��������� �������� ������
	 * @return org.hibernate.Session
	 */
	private Session createHibernateSession()
	{
		SessionFactory   sessionFactory  = null;
		ServiceRegistry  serviceRegistry = null;
		try {
			try {
				Configuration cfg = new Configuration().
						                addResource("person.hbm.xml").configure();
				serviceRegistry = new StandardServiceRegistryBuilder().
						              applySettings(cfg.getProperties()).build();
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			} catch (Throwable e) {
				System.err.println("Failed to create sessionFactory object." + e);
				throw new ExceptionInInitializerError(e);
			}
			session = sessionFactory.openSession();
			System.out.println("�������� ������");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return session;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * ��������� ���������� ������� � �������
	 */
	private void recordsAdd()
	{
		try {
			System.out.println("���������� ������ � ������� ��");
			Transaction tx = session.beginTransaction();
			for (int i = 0; i < persons.length; i++) {
				Person person = new Person();
				person.setId(Integer.valueOf(persons[i][0]));
				person.setName(persons[i][1]);
				session.save(person);
			}
			tx.commit();
			System.out.println("������� ���������");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * ��������� ������ �������
	 */
	private void recordsRead()
	{
        System.out.println("\n������ ������� �������");
		String query = "select p from " + Person.class.getSimpleName() + " p";
			
        @SuppressWarnings("unchecked")
		List<Person> list = (List<Person>)session.createQuery(query).list();
        System.out.println(list);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * ��������� ������ ������
	 */
	private void recordFind(final int id)
	{
        System.out.println("\n������ ������ ������� �� ID");
		Person person = (Person) session.load(Person.class, id);
        System.out.println(person);
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * ����������� ������
	 */
	public PersonTest()
	{
		// �������� ������
		session = createHibernateSession();
		if (session != null) {
			// ���������� ������� � �������
            recordsAdd();
            // ������ ������� �������
            recordsRead();
            // ����� ������ �� �������������� 
            recordFind(Integer.valueOf(persons[1][0]));
            // �������� ������
            if (session.isOpen())
                session.close();
        }
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void main(String[] args)
	{
		new PersonTest();
		System.exit(0);
	}
}