package org.pk.springboot.rest.domian;

import java.io.Serializable;

import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the state database table.
 */
@Data
@NoArgsConstructor
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

    public State(int stateId, String stateCode, String stateName, Country country) {
        this.setStateId(stateId);
        this.setStateCode(stateCode);
        this.setStateName(stateName);
        this.setCountry(country);
    }
}