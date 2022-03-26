package com.fancybulbfinish.fancybulb.Repository;




import com.fancybulbfinish.fancybulb.Model.CadastroModeladm;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface fancybulbrepoadm extends CrudRepository<CadastroModeladm, Integer>{
    
    @Query(value="select * from admin where email = :email and senha = :senha", nativeQuery = true)
    public CadastroModeladm Loginadm(String email, String senha);

}
