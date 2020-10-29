package com.macro.mall.mapper;

import com.macro.mall.example.YxxProductQaExample;
import com.macro.mall.model.YxxProductQa;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxProductQaMapper {
    long countByExample(YxxProductQaExample example);

    int deleteByExample(YxxProductQaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxProductQa record);

    int insertSelective(@Param("record") YxxProductQa record, @Param("selective") YxxProductQa.Column ... selective);

    YxxProductQa selectOneByExample(YxxProductQaExample example);

    YxxProductQa selectOneByExampleSelective(@Param("example") YxxProductQaExample example, @Param("selective") YxxProductQa.Column ... selective);

    List<YxxProductQa> selectByExampleSelective(@Param("example") YxxProductQaExample example, @Param("selective") YxxProductQa.Column ... selective);

    List<YxxProductQa> selectByExample(YxxProductQaExample example);

    YxxProductQa selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxProductQa.Column ... selective);

    YxxProductQa selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxProductQa record, @Param("example") YxxProductQaExample example, @Param("selective") YxxProductQa.Column ... selective);

    int updateByExample(@Param("record") YxxProductQa record, @Param("example") YxxProductQaExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxProductQa record, @Param("selective") YxxProductQa.Column ... selective);

    int updateByPrimaryKey(YxxProductQa record);

    int batchInsert(@Param("list") List<YxxProductQa> list);

    int batchInsertSelective(@Param("list") List<YxxProductQa> list, @Param("selective") YxxProductQa.Column ... selective);
}