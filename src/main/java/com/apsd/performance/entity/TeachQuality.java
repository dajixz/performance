package com.apsd.performance.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author 大稽
 * @date2019/1/511:22
 */
//教学质量表
@Data
@Entity
@Table(name = "tb_teach_quality")
public class TeachQuality {

    //自增id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //工号
    private String userId;
    //姓名
    private String userName;
    //联系电话
    private String tel;
    //所属单位
    private String subordinateUnit;
    //年度
    private String year;
    //项目
    private String project;
    //级别
    private String level;
    //获奖等级
    private String awardLevel;
    //获奖名称
    private String awardName;
    //获奖时间
    @Temporal(value = TemporalType.DATE)
    private Date awardTime;
    //获奖成员工号(以 逗号',' 分隔)
    private String awardUserId;
    @Transient
    private List<String> awardUserIdList;
    //获奖成员姓名(以 逗号',' 分隔)
    private String awardUserName;
    @Transient
    private List<String> awardUserNameList;
    //获奖成员所在学院(以 逗号',' 分隔)
    private String awardUserUnit;
    @Transient
    private List<String> awardUserUnitList;
    //获奖成员绩效占比
    private String awardInfo;
    //获奖文号
    private String awardNumber;
    //佐证材料 (以 逗号',' 分隔)
    private String supportingUrl;
    @Transient
    private List<String> supportingUrlList;
    //申报绩效
    private String report;
    //申报备注
    private String reportNotes;
    //审核绩效
    private double audit;
    //审核备注
    private String auditNotes;
    //状态
    private int state=0;


}
