package main;

import java.util.ArrayList;

public interface Part {
	public static int getCod(){
		return 0;
	}
	public static String getNome(){
		return "";
	}
	public static String getDesc(){
		return "";
	}
	public static String getLocalArmazenado(){
		return "";
	}
	public static ArrayList<Part> getSubComp(){
		return null;
	}
	public static int getQtdSubComp(){
		return 0;
	}
	public static String primitivaOuAgregada(){
		return "";
	}
}
