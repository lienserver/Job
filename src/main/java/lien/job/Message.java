package lien.job;

import org.bukkit.OfflinePlayer;

public enum Message 
{
	CANNOT_GIVE_JOB("직업으로 전직하기위한 조건을 완수하지 않았습니다");
	private String localizedMessage;
	private Message(String mesgg) 
	{
		this.localizedMessage = mesgg;
	}

	public String toString(OfflinePlayer p) {
		return toString();
	}
	public String toString()
	{
		return localizedMessage;
	}
}
