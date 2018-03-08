package com.spring.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.veiculos.model.Veiculo;
import com.spring.veiculos.repository.VeiculoJPA;

/**
 *
 * - Classe controle responsável por gerenciar os veículos
 * @author Andre
 *
 */
@Controller
public class VeiculosController {
	
	@Autowired
	private VeiculoJPA veiculoJPA;
	
	/**
	 * 
	 * - Lista todos os veiculos
	 * @return retorna uma lista de veículos contida em um objeto ModelAndView que encapsula o JSP
	 * 
	 */
	@GetMapping
	@RequestMapping("/veiculos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("Veiculos");
		modelAndView.addObject("veiculos", veiculoJPA.listAll());
		modelAndView.addObject(new Veiculo());
		return modelAndView;
	}
	
	/**
	 * 
	 * - Inclui um veículo no banco de dados
	 * @param - Passa um objeto do tipo veículo como parâmetro 
	 * @return - Retorna uma requisição para o browser acessar novamente a pagina principal e listar os veiculos
	 * 
	 */
	@RequestMapping(value = "/processarForm", method = RequestMethod.POST, params = { "adicionar" })
	public String incluir(@ModelAttribute Veiculo veiculo) {
		veiculoJPA.save(veiculo);
		return "redirect:/veiculos";
	}
	
	/**
	 * 
	 * - Altera um veículo do banco de dados
	 * @param - Passa um objeto do tipo como parâmetro 
	 * @return - Retorna uma requisição para o browser acessar novamente a pagina principal e listar os veiculos
	 * 
	 */
	@RequestMapping(value = "/processarForm", method = RequestMethod.POST, params = { "alterar" })
	public String alterar(@ModelAttribute Veiculo veiculo) {
		veiculoJPA.update(veiculo.getModelo(), 
						  veiculo.getMarca(),
						  veiculo.getTipo(), 
						  veiculo.getCor(), 
						  veiculo.getId());
		return "redirect:/veiculos";
	}

	/**
	 * 
	 * - Exclui um veículo do banco de dados
	 * @param - Passa um objeto do tipo veículo como parâmetro 
	 * @return - Retorna uma requisição para o browser acessar novamente a pagina principal e listar os veiculos
	 * 
	 */
	@RequestMapping(value = "/processarForm", method = RequestMethod.POST, params = { "excluir" })
	public String excluir(@ModelAttribute Veiculo veiculo) {
		veiculoJPA.delete(veiculo);
		return "redirect:/veiculos";
	}
}
