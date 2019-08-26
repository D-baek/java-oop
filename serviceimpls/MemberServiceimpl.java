package com.bitcamp.serviceimpls;

import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;

public class MemberServiceimpl implements MemberService{
	private MemberBean[] members;
	private int count;
	
	private 
	
	@Override
	public String join(MemberBean param) {
		String msg = "회원가입 성공";
		members[count] = param;
		count++;
		return msg;
	}

	@Override
	public String getMyPage(MemberBean param) {
			return param.toString();
	}

	@Override
	public String changePassword(MemberBean param) {
		String msg = "비밀번호가 변경되었습니다.";
		String id = param.getID();
		String pw = param.getPwd();
		String [] pws = pw.split(",");
		String oldPwd = pws[0];
		String newPwd = pws[1];
		for(int i = 0; i<count; i++) {
				if(param.getID().equals(members[i].getID())
						&& param.getPwd().equals(members[i].getPwd())) {
					members[i].setPwd(newPwd);
					break;
						
					}
		}
	}

	@Override
	public String Withdrawal(MemberBean param) {
		String msg = "탈퇴가 완료되었습니다.";
		String id = param.getID();
		String pw = param.getPwd();
		for(int i = 0; i<count; i++) {
			if(id.equals(members[i].getID())
					&& pw.equals(members[i].getPwd())) {
				members[i] = members[i-1];
					break;
			}
				}
		return msg;
	}

	@Override
	public String existID(String ID) {
		String msg = "가입가능한 아이디 입니다.";
		for(int i=0; i<count; i++) {
			if(ID.equals(members[i].getID())) {
				msg = "이미 존재하는 아이디";
				break;
			}
		}
		return msg;
	}

	@Override
	public String login(MemberBean param) {
		String msg = "로그인 실패";
		for(int i= 0; i<count; i++) {
			if(param.getID().equals(members[i].getID())
					&& param.getPwd().equals(members[i].getPwd())) {
				msg = "로그인 성공";
				break;
			}
		}
		return msg;
	}

}
