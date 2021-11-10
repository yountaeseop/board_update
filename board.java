package Board;

import java.util.ArrayList;
import java.util.Scanner;

public class board {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> contents = new ArrayList<>();
		ArrayList<Integer> numbers = new ArrayList<>();
		
		int num = 1;
		
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
				num++;
			}

			else if(order.equals("list")) { // 조회
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
			else if(order.equals("update")) { // 수정
				
				System.out.print("수정할 게시물 번호:");
				int targetNo = Integer.parseInt(sc.nextLine());
				
				int targetIndex = -1;
				
				for(int i = 0; i < numbers.size(); i++) {
					int currentNo = numbers.get(i);
					if(targetNo == currentNo) {
						targetIndex = i;
						break;
					}
				}
				
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
				}
				
//				if(titles.get(unum - 1) == "\0") {
//						System.out.println("없는 게시물 번호입니다.");
//						break;
//					}
				
				
				
			}
			else if(order.equals("delete")) {
				System.out.println("삭제할 게시물 번호:");
			}
			
			System.out.println("===========================");
		}
		
		

	}

}
