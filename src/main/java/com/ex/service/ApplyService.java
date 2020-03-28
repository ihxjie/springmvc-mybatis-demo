package com.ex.service;

import com.ex.model.Apply;

import java.util.List;

public interface ApplyService {
    List<Apply> getApplyList();//获取全部信息

    //boolean deleteByPrimaryKey(Integer applyId)

    boolean updateApply(Apply apply);//修改

    List<Apply> queryExcelInfo();//导表

    boolean delApplyById(Integer applyId);//批量删除

    List<Apply> selectId(Integer applyId);

    Apply selectApplyId(Integer applyId);//
}
