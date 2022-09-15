package lf.melo.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lf.melo.com.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
