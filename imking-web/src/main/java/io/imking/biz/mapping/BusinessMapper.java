package io.imking.biz.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import io.imking.biz.domain.Business;

public interface BusinessMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table tc_business
	 *
	 * @mbg.generated Wed Jan 17 21:46:14 CST 2018
	 */
	@Delete({ "delete from tc_business", "where id = #{id,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table tc_business
	 *
	 * @mbg.generated Wed Jan 17 21:46:14 CST 2018
	 */
	@Insert({ "insert into tc_business (id, business_name, ", "state, create_time)",
			"values (#{id,jdbcType=BIGINT}, #{businessName,jdbcType=VARCHAR}, ",
			"#{state,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP})" })
	int insert(Business record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table tc_business
	 *
	 * @mbg.generated Wed Jan 17 21:46:14 CST 2018
	 */
	@InsertProvider(type = BusinessSqlProvider.class, method = "insertSelective")
	int insertSelective(Business record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table tc_business
	 *
	 * @mbg.generated Wed Jan 17 21:46:14 CST 2018
	 */
	@Select({ "select", "id, business_name, state, create_time", "from tc_business",
			"where id = #{id,jdbcType=BIGINT}" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "business_name", property = "businessName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	Business selectByPrimaryKey(Long id);
	
	@Select({ "select", "id, business_name, state, create_time", "from tc_business where state=1" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "business_name", property = "businessName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	List<Business> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table tc_business
	 *
	 * @mbg.generated Wed Jan 17 21:46:14 CST 2018
	 */
	@UpdateProvider(type = BusinessSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Business record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table tc_business
	 *
	 * @mbg.generated Wed Jan 17 21:46:14 CST 2018
	 */
	@Update({ "update tc_business", "set business_name = #{businessName,jdbcType=VARCHAR},",
			"state = #{state,jdbcType=TINYINT},", "create_time = #{createTime,jdbcType=TIMESTAMP}",
			"where id = #{id,jdbcType=BIGINT}" })
	int updateByPrimaryKey(Business record);
	
	@Select({ "select", "count(1)", "from tc_business where state=1 and business_name=#{businessName,jdbcType=VARCHAR}" })
	int selectBusinessNameExists(@Param("businessName") String businessName);
}