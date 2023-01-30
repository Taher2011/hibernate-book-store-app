package com.techgen.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "book_isbn")
	private String isbn;

	@Column(name = "book_name")
	private String name;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "publisher_code")
	private Publisher publisher;

	@OneToMany(mappedBy = "book", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Chapter> chapters = new HashSet<>();

	public Book(String isbn, String name, Publisher publisher) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}

	public void addChapter(Chapter chapter) {
		chapters.add(chapter);
		// chapter.setBook(this);
	}

	public void removeChapter(Chapter chapter) {
		chapters.remove(chapter);
		chapter.setBook(null);
	}

}
