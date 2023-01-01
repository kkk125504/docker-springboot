package com.example.dockerspringboottest.Repository;

import com.example.dockerspringboottest.Vo.Buyer;
import com.example.dockerspringboottest.Vo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BuyerRepository {
     @Select("""
			 <script>
			 	SELECT id, buyerName, 
			 	CONCAT(SUBSTRING(phoneNumber,1,10),'**',SUBSTRING(phoneNumber,13,1)) AS phoneNumber 
			 	FROM buyer;
			 </script>				
			 	""")
    public List<Buyer> getBuyerList();

}
