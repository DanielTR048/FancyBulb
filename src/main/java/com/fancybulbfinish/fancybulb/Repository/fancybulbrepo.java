package com.fancybulbfinish.fancybulb.Repository;



import com.fancybulbfinish.fancybulb.Model.CadastroModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface fancybulbrepo extends CrudRepository<CadastroModel, Integer>{
    

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from clientes where id = :id", nativeQuery = true)
    public boolean exist(int id);
  
    @Query(value="select * from clientes where email = :email and senha = :senha", nativeQuery = true)
    public CadastroModel Login(String email, String senha);

   /*  @Query(value="select * from administradores where nome like %:nome% or email like %:email% ", nativeQuery = true)
	public ArrayList<CadastroModel> findAllByNomeEmail(@Param("nome") String nome, @Param("email") String email); */
}
