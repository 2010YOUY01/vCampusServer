package vcampus.dao;

import java.sql.Date;

import vcampus.vo.PersonInfo;
import vcampus.vo.User;

public class InfoDAO {
	//ͨ��username����һ���û�����ϸ����
	//User �� username��PersonInfo��username����ѧ�ţ�Ψһȷ��һ���û����
	public PersonInfo getPersonInfo(String username) {
		Date birthday = new Date(1997, 8, 18);
		PersonInfo personInfo = new PersonInfo(username, 
				"����", 19, PersonInfo.GENDER.MAlE ,PersonInfo.SCHOOL.��ͨ 
				,birthday , "�����Ͼ�","here");
		return personInfo;
	}
	
	//�޸��û���Ϣ
	//����personInfoȷ��һ���û��Ƿ����
	//��������ڣ�����false
	//������ڣ���personInfo����ԭ����PersonInfo����ϸ����
	public boolean changePersonInfo(PersonInfo personInfo) {
		boolean changeSucceedFlag = false;
		
		
		return changeSucceedFlag;
	}
}
