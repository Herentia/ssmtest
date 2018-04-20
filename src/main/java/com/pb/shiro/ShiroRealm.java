package com.pb.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

public class ShiroRealm implements Realm {

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken arg0)
			throws AuthenticationException {
		return null;
	}

	public String getName() {
		return null;
	}

	public boolean supports(AuthenticationToken arg0) {
		return false;
	}

}
