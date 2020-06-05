package com.maomipuzi.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-06-05 20:14
 **/
@ApiModel(description = "AddressInfo",value = "AddressInfo")
@Table(name="address_info")
public class AddressInfo implements Serializable {

    @ApiModelProperty(value = "收货地址详情ID",required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_info_id")
    private Integer addressInfoId;//收货地址详情ID

    @ApiModelProperty(value = "收货地址ID",required = false)
    @Column(name = "address_id")
    private Integer addressId;//收货地址ID

    @ApiModelProperty(value = "收货人所在省",required = false)
    @Column(name = "province")
    private String province;//收货人所在省

    @ApiModelProperty(value = "收货人所在市",required = false)
    @Column(name = "city")
    private String city;//收货人所在市

    @ApiModelProperty(value = "收货人所在区",required = false)
    @Column(name = "district")
    private String district;//收货人所在区

    @ApiModelProperty(value = "收货人详细地址",required = false)
    @Column(name = "detail_address")
    private String detailAddress;//收货人详细地址

    @ApiModelProperty(value = "是否为默认地址 0-默认地址 1-非默认地址",required = false)
    @Column(name = "address_type")
    private Integer addressType;//是否为默认地址 0-默认地址 1-非默认地址

    @ApiModelProperty(value = "收货人姓名",required = false)
    @Column(name = "consignee")
    private String consignee;//收货人姓名

    @ApiModelProperty(value = "收货人手机号码",required = false)
    @Column(name = "phone")
    private String phone;//收货人手机号码



    //get方法
    public Integer getAddressInfoId() {
        return addressInfoId;
    }

    //set方法
    public void setAddressInfoId(Integer addressInfoId) {
        this.addressInfoId = addressInfoId;
    }
    //get方法
    public Integer getAddressId() {
        return addressId;
    }

    //set方法
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    //get方法
    public String getProvince() {
        return province;
    }

    //set方法
    public void setProvince(String province) {
        this.province = province;
    }
    //get方法
    public String getCity() {
        return city;
    }

    //set方法
    public void setCity(String city) {
        this.city = city;
    }
    //get方法
    public String getDistrict() {
        return district;
    }

    //set方法
    public void setDistrict(String district) {
        this.district = district;
    }
    //get方法
    public String getDetailAddress() {
        return detailAddress;
    }

    //set方法
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
    //get方法
    public Integer getAddressType() {
        return addressType;
    }

    //set方法
    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }
    //get方法
    public String getConsignee() {
        return consignee;
    }

    //set方法
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    //get方法
    public String getPhone() {
        return phone;
    }

    //set方法
    public void setPhone(String phone) {
        this.phone = phone;
    }


}

