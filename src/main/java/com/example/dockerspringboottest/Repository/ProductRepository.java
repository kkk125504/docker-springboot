package com.example.dockerspringboottest.Repository;

import com.example.dockerspringboottest.Vo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductRepository {
     @Select("""
			 <script>
			 	SELECT P.id, P.itemName, P.price,P.register_date , C.companyName FROM product AS P
			 	LEFT JOIN company AS C
			 	ON P.companyId = C.id
			 </script>				
			 	""")
    public List<Product> getProductList();
}
