package tech.codoverse;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExceptionApp {
	
	void main() {
		startForSuppressedExcep();
	}
	
	void startForSuppressedExcep() {
		try(MyResource resource = new MyResource()) {
			
			resource.read();
			
		} catch(Exception e) {
			e.printStackTrace();
			IO.println("Main Exception: " + e.getMessage());
			
			Throwable[] suppressed = e.getSuppressed();
			for(Throwable t : suppressed) {
				IO.println("Suppressed Exception: " + t.getMessage());
			}
		}
	}
	
	void readInputWithConsole() {
		Console cs = System.console();
		
		String strInput = cs.readLine("Console string: ");
		IO.println(strInput);
		
		char[] strPass = cs.readPassword("Console password: ");
		IO.println(String.valueOf(strPass));
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void readInputWithIO() {
		String input = IO.readln("IO readln: ");
		IO.println(input);
	}
	
	void readInputWithBR() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try(br) {
			IO.print("BufferedReader: ");
			int input = Integer.parseInt(br.readLine());
			IO.println(input);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void readInputWithScanner() {
		try(Scanner sc = new Scanner(System.in)) {
			IO.print("Scanner: ");
			String input = sc.nextLine();
			IO.println(input);
		}
	}
	
	void startForTryWithResource() {
		
		try(Connection conn = DriverManager.getConnection("");
				Statement stmt = conn.createStatement()) {
			
			stmt.execute("");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	void startForFinally() {
		try {
			System.exit(0);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			IO.println("finally block.");
		}
	}
	
	void startForMultiHandler() {
		try {
			
		} catch(ArrayIndexOutOfBoundsException e) {
			
		} catch(StringIndexOutOfBoundsException e) {
			
		} catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	void startForMultiCatch() {
		try {
			
		} catch (IndexOutOfBoundsException | NullPointerException | ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}
	
	void startForThrow(String str) throws IllegalAccessException {
		if(str.isBlank()) {
			throw new IllegalAccessException("Illegal access");
		}
	}
	
	void startForChecked() {
		try {
			
			DriverManager.getConnection("");
			
		} catch(SQLException e) {
			IO.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	void startForCallstack() {
		var cs = new ExceptionCallStack();
		IO.println("started");
		cs.one();
		IO.println("Ended");
	}
	
	void startForException() {
		IO.println("Program started.");
		
		try {
			IO.println(new String[]{}[0]); // business logic that can be error
		} catch(Exception e) {
			e.printStackTrace(); // error handling logic
		}
		
		IO.println("Program is terminated.");
	}

}
