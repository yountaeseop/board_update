package Board;

public class Article {

	int id;
	String title;
	String content;
	
	public Article(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
//	public Artile(int id, String title, String content) {
//		this.id = id;
//		this.title = title;
//		this.content = content;
//	} -> 한번에 하는 방법있음    -> Source -> Generate constructor using Fields -> Generate
	
}
