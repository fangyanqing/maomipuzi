package com.maomipuzi.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-18 17:54
 **/
@ApiModel(description = "规格参数表",value = "Spec")
@Table(name="spec")
public class Spec implements Serializable {

    @ApiModelProperty(value = "规格ID", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;//规格ID

    @ApiModelProperty(value = "规格参数名称", required = false)
    @Column(name = "spec_name")
    private String specName;//规格参数名称

    @ApiModelProperty(value = "规格参数选项", required = false)
    @Column(name = "options")
    private String options;//规格参数选项

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
