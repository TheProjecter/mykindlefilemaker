package com.pingwang.cmd;

import java.io.IOException;
import java.io.InputStreamReader;

public class ShellKindleGenRuntim {
	public static String gen(String path,String outputPath) throws InterruptedException{
		if(outputPath == null){
			outputPath = "";
		}else{
			outputPath = " -o " + outputPath;
		}
		// Get runtime
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        // Start a new process: UNIX command ls
        java.lang.Process p;
		try {
			p = rt.exec("chmod 777 kindlegen");
			p.waitFor();
			p = rt.exec("./kindlegen " + path + outputPath);
			p.waitFor();
			System.out.println("Process exited with code = " + p.exitValue());
			
			// Get process' output: its InputStream
	        java.io.InputStream is = p.getInputStream();
	        java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
	        // And print each line
	        String s = null;
	        while ((s = reader.readLine()) != null) {
	            System.out.println(s);
	        }
	        is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Show exit code of process
		return path;
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		gen("a.epub",null);
	}

}
