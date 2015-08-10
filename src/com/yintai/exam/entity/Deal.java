package com.yintai.exam.entity;

import java.util.Date;


public class Deal {
	
	private String dealId;//����id
	private Date createTime;//����ʱ��
	private DealStatus status;//״̬
	private DealType type;//����
	private Double amount;//���
	private DealCurrency currency;//����
	private Customer customer;//�ͻ�
	
	public String getId() {
		return dealId;
	}
	public void setId(String id) {
		this.dealId = id;
	}
	
	public DealStatus getStatus() {
		return status;
	}
	public void setStatus(DealStatus status) {
		this.status = status;
	}
	public DealType getType() {
		return type;
	}
	public void setType(DealType type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public DealCurrency getCurrency() {
		return currency;
	}
	public void setCurrency(DealCurrency currency) {
		this.currency = currency;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer() ;
        sb.append("id:").append(this.dealId) ;
        sb.append(" createTime:").append(this.createTime.toString()) ;
        sb.append(" status:").append(this.status) ;
        sb.append(" type:").append(this.type) ;
        sb.append(" amount:").append(this.amount) ;
        sb.append(" currency:").append(this.currency) ;
        sb.append(" customer:").append(this.customer.toString()) ;
        return sb.toString();
	}
	
}
