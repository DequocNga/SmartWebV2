package com.itsol.smartweb.model;
// Generated Mar 1, 2019 4:33:38 PM by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TblCategory generated by hbm2java
 */
@Entity
@Table(name = "tbl_category", catalog = "smart_web")
public class TblCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private String categoryTitle;
	private Set<TblNews> tblNewses = new HashSet<TblNews>(0);

	public TblCategory() {
	}

	public TblCategory(String categoryTitle, Set<TblNews> tblNewses) {
		this.categoryTitle = categoryTitle;
		this.tblNewses = tblNewses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category_title", length = 45)
	public String getCategoryTitle() {
		return this.categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblCategory")
	public Set<TblNews> getTblNewses() {
		return this.tblNewses;
	}

	public void setTblNewses(Set<TblNews> tblNewses) {
		this.tblNewses = tblNewses;
	}

}