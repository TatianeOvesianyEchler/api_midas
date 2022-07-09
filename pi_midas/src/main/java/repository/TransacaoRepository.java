package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pi_midas.entity.Transacoes;



public interface TransacaoRepository extends JpaRepository <Transacoes,Long>{

}
