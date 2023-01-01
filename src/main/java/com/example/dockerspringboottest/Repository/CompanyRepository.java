package com.example.dockerspringboottest.Repository;

import com.example.dockerspringboottest.Vo.Company;
import com.example.dockerspringboottest.Vo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompanyRepository {
     @Select("""
		<script>
			SELECT * FROM company
		</script>				
			""")
    public List<Company> getCompanyList();
}
