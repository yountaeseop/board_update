package Board;

import java.util.ArrayList;
import java.util.Scanner;

public class board {
	
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	ArrayList<String> titles = new ArrayList<String>();
	ArrayList<String> contents = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	
	int num = 1; // 게시물 등록번호
	
	public void run_board() {
		
		while(true) {
			
			System.out.print("명령어를 입력해주세요:");
			String order = sc.nextLine();
			
			if(order.equals("help")) {
				System.out.println("add : 게시물 등록");
				System.out.println("list : 게시물 목록 조회");
			}
			else if(order.equals("add")) {
				
				numbers.add(num);
				
				System.out.print("제목을 입력해주세요:");
				String title = sc.nextLine();
				titles.add(title);
				
				System.out.print("내용을 입력해주세요:");
				String content = sc.nextLine();
				contents.add(content);
				
				num++; // 게시물 등록번호 자동증가
				
				System.out.println("게시물이 저장되었습니다.");
			}
			else if(order.equals("list")) {
				list();
			}
			else if(order.equals("update")) {
				System.out.print("수정할 게시물 번호:");
				int targetNum = Integer.parseInt(sc.nextLine());
				
				int standard = standard(targetNum);
				// standard의 값을 초기화시키는 반복문 -> 거름망 역할을 함
				
				if(standard == -1) {
					System.out.println("없는 게시물입니다.");
				} else {
					System.out.print("제목:");
					String title = sc.nextLine();
					titles.set(standard, title);
					System.out.print("내용:");
					String content = sc.nextLine();
					contents.set(standard, content);
					
					System.out.println("수정이 완료되었습니다.");
				}
				
				
				list();
			}
			else if(order.equals("delete")){
				System.out.println("삭제할 게시물 번호:");
				int targetNum = Integer.parseInt(sc.nextLine());
				
				int standard = standard(targetNum);
			
				if(standard == -1) {
					System.out.println("없는 게시물 번호 입니다.");
				} else {
					numbers.remove(standard);
					titles.remove(standard);
					contents.remove(standard);
					System.out.println("삭제가 완료되었습니다.");
					
					list();
				}
				
			}
			
			
			System.out.println("================");
		}
		
		
	}

	public int standard(int targetNum) {
		
		for(int i = 0; i < numbers.size(); i++){
			int currentNum = numbers.get(i);
			if(targetNum == currentNum) {
				return i; // return하면 함수가 그 즉시 종료
			}
		}
		return -1; // 위에 반복문을 끝까지 돌았음에도 불구하고
				   // if문 조건이 맞지 않아서 return이 안될 수도 있다.
				   // 그러면 리턴하는 값이 없기때문에 실행이 안됨
				   // return하는 값을 넣어줘야하기때문에 -1을 넣어야함.	
		
	}

	public void list() {
		for(int i = 0; i < titles.size(); i++) {
			System.out.println("번호 :" + numbers.get(i));
			System.out.println("제목 :" + titles.get(i));
			System.out.println("내용 :" + contents.get(i));
		}
		
	}
	
	
	
}
