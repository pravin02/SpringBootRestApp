package org.pk.springboot.rest.domian;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The persistent class for the state database table.
 * 
 */
@Data
@Entity
@Table(name = "country")
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int countryId;

	@Column(unique = false, nullable = false, length = 10)
	private String countryCode;

	@Column(unique = false, nullable = false, length = 45)
	private String countryName;

	@Column(unique = false, nullable = false, length = 5)
	private String currency;

}