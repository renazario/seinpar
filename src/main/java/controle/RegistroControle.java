/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Academico;
import entidade.Registro;
import facade.AbstractFacade;
import facade.RegistroFacade;
import facade.academicoFacade;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author renan
 */
@SessionScoped
@ManagedBean
public class RegistroControle extends AbstractControle<Registro> implements Serializable {

    @EJB
    private RegistroFacade registroEJB;
    @EJB
    private academicoFacade academicoEJB;
    private Academico academico;
    private String ra;

    public RegistroControle() {
        super(Registro.class);
    }

    @Override
    protected AbstractFacade<Registro> getFacade() {
        return registroEJB;
    }

//    public void carregaAluno() throws Exception {
//        System.out.println(ra);
//        academico = new Academico();
//        academico = academicoEJB.retornaAcademico(ra);
//        System.out.println(academico.getNome());
//
//    }
    public void carregaAluno() {
        try {
            if (academico == null) {
                academico = academicoEJB.retornaAcademico(ra);
            } else {
                if (academico.getParticipando()) {
                    super.getEntidade().setNome(academico.getNome());
                    super.getEntidade().setRa(academico.getRa());
                    super.getEntidade().setSerie(academico.getSerie().toString());
                    super.getEntidade().setDtMovimentacao(new Date());
                    super.getEntidade().setTipo("S");
                    academico.setParticipando(false);
                } else {
                    super.getEntidade().setNome(academico.getNome());
                    super.getEntidade().setRa(academico.getRa());
                    super.getEntidade().setDtMovimentacao(new Date());
                    super.getEntidade().setSerie(academico.getSerie().toString());
                    super.getEntidade().setTipo("E");
                    academico.setParticipando(true);
                }
                academicoEJB.salvar(academico);
                super.salvar();
                limpar();
            }
        } catch (Exception ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    ex.getMessage(), "");
            FacesContext
                    .getCurrentInstance().addMessage(null, message);
            ex.printStackTrace();
        }

    }

    public void limpar() throws Exception {
        academico = null;
        ra = null;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public RegistroFacade getRegistroEJB() {
        return registroEJB;
    }

    public void setRegistroEJB(RegistroFacade registroEJB) {
        this.registroEJB = registroEJB;
    }

    public academicoFacade getAcademicoEJB() {
        return academicoEJB;
    }

    public void setAcademicoEJB(academicoFacade academicoEJB) {
        this.academicoEJB = academicoEJB;
    }

    public Academico getAcademico() {
        return academico;
    }

    public void setAcademico(Academico academico) {
        this.academico = academico;
    }

}
