import java.io.IOException;
import java.util.Date;

import mail.MailUtil2;

import com.pingwang.cmd.ShellKindleGenRuntim;

import file.FileUtils;


public class Main {
	
	public static String[] getAllCLURLList() throws IOException{
		//return URLListTest.listCLAllURL(null);
		return URLListTest.listCLAllURLAmazon(null);
	}
	
	public static String loadContent(String[] urls){
		//return ContentLoader.load(urls);
		return ContentLoader.loadAma(urls);
	}
	public static String generateHtmlFile(String path, String content){
		FileUtils.write(path,content);
		return path;
	}
	public static String generateMobi(String path,String outPath) throws InterruptedException{
		
		return ShellKindleGenRuntim.gen(path,outPath);
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		String[] urls = getAllCLURLList();
		String content = loadContent(urls);
		String path = "cccxx.html";//new Date().toString() + "cccx.html";
		generateHtmlFile(path,content);
		generateMobi(path,null);
		MailUtil2.sendNovel(path, path,"xxx@free.kindle.com", "cccx.mobi");
	}

}
