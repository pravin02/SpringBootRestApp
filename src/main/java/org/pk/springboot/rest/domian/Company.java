package org.pk.springboot.rest.domian;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Pravin P Patil
 *
 */
@Data
@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column
	private String address;

	@Column
	private String contactNumber;
	
	@Column
	private String registrationNumber;
	
	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name = "cityId")
	private City city;

}
