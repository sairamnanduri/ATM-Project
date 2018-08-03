public class Account{

	private String username;
	private String password;
	private String name;
	private double balance;
	private boolean active;

	public Account()
	{
		username = null;
		password = null;
		name = null;
		balance = 0;
		active = false;
	}
	public Account(String tempUsername,String tempPassword, String tempName)
	{
		setUsername(tempUsername);
		setPassword(tempPassword);
		setName(tempName);
		balance = 0;
		active = true;
	}
	public Account(String tempUsername,String tempPassword)
	{
		setUsername(tempUsername);
		setPassword(tempPassword);
		this.name = null;
		balance = 0;
		active = true;
	}
	public Account(String tempUsername, String tempPassword, String tempName, double tempBalance, boolean tempActive)
	{
		setUsername(tempUsername);
		setPassword(tempPassword);
		setName(tempName);
		setBalance(tempBalance);
		setActive(tempActive);
	}
	public Account(String tempUsername, String tempName, double tempBalance, boolean tempActive)
	{
		setUsername(tempUsername);
		password = null;
		setName(tempName);
		setBalance(tempBalance);
		setActive(tempActive);
		
	}
	public void setUsername(String tempUsername)
	{
		username = tempUsername;
	}
	public void setPassword(String tempPassword)
	{
		password = tempPassword;
	}
	public void setName(String tempName)
	{
		name = tempName;
	}
	public void setBalance(double tempBalance)
	{
		balance = tempBalance;
	}
	public void setActive(boolean tempActive)
	{
		active = tempActive;
	}
	 public String getusername()
	{
		return username;
	}
	public String getpassword()
	{
		return password;
	}
	public String getname()
	{
		return name;
	}
	public double getbalance()
	{
		return balance;
	}
	public boolean getactive()
	{
		return active;
}

}