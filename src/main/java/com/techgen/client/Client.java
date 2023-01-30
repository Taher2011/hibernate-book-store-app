package com.techgen.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techgen.entity.Book;
import com.techgen.entity.Chapter;
import com.techgen.entity.ChapterID;
import com.techgen.entity.Publisher;
import com.techgen.util.HibernateUtil;

public class Client {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;

		Session session = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.getCurrentSession();

			Transaction transaction = session.getTransaction();

			transaction.begin();

			// persistBookPublisherChapter(session);
			// deleteBook(session);

			transaction.commit();

		} catch (HibernateException e) {

			System.out.println(e.getMessage());

		} finally {

			if (session != null) {
				session.close();
			}

			if (sessionFactory != null) {
				sessionFactory.close();
			}

		}
	}

	private static void deleteBook(Session session) {
		Book book = getBook(session);
		session.remove(book);
	}

	private static Book getBook(Session session) {
		return session.get(Book.class, "15152JJHJ");
	}

	private static void persistBookPublisherChapter(Session session) {
		Publisher publisher = new Publisher("Jack-123", "Peter Jack");
		Book book = new Book("15152JJHJ", "Core Java Guide", publisher);

		ChapterID chapterID1 = new ChapterID(1, null);
		Chapter chapter1 = new Chapter(chapterID1, "OOPS", book);
		book.addChapter(chapter1);

		ChapterID chapterID2 = new ChapterID(2, null);
		Chapter chapter2 = new Chapter(chapterID2, "Strings", book);
		book.addChapter(chapter2);

		session.persist(book);
	}

}
