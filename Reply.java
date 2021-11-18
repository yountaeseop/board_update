package Board;

public class Reply {

	int id; //식별데이터
	String content; // 댓글 내용
	int memberId;	//댓글 작성자	
	String regDate; // 작성일
	
	public Reply(int id, String content, int memberId, String regDate) {
		super();
		this.id = id;
		this.content = content;
		this.memberId = memberId;
		this.regDate = regDate;
	}
	
	
		
}
