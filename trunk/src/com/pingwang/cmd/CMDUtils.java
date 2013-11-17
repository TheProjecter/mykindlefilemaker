package com.pingwang.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMDUtils {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
//		try {
//			Process p = Runtime.getRuntime().exec("a-command");
//			p.waitFor();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(
//					p.getInputStream()));
//			String line = reader.readLine();
//			while (line != null) {
//				System.out.println(line);
//				line = reader.readLine();
//			}
//
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		} catch (InterruptedException e2) {
//			e2.printStackTrace();   
//		}
//
//		System.out.println("Done");
		
		
		// Get runtime
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        // Start a new process: UNIX command ls
        java.lang.Process p;
		try {
			p = rt.exec("ls .");
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
		
		
		
		
//		// Create ProcessBuilder instance for UNIX command ls -l
//        java.lang.ProcessBuilder processBuilder = new java.lang.ProcessBuilder("ls", "-l");
//        // Create an environment (shell variables)
//        java.util.Map env = processBuilder.environment();
//        env.clear();
//        env.put("COLUMNS", "3"); // See manpage ls(1)
//        // You can change the working directory
//        processBuilder.directory(new java.io.File("/Users"));
//        // Start new process
//        try {
//			java.lang.Process p = processBuilder.start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
