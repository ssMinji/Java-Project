package miniProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NaverMovie {

	public static void main(String[] args) {
		Document movie1;
		Document movie2;
		Document movie3;

		for (int i = 1; i <= 10; i++) {
			try {
				movie1 = Jsoup.connect(
						"https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code=167638&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page="
								+ i).get();
				movie2 = Jsoup.connect(
						"https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code=156464&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page="
								+ i).get();
				movie3 = Jsoup.connect(
						"https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code=160487&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page="
								+ i).get();
				
				
				Elements newsHeadlines1 = movie1
						.select("body > div > div > div.score_result > ul > li:nth-child(n) > div.star_score > em");
				Elements reple1 = movie1
						.select("body > div > div > div.score_result > ul > li:nth-child(n) > div.score_reple > p");
				Elements newsHeadlines2 = movie2
						.select("body > div > div > div.score_result > ul > li:nth-child(n) > div.star_score > em");
				Elements reple2 = movie2
						.select("body > div > div > div.score_result > ul > li:nth-child(n) > div.score_reple > p");
				Elements newsHeadlines3 = movie3
						.select("body > div > div > div.score_result > ul > li:nth-child(n) > div.star_score > em");
				Elements reple3 = movie3
						.select("body > div > div > div.score_result > ul > li:nth-child(n) > div.score_reple > p");
				
				System.out.println("--------------------------" + "완벽한 타인" + "---------------------------------");
				for (int j = 0; j < newsHeadlines1.size(); j++) {
					BufferedWriter writer = new BufferedWriter(new FileWriter("Movie.txt", true));
					String a = newsHeadlines1.get(j).text();
					String b = reple1.get(j).text();
					System.out.println("완벽한타인" + a + b);
					writer.write("완벽한타인"+ "\t" + a + "\t" + b);
					writer.newLine();
					writer.flush();
				}
				System.out.println("--------------------------" + "보헤미안 랩소디" + "---------------------------------");
				for (int j = 0; j < newsHeadlines2.size(); j++) {
					BufferedWriter writer = new BufferedWriter(new FileWriter("Movie.txt", true));
					String a = newsHeadlines2.get(j).text();
					String b = reple2.get(j).text();
					System.out.println("보헤미안 랩소디" + a + b);
					writer.write("보헤미안 랩소디"+ "\t" + a + "\t" + b);
					writer.newLine();
					writer.flush();
				}
				System.out.println("--------------------------" + "창궐" + "---------------------------------");
				for (int j = 0; j < newsHeadlines3.size(); j++) {
					BufferedWriter writer = new BufferedWriter(new FileWriter("Movie.txt", true));
					String a = newsHeadlines3.get(j).text();
					String b = reple3.get(j).text();
					System.out.println("창궐" + a + b);
					writer.write("창궐" + "\t" + a + "\t" + b);
					writer.newLine();
					writer.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
