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
@Table(name = "state")
@NamedQuery(name = "State.findAll", query = "SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int stateId;

	@Column(unique = false, nullable = false, length = 10)
	private String stateCode;

	@Column(unique = false, nullable = false, length = 45)
	private String stateName;

	@ManyToOne
	@JoinColumn(name = "countryId", referencedColumnName = "countryId")
	private Country country;	
	
}