package com.bitcamp.controllers;
import javax.swing.JOptionPane;
public class AdminController {

	public static void main(String[] args) {
		while(true) {
			switch(JOptionPane.showInputDialog("0. 종료\n"
					+ "1.  회원목록\n"
					+ "2. 아이디검색\n"
					+ "3. 이름검색\n"
					)) {
			case"0" :
				JOptionPane.showMessageDialog(null, "종료");
				
				return;
				case"1" :
				
				
			}
		}
	}

}
