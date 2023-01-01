package com.example.dockerspringboottest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductRepository {
     @Select("""
		<script>
			SELECT * FROM product
		</script>				
			""")
    public List<Product> getProductList();
}
