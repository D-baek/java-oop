package com.bitcamp.domains;

public class MemberBean {
		private String name, ID,pwd, ssn, bld;
		private double tall, weight ;
		
		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public void setID(String ID) {
			this.ID = ID;
		}
		public String getID() {
			return this.ID;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getPwd() {
			return this.pwd;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public String getSsn() {
			return this.ssn;
		}
		public void setBld(String bld) {
			this.bld = bld;
		}
		public String getBld() {
			return this.bld;
		}
		public void setTall(double tall) {
			this.tall = tall;
		}
		public double getTall() {
			return this.tall;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public double getWeight() {
			return this.weight;
		}
		public String toString() {
			// 이름, 아이디, 비번, 주민번호, 혈액형, 키, 몸무게
			return String.format("회원정보 : \n"
					+ "[이름 : %s]\n"
					+ "[아이디 : %s]\n"
					+ "[비밀번호 : %s]\n"
					+ "[주민번호 : %s]\n"
					+ "[혈액형 : %s형]\n"
					+ "[키 : %scm]\n"
					+ "[몸무게 : %skg]",
					name, ID, pwd, ssn, bld, tall, weight);
		}
}