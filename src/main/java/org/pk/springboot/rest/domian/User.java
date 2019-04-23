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
import lombok.ToString;

/**
 * @author Pravin P Patil
 *
 */
@Data
@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(nullable = false)
	private String fullName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private UserRole role;

	@Column
	private String address;

	@Column
	private String mobileNumber;

	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name = "cityId")
	private City city;

	@ManyToOne(targetEntity = Company.class)
	@JoinColumn(name = "companyId")
	private Company company;

}
