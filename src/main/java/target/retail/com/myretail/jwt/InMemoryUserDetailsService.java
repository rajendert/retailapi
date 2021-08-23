package target.retail.com.myretail.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "rajender",
				"$2a$10$lo1lEbCVoTSfTIMjK9mte.cY/HnQHMhPy7zSzsGiQOAdCtRsten6.", "ROLE_USER"));
		// inMemoryUserList.add(new JwtUserDetails(2L, "pandu",
		// "$2a$10$Xo3ubwoTGmR0VIHlMDNLpOs0K6CZVHC.1Qp1qg63f4Teood2ThKha",
		// "ROLE_USER_2"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
