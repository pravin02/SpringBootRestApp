package org.pk.springboot.rest.domian;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The persistent class for the city database table.
 * 
 */
@Data
@Entity
@Table(name = "city")
@NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int cityId;

	@Column(unique = true, nullable = false)
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "stateId", referencedColumnName = "stateId")
	private State state;

}