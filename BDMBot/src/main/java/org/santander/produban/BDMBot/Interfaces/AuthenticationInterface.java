package org.santander.produban.BDMBot.Interfaces;

public interface AuthenticationInterface {

	/**
	 * @author Marco Antonio Pereira
	 * @date 12 Sept 2016
	 * @description Method for authentication by LDAP
	 * @param authData 
	 * @telegramParam /setLogin
	 * @throws InvalidAuthenticationExcetpion
	 * 
	 */
	void authLDAP(Object[] authData);
}
 