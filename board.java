package Board;

import java.util.ArrayList;
import java.util.Scanner;

import Board.utill.Myutill;

public class board {
	
	ArrayList<Article> articles = new ArrayList<>(); 
	ArrayList<Members> member = new ArrayList<>();
	Members loginedmember; // 로그인 유저정보
	
	Scanner sc = new Scanner(System.in);
	
	int articleNum = 4; // 게시물 등록번호
	int memberNum = 3; // 회원등록 번호
	
	public board(){ //board 클래스의 생성자 이용
		makeTestData(); // 테스트 데이터 만들기
	}
	
	public void run_board() {
		
		while(true) {
			
			if(loginedmember == null) {
				System.out.print("명령어를 입력해주세요:");
			}else {
				System.out.print("명령어를 입력해주세요["+loginedmember.nickname+"("+loginedmember.loginId+")]:");				
			}
			String order = sc.nextLine();
			
			if(order.equals("help")) {
				printHelp();
			}else if(order.equals("add")) {
				if(isLogincheck() == true) {
					addArticle();					
				}
			}else if(order.equals("list")) {
				list(articles);
			}else if(order.equals("update")) {
				updateArticle(); 
			}else if(order.equals("delete")){
				deleteArticle();
			}else if(order.equals("search")) {
				searchArticle();
			}else if(order.equals("read")) {
				readArticle();
			}else if(order.equals("signup")) {
				signup();
			}else if(order.equals("login")) {
				login();
			}else if(order.equals("logout")) {
				if(isLogincheck() == true) {
					logout();					
				}
			}
				
			System.out.println("================");
		}	
	}
	public Article getArticleByNo(int targetNo) {
		
		Article targetArticle = null;
		
		for(int i = 0; i < articles.size(); i++) {
			Article currentArticle = articles.get(i);
			if(targetNo == currentArticle.id) {
				targetArticle = currentArticle;
				break;
			}
		}
		
		if(targetArticle != null) {
			Members writer = getmemberBymemberNo(targetArticle.memberId);
			targetArticle.nickname = writer.nickname;			
		}
		
		return targetArticle;
	}
	
	private Members getmemberBymemberNo(int memberId) {
		
		Members targetMember = null;
		
		for(int i = 0; i < member.size(); i++) {
			Members currentMember = member.get(i);
			if(memberId ==  currentMember.id) {
				targetMember = currentMember;
				break;
			}
		}
		
		return targetMember;
		
	}

	private boolean isLogincheck() {
		if(loginedmember == null) {
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		}
		return true;
	}
	
	private void logout() {
		
		loginedmember = null;
		System.out.println("로그아웃 되었습니다.");
		
	}

	private void login() {
		System.out.print("아이디:");
		String loginId = sc.nextLine();
		System.out.print("비밀번호:");
		String loginPw = sc.nextLine();
		
		boolean isexistLoginId = false; 
		
		for(int i = 0; i < member.size(); i++) { //String이 동일할땐 .equals()를 사용!!!
			Members members = member.get(i);
			if(members.loginId.equals(loginId) && members.loginPw.equals(loginPw)) {
				System.out.println(members.nickname +"님 환영합니다!");
				loginedmember = members;
				isexistLoginId = true;
				break;
			}
		}
		if(isexistLoginId == false) {
			System.out.println("비밀번호가 틀렸거나 잘못된 회원정보입니다.");
		}
		
	}

	private void signup() {
		
		System.out.println("==== 회원 가입을 진행합니다 ====");
		System.out.print("아이디를 입력해주세요 :");
		String loginId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 :");
		String loginPw = sc.nextLine();
		System.out.print("닉네임을 입력해주세요 :");
		String nickname = sc.nextLine();
		
		Members members = new Members( memberNum,loginId, loginPw, nickname);
		member.add(members);
		
	    System.out.println("==== 회원가입이 완료되었습니다. ====");
	    memberNum++;
	}

