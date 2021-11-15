package Board;

public class Article {

	int id;
	String title;
	String content;
	String regDate;
	String writer;
	int hit;
	
	public Article(int id, String title, String content, String regDate, String writer, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.writer = writer;
		this.hit = hit;
	}
	
	
	
//	public Artile(int id, String title, String content) {
//		this.id = id;
//		this.title = title;
//		this.content = content;
//	} -> 한번에 하는 방법있음    -> Source -> Generate constructor using Fields -> Generate
	
}
