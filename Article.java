package Board;

public class Article {

	int id;
	String title;
	String content;
	String regDate;
	int memberId; // 게시물을 작성한 회원을 구별하기 위한 용도
	String nickname; // 
	int hit;
	
	public Article(int id, String title, String content, String regDate, int memberId, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.memberId = memberId;
		this.hit = hit;
	}
	
	
	
//	public Artile(int id, String title, String content) {
//		this.id = id;
//		this.title = title;
//		this.content = content;
//	} -> 한번에 하는 방법있음    -> Source -> Generate constructor using Fields -> Generate
	
}