	private void readArticle() {
		System.out.print("상세보기할 게시물 번호를 입력해주세요:");
		int targetNum = Integer.parseInt(sc.nextLine());
						
						
		Article standard = getArticleByNo(targetNum);
		// standard의 값을 초기화시키는 반복문 -> 거름망 역할을 함
		
		if(standard == null) {
			System.out.println("없는 게시물입니다.");
		} else { 
			
			standard.hit++; //조회수 증가
			
			System.out.println("===="+targetNum+"번 게시물 ====");
			System.out.println("번호 :"+standard.id);
		    System.out.println("제목 :"+standard.title);
			System.out.println("-------------------");
			System.out.println("내용 :"+standard.content);
			System.out.println("-------------------");
			System.out.println("작성자 :"+standard.memberId);
			System.out.println("등록날짜:"+standard.regDate);
			System.out.println("===================");
			System.out.println("조회수:"+standard.hit);
		}
		
	}

	private void makeTestData() {
		String currentDate = Myutill.getDate("yyyy-MM-dd");
		articles.add(new Article(1, "안녕하세요", "내용1입니다.",currentDate, 1,0));
		articles.add(new Article(2, "반갑하세요", "내용2입니다.",currentDate, 2,0));
		articles.add(new Article(3, "안녕안녕", "내용3입니다.",currentDate, 1, 0));
		member.add(new Members(1,"dbsxotjq","dbsxotjq","dbsxotjq") );
		member.add(new Members(2,"광폭철","광폭철","광폭철") );
		
		loginedmember = member.get(0); //dbsxotjq으로 로그인 돼있음!!!
	}

	private void searchArticle() {
		System.out.println("검색키워드를 입력해주세요:");
		String targetword = sc.nextLine();
		
		ArrayList<Article> searchedArticles = new ArrayList<>();
		
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).title.contains(targetword)) {
				searchedArticles.add(articles.get(i));
			}
		}
		
		list(searchedArticles);
	}
	
	private void deleteArticle() {
		System.out.println("삭제할 게시물 번호:");
		int targetNum = Integer.parseInt(sc.nextLine());
		
		Article standard = getArticleByNo(targetNum);
	
		if(standard == null) {
			System.out.println("없는 게시물 번호 입니다.");
		} else {
			
			articles.remove(standard);
			
			System.out.println("삭제가 완료되었습니다.");
			
			list(articles);
		}
		
		
	}

	private void updateArticle() {
		System.out.print("수정할 게시물 번호:");
		int targetNum = Integer.parseInt(sc.nextLine());
		
		Article standard = getArticleByNo(targetNum);
		
		// standard의 값을 초기화시키는 반복문 -> 거름망 역할을 함
		
		if(standard == null) {
			System.out.println("없는 게시물입니다.");
		} else {
			System.out.print("제목:");
			String title = sc.nextLine();
			System.out.print("내용:");
			String content = sc.nextLine();
			
			standard.title = title;
			standard.content = content;
			
			
			System.out.println("수정이 완료되었습니다.");
		}
		
		
		list(articles);
		
	}

	private void addArticle() {
		
		System.out.print("제목을 입력해주세요:");
		String title = sc.nextLine();
		
		System.out.print("내용을 입력해주세요:");
		String content = sc.nextLine();
		
		String currentDate = Myutill.getDate("yyyy.MM.dd");
		Article article = new Article(articleNum, title, content,currentDate, loginedmember.id, 0);
		articles.add(article);
	
		articleNum++; // 게시물 등록번호 자동증가
		
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
		
		for(int i = 0; i < articles.size(); i++){
			Article currentArticle = articles.get(i);
			if(targetNum == currentArticle.id) {
				return i; // return하면 함수가 그 즉시 종료
			}
		}
		return -1; // 위에 반복문을 끝까지 돌았음에도 불구하고
				   // if문 조건이 맞지 않아서 return이 안될 수도 있다.
				   // 그러면 리턴하는 값이 없기때문에 실행이 안됨
				   // return하는 값을 넣어줘야하기때문에 -1을 넣어야함.	
		
	}

	public void list(ArrayList<Article> list) { // 매개변수로 리스트를 부여해서 중복없이 출력
		for(int i = 0; i < list.size(); i++) {
			System.out.println("번호 :" + list.get(i).id);
			System.out.println("제목 :" + list.get(i).title);
			//System.out.println("내용 :" + list.get(i).content);
			System.out.println("등록날짜 :" + list.get(i).regDate);
			System.out.println("작성자 :" + list.get(i).memberId);
			System.out.println("조회수 :" + list.get(i).hit);
			
			System.out.println("----------------");
		}
		
	}
	
	
	
}
