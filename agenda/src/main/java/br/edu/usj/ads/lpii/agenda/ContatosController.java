package br.edu.usj.ads.lpii.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contato")
public class ContatosController {

    @Autowired
    ContatoRepository contatoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Contato> lista = new ArrayList<>();
        contatoRepository.findAll().forEach(lista::add);

        ModelAndView modelAndView = new ModelAndView("listaContatos");
        modelAndView.addObject("contatos", lista);

        return modelAndView;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView pesquisarPorId(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("mostraContato");

        if (contatoRepository.findById(id).isPresent()) {
            modelAndView.addObject("contato", contatoRepository.findById(id).get());
        }

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String adiciona(@RequestParam String nome, @RequestParam String cidade)
    {
        Contato c = new Contato();
        c.setNome(nome);
        c.setCidade(cidade);

        Contato contatoSalvo = contatoRepository.save(c);

        return "redirect:/contato/" + contatoSalvo.getId();
    }

    @RequestMapping(path="/{id}/delete", method = RequestMethod.GET)
    public String apaga(@PathVariable Long id) {
        contatoRepository.deleteById(id);
        return "redirect:/contato";
    }

    @RequestMapping(path="/delete", method = RequestMethod.POST)
    public ModelAndView apagaDadosForm(@RequestParam Long id) {
        contatoRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/contato");
        return modelAndView;
    }

    @RequestMapping(path="/deleteCombo", method = RequestMethod.GET)
    public ModelAndView apagaMostraFormCombo() {
        List<Contato> lista = new ArrayList<>();
        contatoRepository.findAll().forEach(lista::add);

        ModelAndView modelAndView = new ModelAndView("apagaContatoCombo");
        modelAndView.addObject("contatos", lista);

        return modelAndView;
    }


    @RequestMapping(path = "/{id}/update", method = RequestMethod.GET)
    public ModelAndView editarMostraForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("editaContato");

        if (contatoRepository.findById(id).isPresent()) {
            modelAndView.addObject("contato", contatoRepository.findById(id).get());
        }

        return modelAndView;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ModelAndView editar(@RequestParam Long id, @RequestParam String nome, @RequestParam String cidade) {
        Contato c = new Contato();
        c.setId(id);
        c.setNome(nome);
        c.setCidade(cidade);

        Contato contatoSalvo = contatoRepository.save(c);

        ModelAndView modelAndView = new ModelAndView("redirect:/contato/" + contatoSalvo.getId());

        return modelAndView;
    }

}
