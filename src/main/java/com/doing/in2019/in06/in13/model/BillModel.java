package com.doing.in2019.in06.in13.model;

/**
 * 账单模型
 */
public class BillModel {
	
	private String id;
	private String allinpay_order_no;	// 订单编号 - 通联订单号
	private String transfer_type;		// 订单类型
	private String trans_amount;		// 交易金额
	private String fee;					// 充值业务费用 - 手续费
	private String create_time;			// 创建时间 - 交易时间
	private String biz_order_no;		// 有容指定的订单号 - 商户订单编号
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAllinpay_order_no() {
		return allinpay_order_no;
	}
	public void setAllinpay_order_no(String allinpay_order_no) {
		this.allinpay_order_no = allinpay_order_no;
	}
	public String getTransfer_type() {
		return transfer_type;
	}
	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}
	public String getTrans_amount() {
		return trans_amount;
	}
	public void setTrans_amount(String trans_amount) {
		this.trans_amount = trans_amount;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getBiz_order_no() {
		return biz_order_no;
	}
	public void setBiz_order_no(String biz_order_no) {
		this.biz_order_no = biz_order_no;
	}
}
