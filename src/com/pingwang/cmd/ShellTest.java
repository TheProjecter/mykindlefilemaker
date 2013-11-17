package com.pingwang.cmd;

public class ShellTest {
    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException {
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        java.lang.Process p = rt.exec("open .");
        p.waitFor();
        System.out.println("Process exited with code = " + p.exitValue());
        // Get process' input: its OutputStream
        java.io.OutputStream os = p.getOutputStream();
        os.write("my input".getBytes());
        os.close();
    }
}