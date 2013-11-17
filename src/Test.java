import java.io.IOException;
import java.util.ArrayList;

import mail.MailUtil2;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;


public class Test {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String urls = new String("http://t66y.com/htm_data/20/1212/837961.html,http://t66y.com/htm_data/20/1212/837691.html,http://t66y.com/htm_data/20/1212/837841.html,http://t66y.com/htm_data/20/1212/837828.html,http://t66y.com/htm_data/20/1212/837166.html,http://t66y.com/htm_data/20/1212/837457.html,http://t66y.com/htm_data/20/1212/837617.html,http://t66y.com/htm_data/20/1212/837350.html,http://t66y.com/htm_data/20/1212/837576.html,http://t66y.com/htm_data/20/1212/837723.html,http://t66y.com/htm_data/20/1212/837727.html,http://t66y.com/htm_data/20/1212/837809.html");
		
		Document doc;
		try {
			String[] urla = urls.split(",");
			for(String fromURL : urla){
				doc = Jsoup.connect(fromURL).get();
				String title = doc.title();
				String novel = new HtmlToPlainText().getPlainText(doc.getElementsByClass("tpc_content").first());
				novel = novel + fromURL;
				System.out.println(novel);
				
				MailUtil2.sendNovel(title,novel);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
