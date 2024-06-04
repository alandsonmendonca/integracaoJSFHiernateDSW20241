package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.MoedaDao;
import entidade.Moeda;

@ManagedBean
public class MoedaBean {
	private Moeda moeda = new Moeda();
	private List<Moeda> lista = new ArrayList<Moeda>();
	
	public String salvar() {
		MoedaDao.salvar(moeda);
		moeda = new Moeda();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Moeda salva com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return null;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}

	public List<Moeda> getLista() {
		lista = MoedaDao.listar();
		return lista;
	}

	public void setLista(List<Moeda> lista) {
		this.lista = lista;
	}
	
}
