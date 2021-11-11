package Board;

import java.util.ArrayList;
import java.util.Scanner;

public class board {

	ArrayList<String> titles = new ArrayList<>();
	ArrayList<String> contents = new ArrayList<>();
	ArrayList<Integer> numbers = new ArrayList<>();
	
	int num = 1; //게시물 번호
	
	public void runBoard() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어를 입력해주세요 :");
			String order = sc.nextLine();
			
			
			if(order.equals("help")) { // 도움말
				System.out.println("add : 게시물 등록");
				System.out.println("list : 게시물 목록 조회");
			}
			else if(order.equals("add")) { //추가
				
				numbers.add(num);
				
				System.out.print("제목을 입력해주세요:");
				String title = sc.nextLine();
				titles.add(title);
				
				System.out.print("내용을 입력해주세요:");
				String content = sc.nextLine();
				contents.add(content);
				
				System.out.println("게시물이 저장되었습니다.");
				num++; // 번호 자동 증가.
			}

			else if(order.equals("list")) { // 조회
				list();
			}
			else if(order.equals("update")) { // 수정
				
				System.out.print("수정할 게시물 번호:");
				int targetNo = Integer.parseInt(sc.nextLine());
										
				// 여기 반복문 코드를 이해하는 것이 핵심!!!!!!!
				
				 int targetIndex = getIndexOfArticleNo(targetNo);
				
				if(targetIndex == -1) {
					System.out.println("없는 게시물입니다.");
				} else {
					System.out.print("새제목 :");
					String title = sc.nextLine();
					titles.set(targetIndex, title);
					
					System.out.print("새내용 :");
					String content = sc.nextLine();
					contents.set(targetIndex, content);
					
					System.out.println("수정이 완료되었습니다.");
					
					list();
				}	
			}
			else if(order.equals("delete")) {
				System.out.println("삭제할 게시물 번호 :");
				int targetNo = Integer.parseInt(sc.nextLine());
				
				int ArticleNo = getIndexOfArticleNo(targetNo);
				
				if(ArticleNo == -1) {
					System.out.println("없는 게시물 번호입니다.");
				} else {
					numbers.remove(ArticleNo);
					titles.remove(ArticleNo);
					contents.remove(ArticleNo);
					System.out.println("삭제가 완료되었습니다.");
					
					list();
				}
				
			}
			
			
			
		}
	}

	private int getIndexOfArticleNo(int targetNo) {
		for(int i = 0; i < numbers.size(); i++) {
			int currentNo = numbers.get(i);
			if(targetNo == currentNo) {
				return i; // 여기 반복문 코드를 이해하는 것이 핵심!!!!!!!
				
			}
		}
		return -1;
	}

	public void list() {
		for(int i = 0; i < titles.size(); i++) {
			System.out.print("번호 :");
			System.out.println(numbers.get(i));
			System.out.print("제목 :");
			System.out.println(titles.get(i));
			System.out.print("내용 :");
			System.out.println(contents.get(i));
			System.out.println("----------------");
		}
		
	}
}


