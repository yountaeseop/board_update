package Board.utill;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Myutill {
	public static String getDate(String dateFormat) {
		
		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
		LocalDate now = LocalDate.now();
		// 포맷 정의하기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		// 포맷 적용하기
		String formatedNow = now.format(formatter);
		
		return formatedNow;
	}
}
