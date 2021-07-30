package hu.ulyssys.course.homework.mbean;

import hu.ulyssys.course.homework.entities.Author;
import hu.ulyssys.course.homework.service.AuthorService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class AuthorCRUDMbean implements Serializable {

    private List<Author> list;
    private Author selectedAuthor;

    private boolean inFunction;

    private AuthorService authorService;

    @Inject
    public AuthorCRUDMbean(AuthorService authorService) {
        this.authorService = authorService;
        list = authorService.getAll();
        selectedAuthor = new Author();
    }

    public void initSave() {
        selectedAuthor = new Author();
        inFunction = true;
    }

    public void initEdit(Author author) {
        selectedAuthor = author;
        inFunction = true;
    }

    public void save() {
        if (selectedAuthor.getId() == null) {
            selectedAuthor.setId(System.currentTimeMillis());
            selectedAuthor.setCreatedDate(new Date());
            authorService.add(selectedAuthor);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            authorService.update(selectedAuthor);
            selectedAuthor.setLastModifiedDate(new Date());
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
        }
        inFunction = false;
    }

    public void remove(Author author) {
        authorService.remove(author);
        list = authorService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));

    }

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}
