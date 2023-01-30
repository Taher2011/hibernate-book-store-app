package com.techgen.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ChapterID implements Serializable {

	@Column(name = "chapter_number")
	private int chapterNumber;

	private String isbn;

	@Override
	public int hashCode() {
		return Objects.hash(chapterNumber, isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChapterID other = (ChapterID) obj;
		return chapterNumber == other.chapterNumber && Objects.equals(isbn, other.isbn);
	}

}
