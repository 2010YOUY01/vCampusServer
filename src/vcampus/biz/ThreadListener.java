package vcampus.biz;

public interface ThreadListener {
	public void Login();
	public void Logout();
	public void threadEnd(int id);
	public void displayLog(String log);
}
