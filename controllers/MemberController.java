package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.serviceimpls.MemberServiceimpl;
import com.bitcamp.services.MemberService;
import com.bitcamp.domains.MemberBean;
public class MemberController {

	public static void main(String[] args) {
		MemberService service = new MemberServiceimpl();
		MemberBean member = null;
		String msg = "";
		String[] arr = null;
		String temp = "";
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료 \n"
					+ "1.회원가입\n"
					+ "2.마이페이지\n"
					+ "3.비번 수정\n"
					+ "4.회원탈퇴\n"
					+ "5.아이디체크\n"
					+ "6.로그인")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				
				return;
			case "1":
				temp = JOptionPane.showInputDialog("이름,아이디,비번,주민번호,혈액형,키,몸무게 ");
				System.out.println("****" + temp);
				arr = temp.split(",");
				member = new MemberBean();
				member.setName(arr[0]);
				member.setID(arr[1]);
				member.setPwd(arr[2]);
				member.setSsn(arr[3]);
				member.setBld(arr[4]);
				member.setTall(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				
				JOptionPane.showMessageDialog(null, service.join(member));
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.getMyPage(member));
				break;
			case "3":
				String tempID = JOptionPane.showInputDialog("아이디");
				String currPW = JOptionPane.showInputDialog("현재비번");
				String newPw = JOptionPane.showInputDialog("변경할비번");
				member = new MemberBean();
				member.setID(tempID);
				member.setPwd(currPW+","+newPw);
				JOptionPane.showMessageDialog(null, service.changePassword(member));
				break;
			case "4":
				String byeID = JOptionPane.showInputDialog("탈퇴하실 ID를 입력하세요.");
				String byePwd = JOptionPane.showInputDialog("탈퇴하실 Pwd를 입력하세요.");
				member = new MemberBean();
				member.setID(byeID);
				member.setPwd(byePwd);
				JOptionPane.showMessageDialog(null, service.Withdrawal(member));
				
				JOptionPane.showMessageDialog(null,  member);
				break;
			case "5":

				break;
			case "6":
				String loginValue = JOptionPane.showInputDialog("로그인 ID, PW"); 
				arr = loginValue.split(",");
				String loginId = arr[0];
				String loginPw = arr[1];
				member = new MemberBean();
				member.setPwd(loginPw);
				msg = service.login(member);
				JOptionPane.showMessageDialog(null, msg); 
				break;
			default:
				break;
			}
		}

	}

}