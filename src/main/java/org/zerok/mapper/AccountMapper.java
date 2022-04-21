package org.zerok.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerok.vo.AccountVO;

@Mapper
public interface AccountMapper {

	void join(AccountVO accountVO);

}
