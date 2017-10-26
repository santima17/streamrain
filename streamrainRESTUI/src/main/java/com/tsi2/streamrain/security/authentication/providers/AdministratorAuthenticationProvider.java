package com.tsi2.streamrain.security.authentication.providers;

import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AdministratorAuthenticationProvider implements AuthenticationProvider {

	//para entender esto leer https://dzone.com/articles/spring-security-custom es facil
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName().trim();
		String password = authentication.getCredentials().toString().trim();
		Authentication auth = null;
		//String role = login.getApplicationRole(userName, password, "ADMIN","DEVELOPER"); ESTO ES EL LOGIN CUSTOM Autoriza y retorna los roles
        //if (role != null){
			//Collection<GrantedAuthority> grantedAuths = new SimpleGrantedAuthority(role.trim());
			//ApplicationUser appUser = new ApplicationUser(userName, password, true, true, true, true, grantedAuths,
			//	"TestEmail");
			//auth = new UsernamePasswordAuthenticationToken(appUser, password, grantedAuths);
			return auth;
		//}else{
			//return null;
		//}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
