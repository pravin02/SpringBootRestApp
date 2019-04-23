package org.pk.springboot.rest.domian;

import lombok.Data;

/**
 * @author PKCORP
 *
 */
@Data
public class UserModel {

	private int userId;
	private String password;
	private String newPassword;
	private String confirmPassword;

}