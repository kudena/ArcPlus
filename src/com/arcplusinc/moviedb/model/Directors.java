package com.arcplusinc.moviedb.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Directors entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="Directors"
    ,catalog="MovieDB"
)

public class Directors  implements java.io.Serializable {


    // Fields    

     private Integer dkey;
     private String lastName;
     private String firstName;
     private String name;
     private Set<Titles> titleses = new HashSet<Titles>(0);


    // Constructors

    /** default constructor */
    public Directors() {
    }

	/** minimal constructor */
    public Directors(String lastName, String firstName, String name) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.name = name;
    }
    
    /** full constructor */
    public Directors(String lastName, String firstName, String name, Set<Titles> titleses) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.name = name;
        this.titleses = titleses;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="dkey", unique=true, nullable=false)

    public Integer getDkey() {
        return this.dkey;
    }
    
    public void setDkey(Integer dkey) {
        this.dkey = dkey;
    }
    
    @Column(name="last_name", nullable=false, length=25)

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="first_name", nullable=false, length=25)

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="name", nullable=false, length=50)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="directors")

    public Set<Titles> getTitleses() {
        return this.titleses;
    }
    
    public void setTitleses(Set<Titles> titleses) {
        this.titleses = titleses;
    }
   








}