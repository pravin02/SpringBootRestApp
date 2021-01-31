package org.pk.springboot.rest.domian;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the state database table.
 */

@Data
@NoArgsConstructor
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

    public Country(int countryId, String countryCode, String countryName, String currency) {
        this.setCountryId(countryId);
        this.setCountryCode(countryCode);
        this.setCountryName(countryName);
        this.setCurrency(currency);
    }

}
