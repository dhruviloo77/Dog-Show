package ca.sheridancollege;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.DAO.DAO;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ca.sheridancollege.beans.User user = DAO.findUserAccount(username);
		if (user == null) {
			System.out.println("User not found!" + username);
			throw new UsernameNotFoundException("User" + username + "Not found in database.");
		}
		
		System.out.println("Found User: " + user);
		
		ArrayList<String> roles = DAO.getRoleName(user.getUserId());
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for (String role :roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		
		UserDetails userDetails = (UserDetails)
				new User(user.getUserName(),user.getEncryptedPassword(),grantList);
		
		return userDetails;
	}

}
