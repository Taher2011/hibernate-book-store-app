package com.techgen.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "chapter")
public class Chapter {

	@EmbeddedId
	private ChapterID chapterID;

	private String title;

	@ManyToOne
	@JoinColumn(name = "book_isbn")
	@MapsId("isbn")
	private Book book;

	public Chapter(ChapterID chapterID) {
		super();
		this.chapterID = chapterID;
	}

}
