package com.arcplusinc.moviedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Titles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Titles", catalog = "MovieDB")
public class Titles implements java.io.Serializable {

	// Fields

	private Integer mkey;
	private Directors directors;
	private String titles;
	private String own;
	private String format;
	private Integer rating;
	private String onloan;
	private String imdbref;

	// Constructors

	/** default constructor */
	public Titles() {
	}

	/** full constructor */
	public Titles(Directors directors, String titles, String own,
			String format, Integer rating, String onloan, String imdbref) {
		this.directors = directors;
		this.titles = titles;
		this.own = own;
		this.format = format;
		this.rating = rating;
		this.onloan = onloan;
		this.imdbref = imdbref;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "mkey", unique = true, nullable = false)
	public Integer getMkey() {
		return this.mkey;
	}

	public void setMkey(Integer mkey) {
		this.mkey = mkey;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "director", nullable = false)
	public Directors getDirectors() {
		return this.directors;
	}

	public void setDirectors(Directors directors) {
		this.directors = directors;
	}

	@Column(name = "titles", nullable = false, length = 40)
	public String getTitles() {
		return this.titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	@Column(name = "own", nullable = false, length = 1)
	public String getOwn() {
		return this.own;
	}

	public void setOwn(String own) {
		this.own = own;
	}

	@Column(name = "format", nullable = false, length = 3)
	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name = "rating", nullable = false)
	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Column(name = "onloan", nullable = false, length = 40)
	public String getOnloan() {
		return this.onloan;
	}

	public void setOnloan(String onloan) {
		this.onloan = onloan;
	}

	@Column(name = "imdbref", nullable = false, length = 7)
	public String getImdbref() {
		return this.imdbref;
	}

	public void setImdbref(String imdbref) {
		this.imdbref = imdbref;
	}

}