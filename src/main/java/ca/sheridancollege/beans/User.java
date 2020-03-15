package ca.sheridancollege.beans;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	private long userId;
	private String userName;
	private String encryptedPassword;
	
	
}
