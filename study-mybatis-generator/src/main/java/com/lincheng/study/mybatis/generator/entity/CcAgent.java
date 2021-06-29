package com.lincheng.study.mybatis.generator.entity;

import java.util.Date;

public class CcAgent {
    private Integer agentId;

    private String agentName;

    private Integer compId;

    private String compName;

    private Integer customeId;

    private String number;

    private String agentState;

    private String subAccountId;

    private String subToken;

    private Date dateCreated;

    private String voipAccount;

    private String voipPwd;

    private String createOperId;

    private Date createOperTime;

    private String updateOperId;

    private Date updateOperTime;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public Integer getCustomeId() {
        return customeId;
    }

    public void setCustomeId(Integer customeId) {
        this.customeId = customeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getAgentState() {
        return agentState;
    }

    public void setAgentState(String agentState) {
        this.agentState = agentState == null ? null : agentState.trim();
    }

    public String getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(String subAccountId) {
        this.subAccountId = subAccountId == null ? null : subAccountId.trim();
    }

    public String getSubToken() {
        return subToken;
    }

    public void setSubToken(String subToken) {
        this.subToken = subToken == null ? null : subToken.trim();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getVoipAccount() {
        return voipAccount;
    }

    public void setVoipAccount(String voipAccount) {
        this.voipAccount = voipAccount == null ? null : voipAccount.trim();
    }

    public String getVoipPwd() {
        return voipPwd;
    }

    public void setVoipPwd(String voipPwd) {
        this.voipPwd = voipPwd == null ? null : voipPwd.trim();
    }

    public String getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId == null ? null : createOperId.trim();
    }

    public Date getCreateOperTime() {
        return createOperTime;
    }

    public void setCreateOperTime(Date createOperTime) {
        this.createOperTime = createOperTime;
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId == null ? null : updateOperId.trim();
    }

    public Date getUpdateOperTime() {
        return updateOperTime;
    }

    public void setUpdateOperTime(Date updateOperTime) {
        this.updateOperTime = updateOperTime;
    }
}