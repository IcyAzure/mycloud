package com.luyuheng.mycloud.pojo;


import java.util.Date;

public class Equip{

	private Long id;
	
	private Date createDate;
	
	private Long createUserId;
	
	private String enterpriseId;
	
	private Date lastUpdateDate;
	
	private Long lastUpdateUserId;
	
	private Long channelId;
	
	private String equipName;
	
	private String equipSN;
	
	private String equipType;

	private Protoss protoss;

    public Protoss getProtoss() {
        return protoss;
    }

    public void setProtoss(Protoss protoss) {
        this.protoss = protoss;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(Long lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getEquipSN() {
		return equipSN;
	}

	public void setEquipSN(String equipSN) {
		this.equipSN = equipSN;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

    @Override
    public String toString() {
        return "Equip{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", createUserId=" + createUserId +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdateUserId=" + lastUpdateUserId +
                ", channelId=" + channelId +
                ", equipName='" + equipName + '\'' +
                ", equipSN='" + equipSN + '\'' +
                ", equipType='" + equipType + '\'' +
                ", protoss=" + protoss +
                '}';
    }
}
