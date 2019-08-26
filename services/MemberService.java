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
public interface MemberService {

	public String join(MemberBean param) ;
	public String getMyPage(MemberBean param);
	public String changePassword(MemberBean param);
	public String Withdrawal(MemberBean param);
	public String existID(String ID);
	public String login(MemberBean param);
}

