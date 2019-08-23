package com.bitcamp.services;
import com.bitcamp.domains.MemberBean;
/**
 * 요구사항(기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지에서 회원정보보기
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 로그인
 * ***************
 * <관리자기능>
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색 (동명이인 처리)
 * 4. 전체 회원수
 * */
/*****************************************************************
 * 사용자 기능
 ******************************************************************/
public class MemberService {
	private MemberBean[] members;
	private int count;
	
	public MemberService() {
		members = new MemberBean[3];
		count = 0;
	}
	/**
	 * 1.회원가입
	 **/
	public String join(MemberBean param) {
		String msg = "회원가입 성공";
		members[count] = param;
		count++;
		return msg;
	}
	/**
	 * 2.마이페이지에서 회원정보보기*/
	public String getMyPage(MemberBean param) {
		return param.toString();
	}
	/**
	 * 3.비번 수정(옛날비번, 신규비번 입력받아서 옛날비번을 체크 후 일치하면 신규비번으로 변경)
	 * 비번변경후 로그인을 실행해서 새로바뀐 비번이 로그인성공, 옛날비번은 로그인 실패.
	 * */
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
		return msg;
	}
	/**
	 * 4. 회원탈퇴*/
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
	/**
	 * 5. 아이디 체크
	 * */
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
	/**
	 * 6. 로그인(파라미터로 ID,PW만 입력받은 상태)
	 * */
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
	/*****************************************************************
	 * 관리자 기능
	 ******************************************************************/
	/**
	 * 1. 회원목록*/
	public String list() {
		String msg = "";
		for(int i=0; i<count; i++) {
			msg += members[i].toString()+", \n";
	}
		return msg;
	}
	/**
	 * 2. 아이디검색*/
	public MemberBean findByID(String ID) {
		MemberBean member = new MemberBean();
		for(int i = 0; i<count; i++) {
			if(ID.equals(members[i].getID()) ) {
				member = members[i];
			}				
	}
		return member;
	}
	/**
	 * 3. 이름검색*/
	public MemberBean[] findByName(String name) {
		int j = 0;
		for(int i = 0; i<count; i++) {
			if(name.equals(this.members[i].getName())) {
				j++;
			}
		}
		MemberBean[] members = new MemberBean[j];
		for(int i = 0; i<count; i++) {
			j = 0;
			if(name.equals(this.members[i].getName())) {
				members[j] = this.members[i];
				j++;
				if(members.length == j) {
				break;
				}
			}
			members[i] = this.members[i];
	}
		return members;
	}
	public String countAll() {
		return "총 회원 수 : " + count;
	}
}