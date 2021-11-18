package Board;

public class Members {
	
	int id; // 절대중복되지 않는 회원번호
	String loginId;
	String loginPw;
	String nickname;
	
	public Members(int id, String loginId, String loginPw, String nickname) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
	}
	
	
}
