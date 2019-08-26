package com.bitcamp.domains;
/*
 * 생산자명 company
 * 통화내용 call
 * 수신자 receiver
 * 문자 text
 * 전화기형태 KIND ->상수: 셀룰러폰
 * 나는 {삼성}에서 만든 {셀룰러폰}를 사용해서 {길동}이에게 {안녕}이라고 문자했다
 * */


public class CelPhoneBean extends PhoneBean{
	public final static String KIND = "셀룰러폰";
	private String text;
	
	
	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}
	public String toString() {
		return String.format("나는 %s에서 만든 %s를 사용해서 %s이에게 %s이라고 문자했다"
												, super.getCompany(), KIND, super.getReceiver(), text);
															/*super는 생략가능*/
	}
}
