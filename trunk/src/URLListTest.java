import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class URLListTest {
	
	public static void listAllURL() throws IOException{
		Document doc = Jsoup.connect("http://t66y.com/thread0806.php?fid=20").get();

		Element link = doc.select("a").first();
		Elements links = doc.select("a");
		for(Element l : links){
			String relHref = l.attr("href"); // == "/"
			String absHref = l.attr("abs:href"); // "http://jsoup.org/"
			System.out.println(relHref);
			System.out.println(absHref);
		}
		
	}
	
	public static String[] listCLAllURL(String clURL) throws IOException{
		if(clURL == null){
			clURL = "http://t66y.com/thread0806.php?fid=20";
		}
		ArrayList returnVar  = new ArrayList();
		Document doc = Jsoup.connect(clURL).get();

		Element link = doc.select("a").first();
		link.toString();
		Elements links = doc.select("a[href$=.html][title]");
//		Elements links = doc.select("a[href$=.html]");
		List uselessURLArry = Arrays.asList(uselessURLs);
		for(Element l : links){
			String absHref = l.attr("abs:href"); // "http://jsoup.org/"
			if(uselessURLArry.contains(absHref)){
				continue;
			}
			System.out.println(absHref);
			returnVar.add(absHref);
		}
		
		return (String[]) returnVar.toArray(new String[0]);
	}
	
	public static String[] listCLAllURLAmazon(String clURL) throws IOException{
		if(clURL == null){
			clURL = "http://www.amazon.com/gp/feature.html?docId=1000234621";
		}
		ArrayList returnVar  = new ArrayList();
		Document doc = Jsoup.connect(clURL).get();

		Element link = doc.select("a").first();
		Element linkxx = doc.select(".dataGrid").first();
		//linkxx.select(".dataGrid").first();
		
		Elements links = doc.select("span[style=display:inline-block; vertical-align:top]");
		//http://jsoup.org/apidocs/org/jsoup/select/Selector.html
		//http://jsoup.org/cookbook/extracting-data/selector-syntax
		
		link.toString();
		//Elements links = doc.select("a[href$=.html]");
		List uselessURLArry = Arrays.asList(uselessURLs);
		for(Element l : links){
			Element linkxxxsss = l.select("a").first();
			String absHref = linkxxxsss.attr("abs:href"); // "http://jsoup.org/"
			if(uselessURLArry.contains(absHref)){
				continue;
			}
			System.out.println(absHref);
			returnVar.add(absHref);
		}
		
		return (String[]) returnVar.toArray(new String[0]);
	}
	
	private static String[] uselessURLs = {
			"http://t66y.com/htm_data/20/0810/183193.html",
			"http://t66y.com/htm_data/20/0805/131469.html",
			"http://t66y.com/htm_data/20/0707/46242.html",
			"http://t66y.com/htm_data/20/1212/635086.html",
			"http://t66y.com/htm_data/20/1212/835826.html",
			"http://t66y.com/htm_data/20/1212/835826.html",
			"http://t66y.com/htm_data/20/1212/836943.html",
			"http://t66y.com/htm_data/20/1212/836942.html",
			"http://t66y.com/htm_data/20/1212/833884.html",
			"",
			"",
			"",
			"",
			"",
			"",
			""
			};
	
	
	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		listCLAllURL(null);
		listCLAllURLAmazon(null);
		//listCLAllURL("http://www.amazon.com/gp/feature.html?docId=1000234621");
	}

}
