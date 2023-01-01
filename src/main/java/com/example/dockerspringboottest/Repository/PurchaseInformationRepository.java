package com.example.dockerspringboottest.Repository;

import com.example.dockerspringboottest.Vo.Product;
import com.example.dockerspringboottest.Vo.PurchaseInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PurchaseInformationRepository {
     @Select("""
			 <script>			 	
			 SELECT P.itemName, P.price ,B.buyerName ,`PI`.purchaseDate,`PI`.id FROM purchaseInformation AS `PI`
			 LEFT JOIN product AS P
			 ON `PI`.productId = P.id
			 LEFT JOIN buyer AS B
			 ON `PI`.buyerId = B.id;
			 </script>				
			 	""")
    public List<PurchaseInformation> getPurchaseInformationList();
}
