package com.cointer.pojo.tikPay;



import java.io.Serializable;

//@Data
//@ApiModel
public class IssueOrderPo implements Serializable {

   // @ApiModelProperty(value = "充值或者提现金额")
    private String amount;
    //@ApiModelProperty(value = "第三方交易编号")
    private String thirdOrderNumber;
    // @ApiModelProperty(value = "第三方用户ID")
    private String thirdUserId;

    // @ApiModelProperty(value = "支付方式信息")
    private IssuePayPo issuePayPo;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getThirdOrderNumber() {
        return thirdOrderNumber;
    }

    public void setThirdOrderNumber(String thirdOrderNumber) {
        this.thirdOrderNumber = thirdOrderNumber;
    }

    public String getThirdUserId() {
        return thirdUserId;
    }

    public void setThirdUserId(String thirdUserId) {
        this.thirdUserId = thirdUserId;
    }

    public IssuePayPo getIssuePayPo() {
        return issuePayPo;
    }

    public void setIssuePayPo(IssuePayPo issuePayPo) {
        this.issuePayPo = issuePayPo;
    }
}
