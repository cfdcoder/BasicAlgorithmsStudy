package library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/******************************************************************************
 *  Compilation:  javac StdIn.java
 *  Execution:    java StdIn   (interactive test of basic functionality)
 *  Dependencies: none
 *
 *  Reads in data of various types from standard input.
 *
 ******************************************************************************/

public class StdIn {

	private static final String CHARSET_NAME="UTF-8";
	private static final Locale LOCATION=Locale.US;
	private static final Pattern WHITESPACE_PATTERN=Pattern.compile("\\p{javaWhitespace}+");
	private static final Pattern EMPTY_PATTERN=Pattern.compile("");
	private static final Pattern EVERYTHNG_PATTERN=Pattern.compile("\\A");
	
	private static Scanner scanner;
	private StdIn(){}
	
	public static boolean isTmpty(){
		return !scanner.hasNext();
	}
	
	public static boolean hasNext(){
		return scanner.hasNextLine();
	}
	
	public static boolean hasNextChar(){
		scanner.useDelimiter(EMPTY_PATTERN);
		boolean result=scanner.hasNext();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}
	
	public static String readLine(){
		String line;
		try{
			line=scanner.nextLine();
		}catch(NoSuchElementException e){
			line=null;
		}
		return line;
	}
	
	public static char readChar(){
		scanner.useDelimiter(EMPTY_PATTERN);
		String ch=scanner.next();
		assert ch.length()==1 : "Internal error: (Std)In.readChar()!";
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return ch.charAt(0);
	}
	
	public static String readAll(){
		if(!scanner.hasNextLine())
			return "";
		
		String result=scanner.useDelimiter(EVERYTHNG_PATTERN).next();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}
	
	public static String readString(){
		return scanner.next();
	}
	
	public static int readInt(){
		return scanner.nextInt();
	}
	
	public static double readDouble(){
		return scanner.nextDouble();
	}
	
	public static float readFloat(){
		return scanner.nextFloat();
	}
	
	public static long readLong(){
		return scanner.nextLong();
	}
	
	public static short readShort(){
		return scanner.nextShort();
	}
	
	public static byte readByte(){
		return scanner.nextByte();
	}
	
	public static boolean readBoolean(){
		String s=readString();
		if(s.equalsIgnoreCase("true")) return true;
		if(s.equalsIgnoreCase("false")) return false;
		if(s.equalsIgnoreCase("1")) return true;
		if(s.equalsIgnoreCase("0")) return false;
		throw new InputMismatchException();
	}
	
	public static String[] readAllStrings(){
		String[] tokens=WHITESPACE_PATTERN.split(readAll());
		//check leading white space
		if(tokens.length==0||tokens[0].length()>0)
			return tokens;
		//don't include first token
		String[] decapiTokens=new String[tokens.length-1];
		for(int i=0;i<tokens.length-1;i++)
			decapiTokens[i]=tokens[i+1];
		return decapiTokens;
	}
	
	public static String[] readAllLines(){
		ArrayList<String> lines=new ArrayList<String>();
		while(hasNextLine()){
			lines.add(readLine());
		}
		return lines.toArray(new String[0]);
	}
	
	public static int[] readAllInts() {
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Integer.parseInt(fields[i]);
        return vals;
    }

	public static double[] readAllDoubles() {
        String[] fields = readAllStrings();
        double[] vals = new double[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Double.parseDouble(fields[i]);
        return vals;
    }
	
	static {
        resync();
    }
	
	private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
    }
	
	private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
        StdIn.scanner.useLocale(LOCATION);
    }
	
	public static int[] readInts() {
        return readAllInts();
    }
	
	public static double[] readDoubles() {
        return readAllDoubles();
    }
	
	public static String[] readStrings() {
        return readAllStrings();
    }
	
	
	
	
	 public static boolean hasNextLine() {
	        return scanner.hasNextLine();
	    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.print("Type a string: ");
        String s = StdIn.readString();
        StdOut.println("Your string was: " + s);
        StdOut.println();

        StdOut.print("Type an int: ");
        int a = StdIn.readInt();
        StdOut.println("Your int was: " + a);
        StdOut.println();

        StdOut.print("Type a boolean: ");
        boolean b = StdIn.readBoolean();
        StdOut.println("Your boolean was: " + b);
        StdOut.println();

        StdOut.print("Type a double: ");
        double c = StdIn.readDouble();
        StdOut.println("Your double was: " + c);
        StdOut.println();
	}

}

/******************************************************************************
 *  Copyright 2002-2015, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/


