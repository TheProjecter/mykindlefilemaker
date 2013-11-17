import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;

public class ContentLoader {

	public static String load(String[] urls) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		if(urls == null){
			
		}else{
			Document doc;
			try {
				String heada = "<head><meta http-equiv=\"Content-Type\" content='text/html; charset=utf-8'><title>";
				String headb = "</title><meta name='keywords' content=''><meta name='description' content=''></head>";
				sb.append(heada);
				sb.append("xxx");
				sb.append(headb);
				sb.append("<body>");
				for (String fromURL : urls) {
					doc = Jsoup.connect(fromURL).get();
					String title = doc.title();
					if(isLJArtical(title)){
						continue;
					}
					sb.append("<H1>");
					sb.append(title);
					sb.append("</H1>");
					String novel = new HtmlToPlainText().getPlainText(doc.getElementsByClass("tpc_content").first());
					sb.append(doc.getElementsByClass("tpc_content").first().outerHtml());
					sb.append(fromURL);

					sb.append("<p>");
					sb.append("<p>");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sb.append("</body>");
		sb.append("</html>");
		
		System.out.println(sb);
		return sb.toString();
	}
	
	
	public static String loadAma(String[] urls) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		if(urls == null){
			
		}else{
			Document doc;
			try {
				String heada = "<head><meta http-equiv=\"Content-Type\" content='text/html; charset=utf-8'><title>";
				String headb = "</title><meta name='keywords' content=''><meta name='description' content=''></head>";
				sb.append(heada);
				sb.append("xxx");
				sb.append(headb);
				sb.append("<body>");
				for (String fromURL : urls) {
					doc = Jsoup.connect(fromURL).get();
					String title = new HtmlToPlainText().getPlainText(doc.getElementsByClass("title").first());
					if(isLJArtical(title)){
						continue;
					}
					sb.append("<H1>");
					sb.append(title);
					sb.append("</H1>");
					sb.append(doc.getElementsByClass("postContent").first().outerHtml());
					sb.append(fromURL);

					sb.append("<p>");
					sb.append("<p>");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sb.append("</body>");
		sb.append("</html>");
		
		System.out.println(sb);
		return sb.toString();
	}
	
	private static boolean isLJArtical(String title){
		for(int i=0; i<uselessArticals.length; i++){
			if(title.indexOf(uselessArticals[i]) != -1){
				return true;
			}
		}
		return false;
	}
	private static String[] uselessArticals = {
		"PDF",
		"有声"
		};

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//load(URLListTest.listCLAllURL(null));
//		String[] x = {URLListTest.listCLAllURL(null)[0]};
//		load(x);
		String[] xx = {URLListTest.listCLAllURLAmazon(null)[0]};
		loadAma(xx);
	}

}
