package data;

public class User {

	private String username;
	private String password;
	private int uid;
	
	public User(String username, String password, int uid){
		setUsername(username);
		setPassword(password);
		setUid(uid);
	}
	
	public User(String username, String password){
		setUsername(username);
		setPassword(password);
	}
	
	public User(){};

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
