package Board;

import java.util.ArrayList;
import java.util.Scanner;

public class board {
	
	ArrayList<Article> Articles = new ArrayList<>(); 
	
	Scanner sc = new Scanner(System.in);
	
	int num = 1; // 게시물 등록번호
	
	public void run_board() {
		
		while(true) {
			
			System.out.print("명령어를 입력해주세요:");
			String order = sc.nextLine();
			
			if(order.equals("help")) {
				printHelp();
			}else if(order.equals("add")) {
				addArticle();
			}else if(order.equals("list")) {
				list();
			}else if(order.equals("update")) {
				updateArticle(); 
			}else if(order.equals("delete")){
				deleteArticle();
			}else if(order.equals("search")) {
				searchArticle();
			}
			System.out.println("================");
		}	
	}

	private void searchArticle() {
		
		
	}

	private void deleteArticle() {
		System.out.println("삭제할 게시물 번호:");
		int targetNum = Integer.parseInt(sc.nextLine());
		
		int standard = standard(targetNum);
	
		if(standard == -1) {
			System.out.println("없는 게시물 번호 입니다.");
		} else {
			
			Articles.remove(standard);
			
			System.out.println("삭제가 완료되었습니다.");
			
			list();
		}
		
		
	}

	private void updateArticle() {
		System.out.print("수정할 게시물 번호:");
		int targetNum = Integer.parseInt(sc.nextLine());
		
		int standard = standard(targetNum);
		// standard의 값을 초기화시키는 반복문 -> 거름망 역할을 함
		
		if(standard == -1) {
			System.out.println("없는 게시물입니다.");
		} else {
			System.out.print("제목:");
			String title = sc.nextLine();
			System.out.print("내용:");
			String content = sc.nextLine();
			
			
			Article  Article = new Article(targetNum, title, content);
			Articles.set(standard, Article);
			
			
			System.out.println("수정이 완료되었습니다.");
		}
		
		
		list();
		
	}

	private void addArticle() {
		System.out.print("제목을 입력해주세요:");
		String title = sc.nextLine();
		
		System.out.print("내용을 입력해주세요:");
		String content = sc.nextLine();
		
		Article Article = new Article(num, title, content);
		Articles.add(Article);
	
		num++; // 게시물 등록번호 자동증가
		
		System.out.println("게시물이 저장되었습니다.");
		
	}

	private void printHelp() {
		System.out.println("add : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");
		System.out.println("update : 게시물 수정");
		System.out.println("delete : 게시물 삭제");
		System.out.println("search : 게시물 검색");
		
	}

	public int standard(int targetNum) {
		
		for(int i = 0; i < Articles.size(); i++){
			Article currentArticle = Articles.get(i);
			if(targetNum == currentArticle.id) {
				return i; // return하면 함수가 그 즉시 종료
			}
		}
		return -1; // 위에 반복문을 끝까지 돌았음에도 불구하고
				   // if문 조건이 맞지 않아서 return이 안될 수도 있다.
				   // 그러면 리턴하는 값이 없기때문에 실행이 안됨
				   // return하는 값을 넣어줘야하기때문에 -1을 넣어야함.	
		
	}

	public void list() {
		for(int i = 0; i < Articles.size(); i++) {
			Article Article = Articles.get(i);
			
			System.out.println("번호 :" + Article.id);
			System.out.println("제목 :" + Article.title);
			System.out.println("내용 :" + Article.content);
		}
		
	}
	
	
	
}
