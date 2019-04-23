package org.pk.springboot.rest.domian;

/**
 * @author Pravin P Patil
 *
 */
public enum UserRole {
	ADMIN, EMPLOYEE;

	/**
	 * @param userRole
	 * @return
	 */
	public static UserRole getUserRole(String userRole) {
		for (UserRole ur : UserRole.values())
			if (ur.name().equals(userRole))
				return ur;

		return null;
	}
}
