package com.spring.veiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.spring.veiculos.model.Veiculo;

/**
 * 
 * - Interface JPA implementada pelo Spring Data com alguns métodos a mais a serem implementados pelo Spring Data
 * @author Andre
 *
 */
public interface VeiculoJPA extends JpaRepository<Veiculo, Long> {
	
	/**
	 * - Metodo que realiza a atualização de um veículo no banco de dados
	 * @param modelo - modelo do carro
	 * @param marca - marca do carro
	 * @param tipo - tipo do carro
	 * @param cor - cor do carro
	 * @param id - identificador do carro
	 * 
	 */
	@Modifying
	@Query(value = "UPDATE veiculo SET modelo = :modelo,marca = :marca,tipo = :tipo,cor = :cor WHERE id = :id",
	        nativeQuery=true)
	@Transactional
	public void update(@Param("modelo") String modelo, 
					   @Param("marca") String marca, 
					   @Param("tipo") String tipo,
					   @Param("cor") String cor,
					   @Param("id") Long id);
	
	/**
	 * 
	 * - Metodo responsável por listar todos os veículos do banco de dados com todos os atributos
	 * @return - retorna uma lista de veículos com todos seus atributos
	 */
	@Query(value = "SELECT * FROM veiculo",
	        nativeQuery=true)
	public List<Veiculo> listAll();
}
